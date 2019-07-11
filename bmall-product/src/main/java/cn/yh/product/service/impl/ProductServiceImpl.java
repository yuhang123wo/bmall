package cn.yh.product.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.eumn.ProductState;
import cn.yh.pojo.eumn.State;
import cn.yh.pojo.product.Attr;
import cn.yh.pojo.product.Brand;
import cn.yh.pojo.product.Category;
import cn.yh.pojo.product.PRelaAttr;
import cn.yh.pojo.product.PRelaProps;
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
import cn.yh.product.service.IProductDetailService;
import cn.yh.product.service.IProductService;
import cn.yh.product.service.IProductSkuService;
import cn.yh.product.service.ISpecService;
import cn.yh.st.common.exception.DefaultException;
import cn.yh.vo.product.AddProductAttrVo;
import cn.yh.vo.product.AddProductSkuVo;
import cn.yh.vo.product.AddProductVo;
import cn.yh.vo.product.SkuVo;

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

	@Transactional
	@Override
	public void addProduct(AddProductVo vo) {
		// 先验证
		Category category = categoryService.getById(vo.getCategoryId());
		if (category == null || category.getState() == State.DISABLE) {
			throw new DefaultException("分类不存在");
		}
		List<AddProductAttrVo> list = vo.getAttrValueList();
		List<PRelaAttr> attrList = new ArrayList<PRelaAttr>();
		for (int i = 0; i < list.size(); i++) {
			AddProductAttrVo v = list.get(i);
			Attr attr = attrService.getById(v.getAttrId());
			if (attr == null || attr.getState() == State.DISABLE) {
				throw new DefaultException("属性不存在或已经被禁用");
			}
			if (category.getId().longValue() != attr.getCategoryId().longValue()) {
				throw new DefaultException("属性不属于该分类");
			}
//			AttrValue attrValue = attrValueService.getById(v.getValueId());
//			if (attrValue == null || attrValue.getState() == State.DISABLE
//					|| attrValue.getAttrId().longValue() != attr.getId()) {
//				throw new DefaultException("属性值不存在或被禁用");
//			}
//			PRelaAttr pa = new PRelaAttr();
//			pa.setAttrId(v.getAttrId());
//			pa.setAttrName(attr.getName());
//			pa.setvName(attrValue.getvName());
//			pa.setvId(attrValue.getId());
//			attrList.add(pa);
		}

		List<AddProductSkuVo> listSkuVo = vo.getSkuList();
		List<ProductSku> skuList = new ArrayList<ProductSku>();
		for (int i = 0; i < listSkuVo.size(); i++) {
			AddProductSkuVo v = listSkuVo.get(i);
			ProductSku productSku = new ProductSku();
			for (SkuVo skus : v.getSku()) {
				Spec spec = specService.getById(skus.getSpecId());
				if (spec == null || spec.getState() == State.DISABLE) {
					throw new DefaultException("规格不存在");
				}
				if (category.getId().longValue() != spec.getCategoryId().longValue()) {
					throw new DefaultException("规格不属于该分类");
				}
//				SpecValue value = specValueService.getById(skus.getSpecValueId());
//				if (value == null || value.getState() == State.DISABLE
//						|| value.getSpecId().longValue() != spec.getId().longValue()) {
//					throw new DefaultException("规格值不存在");
//				}

//				skus.setSpecName(spec.getName());
//				skus.setSpecValueName(value.getvName());
			}

			productSku.setCreateTime(new Date());
			productSku.setData(JSONArray.toJSONString(v.getSku()));
			productSku.setImg(v.getImg());
			productSku.setPrice(new BigDecimal(v.getPrice()));
			productSku.setState(State.ENABLE);
			productSku.setStock(v.getStock());
			productSku.setUpdateTime(productSku.getCreateTime());
			skuList.add(productSku);
		}
		// 1。新增product
		Product p = new Product();
		Brand brand = brandService.getById(vo.getBrandId());
		if (brand != null && brand.getState() == State.ENABLE) {
			p.setBrandId(brand.getId());
			p.setBrandName(brand.getName());
		}
		p.setCategoryId(category.getId());
		p.setCreateTime(new Date());
		p.setImg(vo.getImg());
		p.setKeywords(vo.getKeywords());
		p.setMarketPrice(new BigDecimal(vo.getMarketPrice()));
		p.setName(vo.getName());
		p.setPno(vo.getPno());
		p.setPrice(new BigDecimal(vo.getPrice()));
		p.setState(ProductState.UNAUDIT);
		p.setStatus(vo.getStatus());
		p.setStock(vo.getStock());
		p.setTags(vo.getTags());
		p.setUpdateTime(p.getCreateTime());
		p.setUserId(vo.getUserId());
		p.setVideo(vo.getVideo());
		p.setWeight(vo.getWeight());
		p.setWeightUnit(vo.getWeightUnit());
		boolean flag = this.save(p);
		if (!flag) {
			throw new DefaultException("新增商品失败");
		}
		// 2.添加商品详情
		ProductDetail detail = new ProductDetail();
		detail.setDescription(vo.getDescription());
		detail.setImgs(JSONArray.toJSONString(vo.getImages()));
		detail.setId(p.getId());
		boolean detailFlag = productDetailService.save(detail);
		if (!detailFlag) {
			throw new DefaultException("新增商品详情失败");
		}
		// 3.添加属性
		if (!CollectionUtils.isEmpty(attrList)) {
			for (int i = 0; i < attrList.size(); i++) {
				PRelaAttr pra = attrList.get(i);
				pra.setProductId(p.getId());
			}
			boolean pflag = pRelaAttrService.saveBatch(attrList, attrList.size());
			if (!pflag) {
				throw new DefaultException("新增商品属性失败");
			}
		}
		// 4.添加参数
		if (!CollectionUtils.isEmpty(vo.getProps())) {
			List<PRelaProps> ps = new ArrayList<PRelaProps>();
			for (int i = 0; i < vo.getProps().size(); i++) {
				String props = vo.getProps().get(i);
				PRelaProps pp = new PRelaProps();
				pp.setCreateTime(new Date());
				pp.setData(props);
				pp.setProductId(p.getId());
				pp.setUpdateTime(p.getCreateTime());
				ps.add(pp);
			}
			boolean ppFlag = pRelaPropsService.saveBatch(ps, ps.size());
			if (!ppFlag) {
				throw new DefaultException("新增商品参数失败");
			}
		}
		// 5.添加sku
		if (!CollectionUtils.isEmpty(skuList)) {
			for (ProductSku psKu : skuList) {
				psKu.setProductId(p.getId());
			}
			boolean skuFlag = productSkuService.saveBatch(skuList, skuList.size());

			if (!skuFlag) {
				throw new DefaultException("新增商品SKU失败");
			}
		}
	}

}
