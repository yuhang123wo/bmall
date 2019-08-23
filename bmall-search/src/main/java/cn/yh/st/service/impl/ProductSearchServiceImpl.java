/**
 * 
 */
package cn.yh.st.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import cn.yh.st.config.IndexConfig;
import cn.yh.st.es.domain.AttrEs;
import cn.yh.st.es.domain.ProductEs;
import cn.yh.st.es.domain.ProductSkuEs;
import cn.yh.st.es.domain.PropsEs;
import cn.yh.st.es.domain.SpecEs;
import cn.yh.st.service.ProductSearchService;
import cn.yh.util.ConvertUtil;
import cn.yh.vo.es.ProductSearchVo;

/**
 * @author yuhang
 * @date 2019年8月22日
 * @desc
 */
@Service
public class ProductSearchServiceImpl extends SearchServiceImpl<ProductEs> implements ProductSearchService {

	@JmsListener(destination = "product:add", containerFactory = "msgFactory")
	@Override
	public void addProductEs(ProductSearchVo vo) {
		ProductEs p = ConvertUtil.convert(vo.getProduct(), ProductEs.class);

		List<AttrEs> ae = ConvertUtil.convert(vo.getAttrList(), AttrEs.class);
		List<PropsEs> pe = ConvertUtil.convert(vo.getPropsList(), PropsEs.class);
		List<SpecEs> se = ConvertUtil.convert(vo.getSpecList(), SpecEs.class);
		List<ProductSkuEs> skuList = ConvertUtil.convert(vo.getSkuList(), ProductSkuEs.class);

		p.setCategoryName(vo.getCategory().getName());
		p.setImgs(vo.getDetail().getImgs());
		p.setDescription(vo.getDetail().getDescription());
		p.setAttrList(ae);
		p.setPropsList(pe);
		p.setSpecList(se);
		p.setSkuList(skuList);

		List<ProductEs> list = new ArrayList<ProductEs>();
        list.add(p);
		this.addProductIntoEs(list, IndexConfig.PRODUCT_INDEX);
	}

}
