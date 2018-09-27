package moon.middle.designpattern.template;

/**
 * 烧汤
 * 
 * @author TobiasCui
 * @date 2018年9月27日 下午6:13:13
 * 
 */
public class CookSoup extends CookTemplate {

	@Override
	public void prepare() {
		System.out.println("汤料");

	}

	@Override
	public void cooking() {
		System.out.println("熬汤");
	}

	@Override
	public void dishUp() {
		System.out.println("盛汤");
	}

}
