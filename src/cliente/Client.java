package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	
	
	private int puerto;
	private String ip;
	
	
	public Client(String ip, int puerto) {
		this.ip = ip;
		this.puerto = puerto;
		
		try {
			Socket socket = new Socket(ip, puerto);
			
			new ClientSideThread(socket).run();
			
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			salida.writeUTF("Holis carolis");
			salida.writeUTF("Holis carolis2");
			salida.writeUTF("Holis carolis3");
			
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Client("localhost",7777);
	}

}
