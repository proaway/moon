package moon.middle.designpattern.prototype;

import java.util.Date;

public class PrototypeTest {

	public static void main(String[] args) throws Exception {
		CloneSheep sheepDolly = new CloneSheep();
		sheepDolly.setName("多利");
		sheepDolly.setCloneTime(new Date(1274397294739L));
		System.out.println(sheepDolly.getName() + ":" + sheepDolly.getCloneTime() + ":" + sheepDolly);
		System.out.println("-----------------复制羊---------------------");
		CloneSheep sheepSholly = (CloneSheep) sheepDolly.clone();
		System.out.println(sheepSholly.getName() + ":" + sheepSholly.getCloneTime() + ":" + sheepSholly);
		System.out.println("-----------------更改信息---------------------");
		sheepSholly.setName("少利");
		sheepSholly.setCloneTime(new Date());
		System.out.println(sheepSholly.getName() + ":" + sheepSholly.getCloneTime() + ":" + sheepSholly);
	}

}
