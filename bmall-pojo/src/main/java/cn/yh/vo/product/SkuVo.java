/**
 * 
 */
package cn.yh.vo.product;

import javax.validation.constraints.NotNull;

/**
 * @author yuhang
 * @date 2019年6月14日
 * @desc
 */
public class SkuVo {

	@NotNull
	private long specId;
	private String specName;
	@NotNull
	private long specValueId;
	private String specValueName;

	public long getSpecId() {
		return specId;
	}

	public void setSpecId(long specId) {
		this.specId = specId;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public long getSpecValueId() {
		return specValueId;
	}

	public void setSpecValueId(long specValueId) {
		this.specValueId = specValueId;
	}

	public String getSpecValueName() {
		return specValueName;
	}

	public void setSpecValueName(String specValueName) {
		this.specValueName = specValueName;
	}

}
