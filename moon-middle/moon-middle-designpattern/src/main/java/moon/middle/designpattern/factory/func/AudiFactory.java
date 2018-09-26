package moon.middle.designpattern.factory.func;

import moon.middle.designpattern.factory.bean.AudiCar;
import moon.middle.designpattern.factory.bean.Car;

public class AudiFactory implements Factory {

	@Override
	public Car getCar() {
		return new AudiCar();
	}

}
