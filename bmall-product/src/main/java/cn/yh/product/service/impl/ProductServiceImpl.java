package cn.yh.product.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.eumn.ProductState;
import cn.yh.pojo.eumn.ProductStatus;
import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Attr;
import cn.yh.pojo.product.Brand;
import cn.yh.pojo.product.Category;
import cn.yh.pojo.product.PRelaAttr;
import cn.yh.pojo.product.PRelaProps;
import cn.yh.pojo.product.PRelaSpec;
import cn.yh.pojo.product.Product;
import cn.yh.pojo.product.ProductDetail;
import cn.yh.pojo.product.ProductSku;
import cn.yh.pojo.product.Spec;
import cn.yh.product.mapper.ProductMapper;
import cn.yh.product.service.IAttrService;
import cn.yh.product.service.IBrandService;
import cn.yh.product.service.ICategoryService;
import cn.yh.product.service.IPRelaAttrService;
import cn.yh.product.service.IPRelaPropsService;
import cn.yh.product.service.IPRelaSpecService;
import cn.yh.product.service.IProductDetailService;
import cn.yh.product.service.IProductService;
import cn.yh.product.service.IProductSkuService;
import cn.yh.product.service.ISpecService;
import cn.yh.st.common.exception.DefaultException;
import cn.yh.vo.es.ProductSearchVo;
import cn.yh.vo.product.AddProductVo;
import cn.yh.vo.product.PAttr;
import cn.yh.vo.product.Pprops;
import cn.yh.vo.product.SKu;
import cn.yh.vo.product.SKuProps;
import cn.yh.vo.product.SkuValues;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-06-12
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

	@Autowired
	private IBrandService brandService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IProductDetailService productDetailService;
	@Autowired
	private IPRelaAttrService pRelaAttrService;
	@Autowired
	private IAttrService attrService;
	@Autowired
	private ISpecService specService;
	@Autowired
	private IPRelaPropsService pRelaPropsService;
	@Autowired
	private IProductSkuService productSkuService;
	@Autowired
	private IPRelaSpecService pRelaSpecService;
	@Autowired
	private JmsTemplate jmsTemplate;

	@Transactional
	@Override
	public void addProduct(AddProductVo vo) {
		Product p = new Product();
		// 先验证
		Category category = categoryService.getById(vo.getCategoryId());
		if (category == null || category.getState() == State.DISABLE) {
			throw new DefaultException("分类不存在");
		}
		Brand brand = brandService.getById(vo.getBrandId());
		if (category != null && category.getState() == State.DISABLE) {
			throw new DefaultException("品牌不存在");
		}
		if (brand != null) {
			p.setBrandId(brand.getId());
			p.setBrandName(brand.getName());
		}
		p.setCategoryId(category.getId());
		p.setCreateTime(new Date());
		p.setImg(vo.getImg());
		p.setKeywords(vo.getKeywords());
		p.setMarketPrice(BigDecimal.ZERO);
		p.setName(vo.getName());
		p.setPno(vo.getPno());
		p.setPrice(BigDecimal.ZERO);
		p.setState(ProductState.UNAUDIT);
		p.setStatus(ProductStatus.OFF);
		p.setTags(vo.getTags());
		p.setUpdateTime(p.getCreateTime());
		p.setUserId(vo.getUserId());
		p.setVideo(vo.getVideo());
		p.setWeight(vo.getWeight());
		p.setWeightUnit(vo.getWeightUnit());
		// 商品属性
		List<PAttr> attrList = vo.getAttrList();
		List<PRelaAttr> list1 = new ArrayList<PRelaAttr>();
		if (!CollectionUtils.isEmpty(attrList)) {
			for (int i = 0; i < attrList.size(); i++) {
				PAttr atrr = attrList.get(i);
				PRelaAttr pa = new PRelaAttr();
				Attr a = attrService.getById(atrr.getId());
				if (a == null) {
					throw new DefaultException("属性不存在");
				}
				pa.setAttrId(a.getId());
				pa.setAttrName(a.getName());
				pa.setvName(atrr.getValues());
				list1.add(pa);
			}
		}
		// 商品参数
		List<Pprops> propsList = vo.getPropsList();
		List<PRelaProps> list2 = new ArrayList<PRelaProps>();
		if (!CollectionUtils.isEmpty(propsList)) {
			for (int i = 0; i < propsList.size(); i++) {
				PRelaProps prp = new PRelaProps();
				Pprops pp = propsList.get(i);
				prp.setData(JSON.toJSONString(pp));
				list2.add(prp);
			}
		}
		// 商品sku
		SKu sku = vo.getSku();
		List<ProductSku> productSkuList = new ArrayList<ProductSku>();
		List<PRelaSpec> specList = new ArrayList<PRelaSpec>();
		if (sku != null) {
			List<SKuProps> skuPs = sku.getList();
			for (int i = 0; i < skuPs.size(); i++) {
				SKuProps sp = skuPs.get(i);
				Spec spec = specService.getById(sp.getId());
				if (spec == null) {
					throw new DefaultException("sku不存在");
				}
				for (String v : sp.getValues()) {
					PRelaSpec ps = new PRelaSpec();
					ps.setSpecId(sp.getId());
					ps.setSpecName(spec.getName());
					ps.setvName(v);
					specList.add(ps);
				}
			}
			List<SkuValues> skuVs = sku.getValues();
			for (int i = 0; i < skuVs.size(); i++) {
				ProductSku psku = new ProductSku();

				SkuValues v = skuVs.get(i);
				psku.setCreateTime(new Date());
				psku.setData(v.getSku());
				psku.setPrice(new BigDecimal(v.getPrice()));
				psku.setImg(v.getImg());
				psku.setState(State.ENABLE);
				psku.setStock(v.getStock());
				psku.setUpdateTime(psku.getCreateTime());
				productSkuList.add(psku);
			}
		}
		// 开始保存数据
		int n = baseMapper.insert(p);
		if (n != 1) {
			throw new DefaultException("系统异常稍后试");
		}
		for (PRelaAttr s : list1) {
			s.setProductId(p.getId());
		}
		boolean flag1 = pRelaAttrService.saveBatch(list1, list1.size());
		if (!flag1) {
			throw new DefaultException("系统异常稍后试");
		}

		for (PRelaProps s : list2) {
			s.setProductId(p.getId());
		}
		boolean flag2 = pRelaPropsService.saveBatch(list2, list2.size());
		if (!flag2) {
			throw new DefaultException("系统异常稍后试");
		}

		for (ProductSku s : productSkuList) {
			s.setProductId(p.getId());
		}
		boolean flag3 = productSkuService.saveBatch(productSkuList, productSkuList.size());
		if (!flag3) {
			throw new DefaultException("系统异常稍后试");
		}

		for (PRelaSpec s : specList) {
			s.setProductId(p.getId());
		}
		boolean flag4 = pRelaSpecService.saveBatch(specList, specList.size());
		if (!flag4) {
			throw new DefaultException("系统异常稍后试");
		}
		ProductDetail detail = new ProductDetail();
		if (StringUtils.isNotBlank(vo.getDetail())) {
		
			detail.setDescription(vo.getDetail());
			detail.setId(p.getId());

			boolean flag5 = productDetailService.save(detail);
			if (!flag5) {
				throw new DefaultException("系统异常稍后试");
			}
		}
		
		ProductSearchVo psv = new ProductSearchVo();
		psv.setProduct(p);
		psv.setAttrList(list1);
		psv.setDetail(detail);
		psv.setPropsList(list2);
		psv.setSkuList(productSkuList);
		psv.setSpecList(specList);
		psv.setCategory(category);
		jmsTemplate.convertAndSend("product:add",psv);
	}

 
}
