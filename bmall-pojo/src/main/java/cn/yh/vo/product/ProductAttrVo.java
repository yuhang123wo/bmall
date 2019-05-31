/**
 * 
 */
package cn.yh.vo.product;

import java.util.List;

import cn.yh.pojo.product.ProductAttr;
import cn.yh.pojo.product.ProductAttrValue;

/**
 * @author yuhang
 * @date 2019年5月30日
 * @desc
 */
public class ProductAttrVo extends ProductAttr {

	private List<ProductAttrValue> list;

	public List<ProductAttrValue> getList() {
		return list;
	}

	public void setList(List<ProductAttrValue> list) {
		this.list = list;
	}

}
