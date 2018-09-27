package moon.middle.designpattern.strategy;

/**
 * 具体策略类：飞机
 * 
 * @author TobiasCui
 * @date 2018年9月27日 下午3:43:07
 * 
 */
public class TravelStrategyAirplane implements TravelStrategy {

	@Override
	public String travelVehicle() {
		return "乘坐飞机";
	}

}
