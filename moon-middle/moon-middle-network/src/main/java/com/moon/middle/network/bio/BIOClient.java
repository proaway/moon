package com.moon.middle.network.bio;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class BIOClient {

	public static void main(String[] args) {
		try {
			Socket client = new Socket("", 8888);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
