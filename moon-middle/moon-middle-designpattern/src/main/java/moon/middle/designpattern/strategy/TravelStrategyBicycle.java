package moon.middle.designpattern.strategy;

/**
 * 具体策略类：自行车
 * 
 * @author TobiasCui
 * @date 2018年9月27日 下午3:43:33
 * 
 */
public class TravelStrategyBicycle implements TravelStrategy {

	@Override
	public String travelVehicle() {
		return "乘坐自行车";
	}

}
