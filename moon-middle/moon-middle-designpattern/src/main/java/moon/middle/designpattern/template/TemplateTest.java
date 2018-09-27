package moon.middle.designpattern.template;

/**
 * 模板模式的优点
 * <p>
 * （1）具体细节步骤实现定义在子类中，子类定义详细处理算法是不会改变算法整体结构。<br/>
 * （2）代码复用的基本技术，在数据库设计中尤为重要。<br/>
 * （3）存在一种反向的控制结构，通过一个父类调用其子类的操作，通过子类对父类进行扩展增加新的行为，符合“开闭原则”。<br/>
 * 
 * @author TobiasCui
 * @date 2018年9月27日 下午6:32:08
 * 
 */
public class TemplateTest {

	public static void main(String[] args) {
		CookTemplate cookRice = new CookRice();
		cookRice.cook();
		System.out.println("--------------------------------------");
		CookTemplate cookDishes = new CookDishes();
		cookDishes.cook();
		System.out.println("--------------------------------------");
		CookTemplate cookSoup = new CookSoup();
		cookSoup.cook();
	}

}
