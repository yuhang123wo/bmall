/**
 * 
 */
package cn.yh.seller.service;

import org.springframework.stereotype.Component;

import groovy.util.logging.Commons;

/**
 * @author yuhang
 * @date 2019年9月16日
 * @desc
 */
@Component("one")
public class StrategyOne implements Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.yh.seller.service.Strategy#doOperation()
	 */
	@Override
	public String doOperation() {
		System.out.println("one");
		return null;
	}

}
