package moon.middle.designpattern.singleton.lazy;

/**
 * 懒汉式：同步代码块，但不能解决线程同步问题(不推荐)
 * <p>
 * 由于 {@code SingletonLazyTreadSafeSynchMethod}
 * 实现方式同步效率低，所以摒弃同步方法，改为同步产生实例化的的代码块。
 * <p>
 * 但是这种同步并不能起到线程同步的作用。 跟{@code SingletonLazyTreadUnsafe} 实现方式遇到的情形一致，假如一个线程进入了
 * if (singleton == null) 判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
 * 
 * 
 * @author TobiasCui
 * @date 2018年9月27日 上午11:14:17
 * 
 */
public class SingletonLazyTreadUnsafeSynchBlock {
	private static SingletonLazyTreadUnsafeSynchBlock instance;

	private SingletonLazyTreadUnsafeSynchBlock() {
	}

	public static SingletonLazyTreadUnsafeSynchBlock getInstance() {
		if (instance == null) {
			synchronized (SingletonLazyTreadUnsafeSynchBlock.class) {
				instance = new SingletonLazyTreadUnsafeSynchBlock();
			}
		}
		return instance;
	}
}
