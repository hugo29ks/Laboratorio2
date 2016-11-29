package ec.edu.epn.redes.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ClientTCP {

	private static int SERVER_PORT = 9090; 
	
	public static void main (String[] args) throws UnknownHostException, IOException{
		
		String serverAddress = JOptionPane.showInputDialog("Ingrese direccion IP de la maquina que esta \n"+"corriendo el servicio en el puerto: " + SERVER_PORT);
		PrintWriter out;
	
		//valores para la suma
		String x = JOptionPane.showInputDialog("Ingrese el primer valor de la suma: ");
		String y = JOptionPane.showInputDialog("Ingrese el segundo valor de la suma: ");

		String envio = x + "/" +y; 
		
		Socket clientSocket = new Socket( serverAddress,SERVER_PORT); 
		
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		out.println(envio);
	        
		//Obtener el paquete que me envia el servidor 
		InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
		
		//Leyendo el mensaje 
		BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String answer = input.readLine();
		
		JOptionPane.showMessageDialog(null, "Respuesta de la suma "+ x + " + " + y + " = " + answer);
		System.exit(0);
	}
}
