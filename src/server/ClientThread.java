package server;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ClientThread extends Thread {

	ArrayList<Socket> clientes;
	Socket socket;
	
	public ClientThread(Socket socket,ArrayList<Socket> clientes) throws IOException {
		this.socket = socket;
		this.clientes = clientes;
	}
	
	@Override
	public void run() {
		
		DataInputStream mensajeDIS;
		try {
			mensajeDIS = new DataInputStream(socket.getInputStream());
			String mensaje = mensajeDIS.readUTF();
			
			Iterator<Socket> iteratorClientes = clientes.iterator();
			
			while(iteratorClientes.hasNext()){
				Socket cliente = iteratorClientes.next();
				DataOutputStream mensajeEnviar = new DataOutputStream(cliente.getOutputStream());
				mensajeEnviar.writeUTF(mensaje);
				mensajeEnviar.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
