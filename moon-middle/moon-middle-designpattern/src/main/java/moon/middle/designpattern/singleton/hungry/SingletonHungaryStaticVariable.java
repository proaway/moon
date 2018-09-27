package moon.middle.designpattern.singleton.hungry;

/**
 * 饿汉式：静态常量(推荐)
 * <p>
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 * <p>
 * 缺点：在类装载的时候就完成实例化，没有达到 Lazy Loading 的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 * 
 * @author TobiasCui
 * @date 2018年9月27日 上午11:14:17
 * 
 */
public class SingletonHungaryStaticVariable {
	private final static SingletonHungaryStaticVariable INSTANCE = new SingletonHungaryStaticVariable();

	private SingletonHungaryStaticVariable() {
	}

	public static SingletonHungaryStaticVariable getInstance() {
		return INSTANCE;
	}
}
