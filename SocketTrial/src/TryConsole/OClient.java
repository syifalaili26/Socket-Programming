package TryConsole;

import java.net.*;
import java.io.*;

public class OClient{
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 1221);
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		boolean connected = false;
		
		while(!connected) {
			try {
				System.out.println("Connected");
				connected = true;
				Message mahasiswa = new Message(101, "Alucard", "Surabaya");
				System.out.println("Object to send\t: "+mahasiswa);
				output.writeObject(mahasiswa);
			}
			catch(SocketException p) {
				p.printStackTrace();
			}
		}
		socket.close();
	}
}