package moon.middle.designpattern.factory.func;

import moon.middle.designpattern.factory.bean.Car;

/**
 * 工厂模式 接口
 * 
 * @author TobiasCui
 * @date 2018年9月26日 下午4:02:29
 * 
 */
public interface Factory {

	/**
	 * 生产汽车接口
	 * 
	 * @author TobiasCui
	 * @date 2018年9月26日 下午4:03:43
	 * 
	 * @return
	 */
	Car getCar();
}
