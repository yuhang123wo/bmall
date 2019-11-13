/**
 * 
 */
package cn.yh.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yuhang
 * @date 2019年9月16日
 * @desc
 */
@Controller
public class StrategyController {
	@Autowired
	FactoryForStrategy factoryForStrategy;

	@RequestMapping("/strategy")
	@ResponseBody
	public String strategy(@RequestParam("key") String key) {
		String result;
		try {
			result = factoryForStrategy.getStrategy(key).doOperation();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}
}
