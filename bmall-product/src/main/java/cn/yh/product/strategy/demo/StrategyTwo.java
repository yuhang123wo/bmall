/**
 * 
 */
package cn.yh.product.strategy.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * @author yuhang
 * @date 2019年9月16日
 * @desc
 */
@Component("two")
@HanderType(orderType = OrderType.B)
public class StrategyTwo implements Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yh.seller.service.Strategy#doOperation()
	 */
	@Override
	public String doOperation() {
		List<String> list2 = new ArrayList<>();
		list2.add("aaa bbb ccc");
		list2.add("ddd eee fff");
		list2.add("ggg hhh iii");
//
//		list2.sort(new Comparator<T>() {
//		});
		return null;
	}

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

		long n = strings.parallelStream().filter(e -> e.contains("a")).count();

		System.out.println(n);
	}

}
