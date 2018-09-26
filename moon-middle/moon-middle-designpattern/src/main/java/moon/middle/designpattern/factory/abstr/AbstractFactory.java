package moon.middle.designpattern.factory.abstr;

import moon.middle.designpattern.factory.bean.AudiCar;
import moon.middle.designpattern.factory.bean.BenzCar;
import moon.middle.designpattern.factory.bean.BmwCar;
import moon.middle.designpattern.factory.bean.Car;

public abstract class AbstractFactory {

	protected abstract Car getCar();

	/**
	 * 抽象类自己的业务实现
	 * 
	 * @author TobiasCui
	 * @date 2018年9月26日 下午5:38:23
	 * 
	 * @param name
	 * @return
	 */
	public Car getCar(String name) {
		if ("Audi".equals(name)) {
			return new AudiCar();
		}
		if ("Benz".equals(name)) {
			return new BenzCar();
		}
		if ("Bmw".equals(name)) {
			return new BmwCar();
		}
		return new AudiCar();
	}
}
