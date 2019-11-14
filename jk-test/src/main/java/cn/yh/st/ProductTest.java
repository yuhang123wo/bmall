/**
 * 
 */
package cn.yh.st;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSON;

import cn.yh.pojo.eumn.State;
import cn.yh.vo.product.AddAttrVo;
import cn.yh.vo.product.UpdateStateVO;

/**
 * @author yuhang
 * @date 2019年11月14日
 * @desc
 */
public class ProductTest {

	String testApi = "http://127.0.0.1:8003/";

	public static void main(String[] args) throws ClientProtocolException, IOException {
		ProductTest test = new ProductTest();
//		String result = test.testAddAttrAndValue();
		String result = test.testUpdateAttrState();
		System.out.println(result);

	}

	public String testAddAttrAndValue() throws ClientProtocolException, IOException {
		String uri = testApi + "attr/addAttrAndValue";
		AddAttrVo vo = new AddAttrVo();
		vo.setCategoryId(1L);
//		vo.setName("11");
		vo.setUserId(1L);
		List<String> strs = new ArrayList<String>();
		strs.add("a");
		vo.setList(strs);
		return PostUtil.postJson(uri, JSON.toJSONString(vo));
	}

	public String testUpdateAttrState() throws ClientProtocolException, IOException {
		String uri = testApi + "attr/updateAttrState";
		UpdateStateVO vo = new UpdateStateVO();
		vo.setId(1L);
		vo.setState(State.DISABLE);
		return PostUtil.postJson(uri, JSON.toJSONString(vo));
	}
}
