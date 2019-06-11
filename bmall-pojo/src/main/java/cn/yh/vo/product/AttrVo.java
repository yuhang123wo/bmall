/**
 * 
 */
package cn.yh.vo.product;

import java.util.List;

import cn.yh.pojo.product.ProductAttrValue;

/**
 * @author yuhang
 * @date 2019年6月6日
 * @desc
 */
public class AttrVo {

	private long attrId;

	private List<ProductAttrValue> list;

	public long getAttrId() {
		return attrId;
	}

	public void setAttrId(long attrId) {
		this.attrId = attrId;
	}

	public List<ProductAttrValue> getList() {
		return list;
	}

	public void setList(List<ProductAttrValue> list) {
		this.list = list;
	}

}
