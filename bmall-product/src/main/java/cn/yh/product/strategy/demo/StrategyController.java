/**
 * 
 */
package cn.yh.product.strategy.demo;

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
	PayService payService;

	@RequestMapping("/strategy")
	@ResponseBody
	public String strategy(@RequestParam("key") String key) {
		//策略模式中不能使用事务
		payService.strategy(key);
		return "xxx";
	}
}
