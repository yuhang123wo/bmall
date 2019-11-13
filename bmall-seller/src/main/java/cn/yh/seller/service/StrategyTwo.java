/**
 * 
 */
package cn.yh.seller.service;

import org.springframework.stereotype.Component;

/**
 * @author yuhang
 * @date 2019年9月16日
 * @desc
 */
@Component("two")
public class StrategyTwo implements Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yh.seller.service.Strategy#doOperation()
	 */
	@Override
	public String doOperation() {
		System.out.println("two");
		return null;
	}

}
