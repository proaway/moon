package moon.middle.designpattern.strategy;

/**
 * 乘客
 * 
 * @author TobiasCui
 * @date 2018年9月27日 下午4:43:03
 * 
 */
public class Traveller {
	private double money = 0.0d;
	/** 默认步行 */
	private TravelStrategy travelStrategy = new TravelStrategyWalk();

	public Traveller(double money) {
		this.money = money;
	}

	/**
	 * 选择交通工具：根据乘客手头的现金，选择（实现）不同的交通工具
	 * 
	 * @author TobiasCui
	 * @date 2018年9月27日 下午5:06:26
	 * 
	 * @param money
	 *            乘客手头的现金
	 * @return
	 */
	public String getVehicle() {
		if (this.money == 0) {
			travelStrategy = new TravelStrategyWalk();
		}
		if (this.money > 0 && this.money <= 10) {
			travelStrategy = new TravelStrategyBicycle();
		}
		if (this.money > 10 && this.money <= 250) {
			travelStrategy = new TravelStrategyCar();
		}
		if (this.money > 250) {
			travelStrategy = new TravelStrategyAirplane();
		}
		return travelStrategy.travelVehicle();
	}

}
