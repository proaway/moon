package moon.middle.designpattern.singleton.lazy;

/**
 * 懒汉式：同步代码块，双重检查，线程安全(代码应该有锁的问题，推荐？？？)，
 * <p>
 * 针对 {@code SingletonLazyTreadSafeSynchMethod} 的优化；
 * <p>
 * Double-Check概念对于多线程开发者来说不会陌生，如代码中所示，我们进行了两次 if (singleton == null)
 * 检查，这样就可以保证线程安全了。这样，实例化代码只用执行一次，后面再次访问时，判断 if (singleton == null)，直接 return
 * 实例化对象。
 * 
 * 优点：线程安全；延迟加载；效率较高。
 * 
 * 
 * @author TobiasCui
 * @date 2018年9月27日 上午11:14:17
 * 
 */
public class SingletonLazyTreadSafeSynchBlockDoubleCheck {
	private static SingletonLazyTreadSafeSynchBlockDoubleCheck instance;

	private SingletonLazyTreadSafeSynchBlockDoubleCheck() {
	}

	public static SingletonLazyTreadSafeSynchBlockDoubleCheck getInstance() {
		if (instance == null) {
			/**
			 * TODO Remove this dangerous instance of double-checked locking.
			 */
			synchronized (SingletonLazyTreadSafeSynchBlockDoubleCheck.class) {
				if (instance == null) {
					instance = new SingletonLazyTreadSafeSynchBlockDoubleCheck();
				}
			}
		}
		return instance;
	}
}
