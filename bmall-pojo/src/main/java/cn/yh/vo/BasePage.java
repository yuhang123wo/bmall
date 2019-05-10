/**
 * 
 */
package cn.yh.vo;

/**
 * @author yuhang
 * @date 2019年5月8日
 * @desc
 */
public class BasePage {

	private int pageNo = 1;

	private int pageSize = 20;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
