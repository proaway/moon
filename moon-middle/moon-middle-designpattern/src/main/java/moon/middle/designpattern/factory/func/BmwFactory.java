package moon.middle.designpattern.factory.func;

import moon.middle.designpattern.factory.bean.BmwCar;
import moon.middle.designpattern.factory.bean.Car;

public class BmwFactory implements Factory {

	@Override
	public Car getCar() {
		return new BmwCar();
	}

}
