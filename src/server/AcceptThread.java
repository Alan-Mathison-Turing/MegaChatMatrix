package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class AcceptThread extends Thread {

	ServerSocket server;
	ArrayList<Socket> sockets;
	
	public AcceptThread(ServerSocket server, ArrayList<Socket> sockets) {
		this.server = server;
		this.sockets = sockets;
	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
				Socket cliente = server.accept();
				sockets.add(cliente);
				
				new ClientThread(cliente, sockets).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
