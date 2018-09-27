package moon.middle.designpattern.singleton;

/**
 * 枚举：单例模式
 * <p>
 * 借助 JDK1.5 中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 * 
 * @author TobiasCui
 * @date 2018年9月27日 下午3:21:10
 * 
 */
public enum SingletonEnum {
	INSTANCE;

	public void someMethod() {

	}
}
