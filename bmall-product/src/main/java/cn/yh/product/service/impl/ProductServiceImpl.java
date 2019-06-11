package cn.yh.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.yh.pojo.product.Product;
import cn.yh.pojo.product.ProductAttr;
import cn.yh.pojo.product.ProductAttrValue;
import cn.yh.pojo.product.ProductProps;
import cn.yh.product.mapper.ProductAttrMapper;
import cn.yh.product.mapper.ProductAttrValueMapper;
import cn.yh.product.mapper.ProductMapper;
import cn.yh.product.service.IProductService;
import cn.yh.util.ConvertUtil;
import cn.yh.vo.product.AddProductVo;
import cn.yh.vo.product.AttrVo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-05-15
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductAttrMapper productAttrMapper;
	@Autowired
	private ProductAttrValueMapper roductAttrValueMapper;

	@Override
	public void addProudct(AddProductVo p) {
		Product product = ConvertUtil.convert(p, Product.class);
		productMapper.insert(product);
		// 新增属性
		List<AttrVo> list = p.getAttrVo();
		for (int i = 0; i < list.size(); i++) {
			AttrVo v = list.get(i);
			ProductProps props = new ProductProps();
			ProductAttr attr = productAttrMapper.selectById(v.getAttrId());
			props.setAttrId(attr.getId());
			props.setAttrName(attr.getName());
			props.setCreateTime(new Date());
			props.setProductId(product.getId());
			
//			ProductAttr attr = productAttrMapper.selectById(v.getAttrId());
//			props.setValueId(valueId);
//			props.setValueName(valueName);
		}

	}

}
