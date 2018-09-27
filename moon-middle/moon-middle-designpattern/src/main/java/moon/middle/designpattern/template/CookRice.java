package moon.middle.designpattern.template;

/**
 * 做米饭
 * 
 * @author TobiasCui
 * @date 2018年9月27日 下午6:12:57
 * 
 */
public class CookRice extends CookTemplate {

	@Override
	public void prepare() {
		System.out.println("淘米");
	}

	@Override
	public void cooking() {
		System.out.println("蒸米");
	}

	@Override
	public void dishUp() {
		System.out.println("盛米");
	}

}
