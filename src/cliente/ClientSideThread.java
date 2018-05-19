package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSideThread extends Thread{
	
	private Socket socket;
	
	public ClientSideThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				DataInputStream entrada = new DataInputStream(socket.getInputStream());
				System.out.println(entrada);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}