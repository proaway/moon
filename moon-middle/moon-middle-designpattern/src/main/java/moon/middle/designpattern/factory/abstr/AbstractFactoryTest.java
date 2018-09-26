package moon.middle.designpattern.factory.abstr;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		DefaultFactory factory = new DefaultFactory();
		System.out.println(factory.getCar("Benz"));
	}

}
