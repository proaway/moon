package moon.middle.designpattern.prototype;

import java.util.Date;

/**
 * 原型模式：原型模式就是从一个对象再创建另外一个可定制的对象，而且不需要知道任何创建的细节。
 * <p>
 * 所谓原型模式，就是java中的克隆技术，以某个对象为原型。复制出新的对象。显然新的对象具备原型对象的特点。效率高（避免了重新执行构造过程步骤）
 * 
 * 克隆类似于new，但和new不同。new创建新的对象属性采用的是默认值。克隆出来的对象的属性值完全和原型对象相同。并且克隆出的新对象不会影响原型对象，克隆后。还可以再修改克隆对象的值。
 * 
 * 要实现原型模式，必须实现Cloneable接口，而这个接口里面是空的。
 * <p>
 * Cloneable接口是一个空接口，使用Cloneable接口都不用导入包。而clone方法是属于Object对象的。如果要克隆某个对象的话必须实现Cloneable接口
 * <p>
 * 克隆羊// TODO 需要深入
 * <p>
 * 浅克隆：copy该对象，然后保留该对象原有的引用，也就是说不克隆该对象的属性，实现<blockquote>
 * 
 * <pre>
 * return super.clone();
 * </pre>
 * 
 * </blockquote>
 * 
 * 深克隆：copy该对象，克隆对象的同时，把该对象的属性也连带着克隆出新的，实现见代码；
 * 
 * <p>
 * 原型模式适用场景：如果某个对象new的过程中很耗时，则可以考虑使用原型模式。
 * 
 * Spring框架中bean对象的创建就两种模式：单例模式或者原型模式
 * 
 * @author TobiasCui
 * @date 2018年9月27日 下午5:31:55
 * 
 */
public class CloneSheep implements Cloneable {
	/** 名字 */
	private String name;
	/** 克隆时间 */
	private Date cloneTime;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		CloneSheep cloneSheep = (CloneSheep) obj;
		cloneSheep.setCloneTime((Date) this.cloneTime.clone());
		return cloneSheep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCloneTime() {
		return cloneTime;
	}

	public void setCloneTime(Date cloneTime) {
		this.cloneTime = cloneTime;
	}

}
