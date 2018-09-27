package moon.middle.designpattern.template;

/**
 * 模版模式：
 * <p>
 * 抽象父类（AbstractClass）：实现了模板方法，定义了算法的骨架。<br/>
 * 具体类（ConcreteClass)：实现抽象类中的抽象方法，即不同的对象的具体实现细节。
 * <p>
 * 烹饪模版类
 * 
 * @author TobiasCui
 * @date 2018年9月27日 下午6:06:39
 * 
 */
public abstract class CookTemplate {

	/**
	 * 具体的步骤：只能被自己和自己的子类调用
	 * 
	 * @author TobiasCui
	 * @date 2018年9月27日 下午6:10:58
	 * 
	 */
	protected void cook() {
		this.prepare();
		this.cooking();
		this.dishUp();
	}

	/**
	 * 准备食材
	 * 
	 * @author TobiasCui
	 * @date 2018年9月27日 下午6:09:33
	 * 
	 */
	public abstract void prepare();

	/**
	 * 烹调
	 * 
	 * @author TobiasCui
	 * @date 2018年9月27日 下午6:09:40
	 * 
	 */
	public abstract void cooking();

	/**
	 * 装盘
	 * 
	 * @author TobiasCui
	 * @date 2018年9月27日 下午6:09:52
	 * 
	 */
	public abstract void dishUp();
}
