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
public class PropsEs {

	@Field(type = FieldType.Long)
	private Long productId;
	@Field(type = FieldType.Text, index = false)
	private String data;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
