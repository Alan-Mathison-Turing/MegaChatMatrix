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
	Socket cliente;
	
	public ClientThread(Socket socket,ArrayList<Socket> clientes) throws IOException {
		this.cliente = socket;
		this.clientes = clientes;
		System.out.println("Socket de cliente creado");
	}
	
	@Override
	public void run() {
		
		DataInputStream mensajeDIS;
		try {
			while(true) {
				mensajeDIS = new DataInputStream(this.cliente.getInputStream());
				String mensaje = mensajeDIS.readUTF();
				System.out.println("Mensaje recibido");
				Iterator<Socket> iteratorClientes = this.clientes.iterator();
				
				while(iteratorClientes.hasNext()){
					Socket clienteAEnviar = iteratorClientes.next();
					if(clienteAEnviar.isClosed()) {
						iteratorClientes.remove();
						continue;
					}
					if(this.cliente.equals(clienteAEnviar)) {
						continue;
						
					}
					DataOutputStream mensajeEnviar = new DataOutputStream(clienteAEnviar.getOutputStream());
					mensajeEnviar.writeUTF(mensaje);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
