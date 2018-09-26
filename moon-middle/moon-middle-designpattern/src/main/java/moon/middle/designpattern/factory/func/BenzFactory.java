package moon.middle.designpattern.factory.func;

import moon.middle.designpattern.factory.bean.BenzCar;
import moon.middle.designpattern.factory.bean.Car;

public class BenzFactory implements Factory {

	@Override
	public Car getCar() {
		return new BenzCar();
	}

}
