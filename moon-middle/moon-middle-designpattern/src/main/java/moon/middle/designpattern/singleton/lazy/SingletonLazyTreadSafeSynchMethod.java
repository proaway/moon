package moon.middle.designpattern.singleton.lazy;

/**
 * 懒汉式：线程安全，同步方法(不推荐)
 * <p>
 * 解决 {@code SingletonLazyTreadUnsafe} 实现方式的线程不安全问题，对getInstance() 做个线程同步就可以了。
 * <p>
 * 缺点：同步效率低，每个线程在想获得类的实例时候，执行 getInstance()
 * 方法都要进行同步。而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接 return 就行了。
 * 
 * @author TobiasCui
 * @date 2018年9月27日 上午11:14:17
 * 
 */
public class SingletonLazyTreadSafeSynchMethod {
	private static SingletonLazyTreadSafeSynchMethod instance;

	private SingletonLazyTreadSafeSynchMethod() {
	}

	public static synchronized SingletonLazyTreadSafeSynchMethod getInstance() {
		if (instance == null) {
			instance = new SingletonLazyTreadSafeSynchMethod();
		}
		return instance;
	}
}
