/**
 * 
 */
package cn.yh.vo.product;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yuhang
 * @date 2019年6月12日
 * @desc
 */
public class AddAttrValueVo {

	@NotNull
	private Long attrId;

	@NotEmpty
	private List<String> list;

	public Long getAttrId() {
		return attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
