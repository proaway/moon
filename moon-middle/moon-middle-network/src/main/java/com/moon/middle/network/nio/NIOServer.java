package com.moon.middle.network.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

	private static Selector selector = null;

	public static void main(String[] args) {
		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.bind(new InetSocketAddress(8888));
			server.configureBlocking(false);

			selector = Selector.open();
			server.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listener() throws IOException {
		while (true) {
			int select = selector.select();
			if (select == 0) {
				continue;
			}

			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectedKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				iterator.remove();
				process(key);
			}
		}
	}

	public void process(SelectionKey key) throws IOException {
		// TODO Auto-generated method stub
		if (key.isAcceptable()) {
			ServerSocketChannel server = (ServerSocketChannel) key.channel();
			SocketChannel client = server.accept();
			client.configureBlocking(false);
			client.register(selector, SelectionKey.OP_READ);
			key.interestOps(SelectionKey.OP_ACCEPT);
			client.write(Charset.forName("utf-8").encode("sfasd"));
		}
	}

}
