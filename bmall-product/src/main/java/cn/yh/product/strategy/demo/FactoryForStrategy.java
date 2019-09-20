/**
 * 
 */
package cn.yh.product.strategy.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yuhang
 * @date 2019年9月16日
 * @desc
 */
@Component
public class FactoryForStrategy {
	@Autowired
	Map<String, Strategy> strategys = new ConcurrentHashMap<>(3);

	Map<OrderType, Strategy> ge = new ConcurrentHashMap<>();

	public FactoryForStrategy() {
		strategys.forEach((k, v) -> {
			HanderType type = v.getClass().getAnnotation(HanderType.class);
			ge.put(type.orderType(), v);

		});
	}

	public Strategy getStrategy(OrderType orderType) throws Exception {
		Strategy strategy = ge.get(orderType);
		if (strategy == null) {
			throw new RuntimeException("no strategy defined");
		}
		return strategy;
	}

}
