package moon.middle.designpattern.template;

/**
 * 做菜
 * 
 * @author TobiasCui
 * @date 2018年9月27日 下午6:13:05
 * 
 */
public class CookDishes extends CookTemplate {

	@Override
	public void prepare() {
		System.out.println("洗菜");
	}

	@Override
	public void cooking() {
		System.out.println("炒菜");
	}

	@Override
	public void dishUp() {
		System.out.println("盛菜");
	}

}
