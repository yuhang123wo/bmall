/**
 * 
 */
package cn.yh.st.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yh.st.back.service.UserService;

/**
 * @author yuhang
 * @date 2019年4月15日
 * @desc
 */
@Controller
@RequestMapping("test")
public class TestController {

	@Value("${server.port}")
	private String port;

	@Autowired
	private UserService userService;

	public void getTest() {
		System.out.println(port);

		System.out.println(userService.sayHiFromClientOne(1L));
	}

	@RequestMapping("index")
	public String index() {
		return "index";
	}
}
