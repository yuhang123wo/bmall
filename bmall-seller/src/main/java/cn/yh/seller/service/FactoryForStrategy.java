/**
 * 
 */
package cn.yh.seller.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuhang
 * @date 2019年9月16日
 * @desc
 */
@Service
public class FactoryForStrategy {
	@Autowired
	Map<String, Strategy> strategys = new ConcurrentHashMap<>(3);

	public Strategy getStrategy(String component) throws Exception {
		Strategy strategy = strategys.get(component);
		if (strategy == null) {
			throw new RuntimeException("no strategy defined");
		}
		return strategy;
	}
	
}
