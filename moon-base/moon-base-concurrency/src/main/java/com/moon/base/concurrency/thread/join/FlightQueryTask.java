package com.moon.base.concurrency.thread.join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FlightQueryTask extends Thread implements FlightQuery {

	/** 出发地 */
	private final String origin;
	/** 目的地 */
	private final String destination;

	private final List<String> flightList = new ArrayList<>();

	public FlightQueryTask(String airline, String origin, String destination) {
		super("[" + airline + "]");
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public void run() {
		System.out.printf("%s-query from %s to %s \n", getName(), origin, destination);

		int randomVal = ThreadLocalRandom.current().nextInt(10);

		try {
			TimeUnit.SECONDS.sleep(randomVal);
			flightList.add(getName() + "-" + randomVal);
			System.out.printf("%s-query from %s to %s ,query success,  spend time %ss \n", getName(), origin, destination, randomVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> get() {
		return this.flightList;
	}

}
