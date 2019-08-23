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
public class SpecEs {
	@Field(type = FieldType.Long)
	private Long specId;

	@Field(type = FieldType.Keyword)
	private String specName;

	@Field(type = FieldType.Keyword)
	private String vName;

	@Field(type = FieldType.Long)
	private Long productId;

	public Long getSpecId() {
		return specId;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
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
