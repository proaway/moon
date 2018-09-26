package moon.middle.designpattern.factory.abstr;

import moon.middle.designpattern.factory.bean.AudiCar;
import moon.middle.designpattern.factory.bean.Car;

public class DefaultFactory extends AbstractFactory {

	private Car defualtCar = new AudiCar();

	@Override
	public Car getCar() {
		return defualtCar;
	}

}
