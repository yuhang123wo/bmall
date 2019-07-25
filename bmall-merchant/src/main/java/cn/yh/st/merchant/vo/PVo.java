/**
 * 
 */
package cn.yh.st.merchant.vo;

import java.util.List;

/**
 * @author yuhang
 * @date 2019年7月24日
 * @desc
 */
public class PVo {

	private List<Fa> form1;

	private List<Fb> form2;

	private List<Nv> form3;

	private List<Fd> form4;
	private String form5;

	public List<Fa> getForm1() {
		return form1;
	}

	public void setForm1(List<Fa> form1) {
		this.form1 = form1;
	}

	public List<Fb> getForm2() {
		return form2;
	}

	public void setForm2(List<Fb> form2) {
		this.form2 = form2;
	}

	public List<Nv> getForm3() {
		return form3;
	}

	public void setForm3(List<Nv> form3) {
		this.form3 = form3;
	}

	public List<Fd> getForm4() {
		return form4;
	}

	public void setForm4(List<Fd> form4) {
		this.form4 = form4;
	}

	public String getForm5() {
		return form5;
	}

	public void setForm5(String form5) {
		this.form5 = form5;
	}

}
