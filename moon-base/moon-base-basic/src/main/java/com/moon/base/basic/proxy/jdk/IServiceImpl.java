package com.moon.base.basic.proxy.jdk;

/**
 * 目标对象
 * 
 * @author TobiasCui
 * @date 2018年9月25日 下午5:09:34
 * 
 */
public class IServiceImpl implements IService {

	@Override
	public void add() {
		System.out.println("实现类");
	}

}
