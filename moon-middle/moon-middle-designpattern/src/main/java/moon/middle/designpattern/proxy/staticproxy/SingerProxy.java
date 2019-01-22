package moon.middle.designpattern.proxy.staticproxy;

public class SingerProxy implements ISinger {
	private ISinger target;

	public SingerProxy(ISinger target) {
		this.target = target;
	}

	@Override
	public void sing() {
		System.out.println("向观众问好");
		target.sing();
		System.out.println("谢谢大家");
	}

}
