package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSideThread extends Thread{
	
	private Socket socket;
	private String nombre;
	
	public ClientSideThread(Socket socket, String nombre) {
		this.socket = socket;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		
		
			try {
				DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
				salida.writeUTF("Hola! Me llamo " + this.nombre + " y soy nuevo en el chat!");
				
				while(true) {
					DataInputStream entrada = new DataInputStream(socket.getInputStream());
					System.out.println(entrada.readUTF());
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}