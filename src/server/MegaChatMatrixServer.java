package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MegaChatMatrixServer {

	int puerto;
	ArrayList<Socket> sockets = new ArrayList<Socket>(); 
	
	public MegaChatMatrixServer(int puerto) {
		this.puerto = puerto;
		
		try {
			ServerSocket server = new ServerSocket(puerto);
			System.out.println("Server creado en puerto " + puerto);
			
			new AcceptThread(server, sockets).start();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	
	public static void main(String[] args) {
		new MegaChatMatrixServer(7777);
	}

}
