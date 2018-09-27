package moon.middle.designpattern.strategy;

/**
 * 具体策略类：汽车
 * 
 * @author TobiasCui
 * @date 2018年9月27日 下午3:43:26
 * 
 */
public class TravelStrategyCar implements TravelStrategy {

	@Override
	public String travelVehicle() {
		return "乘坐汽车";
	}

}
