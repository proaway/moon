package moon.middle.designpattern.proxy.staticproxy;

public class StaticProxyTest {
	public static void main(String[] args) {
		ISinger target = new Singer();
		ISinger proxy = new SingerProxy(target);
		proxy.sing();
	}
}
