package moon.middle.designpattern.factory;

import moon.middle.designpattern.factory.func.AudiFactory;
import moon.middle.designpattern.factory.func.Factory;

public class FactoryTest {

	public static void main(String[] args) {
		Factory factory = new AudiFactory();
		System.out.println(factory.getCar());
	}

}
