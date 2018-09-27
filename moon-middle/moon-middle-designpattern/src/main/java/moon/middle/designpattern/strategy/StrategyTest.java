package moon.middle.designpattern.strategy;

public class StrategyTest {
	public static void main(String[] args) {
		Traveller traveller = new Traveller(33.5);
		String vehicle = traveller.getVehicle();
		System.out.println(vehicle);
	}
}
