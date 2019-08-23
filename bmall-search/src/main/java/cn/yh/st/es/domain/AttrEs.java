/**
 * 
 */
package cn.yh.st.es.domain;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author yuhang
 * @date 2019年8月23日
 * @desc
 */
public class AttrEs {

	@Field(type = FieldType.Long)
	private Long id;
	@Field(type = FieldType.Long)
	private Long attrId;
	@Field(type = FieldType.Keyword)
	private String attrName;
	@Field(type = FieldType.Keyword)
	private String vName;
	@Field(type = FieldType.Long)
	private Long productId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAttrId() {
		return attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
