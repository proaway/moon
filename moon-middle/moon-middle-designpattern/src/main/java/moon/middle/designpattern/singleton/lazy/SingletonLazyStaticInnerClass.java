package moon.middle.designpattern.singleton.lazy;

/**
 * 饿汉式：静态内部类(推荐)
 * <p>
 * 这种方式跟饿汉式方式采用的机制类似，但又有不同。<br/>
 * 相同：两者都是采用了类装载的机制来保证初始化实例时只有一个线程；<br/>
 * 不同：不同的地方在饿汉式方式是只要 Singleton类被装载就会实例化，没有 Lazy-Loading 的作用，而静态内部类方式在 Singleton
 * 类被装载时并不会立即实例化，而是在需要实例化时，调用 getInstance 方法，才会装载 SingletonInstance 类，从而完成
 * Singleton 的实例化。
 * <p>
 * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM 帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 * 
 * 优点：避免了线程不安全，延迟加载，效率高。
 * 
 * @author TobiasCui
 * @date 2018年9月27日 上午11:14:17
 * 
 */
public class SingletonLazyStaticInnerClass {

	private SingletonLazyStaticInnerClass() {
	}

	private static class SingletonInstance {
		private final static SingletonLazyStaticInnerClass INSTANCE = new SingletonLazyStaticInnerClass();
	}

	public static SingletonLazyStaticInnerClass getInstance() {
		return SingletonInstance.INSTANCE;
	}
}
