package moon.middle.designpattern.template;

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
