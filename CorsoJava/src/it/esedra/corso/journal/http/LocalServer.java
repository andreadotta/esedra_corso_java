package it.esedra.corso.journal.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.sun.net.httpserver.HttpServer;

public class LocalServer {

	public LocalServer() throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
		
	}
	
	public static void main(String[] args) {
		
		try {
			LocalServer server = new LocalServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
