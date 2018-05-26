package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	
	public static String nombre = "Maxi2";
	
	private int puerto;
	private String ip;
	
	
	public Client(String ip, int puerto) {
		this.ip = ip;
		this.puerto = puerto;
		
		try {
			Socket socket = new Socket(ip, puerto);
			System.out.println("Cliente: " + Client.nombre);
			
			new ClientSideThread(socket,Client.nombre).run();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Client("localhost",7777);
	}

}
