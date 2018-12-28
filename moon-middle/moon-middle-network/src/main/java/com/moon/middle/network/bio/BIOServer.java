package com.moon.middle.network.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class BIOServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8888);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
