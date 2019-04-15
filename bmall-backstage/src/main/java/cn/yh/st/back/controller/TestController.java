/**
 * 
 */
package cn.yh.st.back.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yh.st.back.service.UserService;

/**
 * @author yuhang
 * @date 2019年4月15日
 * @desc
 */
@RestController
@RequestMapping("test")
public class TestController {

	@Value("${server.port}")
	private String port;

	@Autowired
	private UserService userService;

	@PostConstruct
	public void getTest() {
		System.out.println(port);

		System.out.println(userService.sayHiFromClientOne(1L));
	}
}
