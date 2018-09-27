package moon.middle.designpattern.singleton.lazy;

/**
 * 懒汉式：线程不安全(不推荐)
 * <p>
 * 这种写法起到了 Lazy Loading 的效果，但只能在单线程下使用。如果在多线程下，一个线程进入了 if (singleton == null)
 * 判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式。
 * 
 * @author TobiasCui
 * @date 2018年9月27日 上午11:14:17
 * 
 */
public class SingletonLazyTreadUnsafe {
	private static SingletonLazyTreadUnsafe instance;

	private SingletonLazyTreadUnsafe() {
	}

	public static SingletonLazyTreadUnsafe getInstance() {
		if (instance == null) {
			instance = new SingletonLazyTreadUnsafe();
		}
		return instance;
	}
}
