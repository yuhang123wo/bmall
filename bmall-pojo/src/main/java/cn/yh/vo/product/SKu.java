/**
 * 
 */
package cn.yh.vo.product;

import java.util.List;

/**
 * @author yuhang
 * @date   2019年7月30日 
 * @desc   
 */
public class SKu {

	private List<SKuProps> list;
	
	private List<SkuValues> values;

	public List<SKuProps> getList() {
		return list;
	}

	public void setList(List<SKuProps> list) {
		this.list = list;
	}

	public List<SkuValues> getValues() {
		return values;
	}

	public void setValues(List<SkuValues> values) {
		this.values = values;
	}
	
	
	
}
