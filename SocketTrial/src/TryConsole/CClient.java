package TryConsole;

import java.io.*;
import java.net.*;

public class CClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",1972);
		DataInputStream input = new DataInputStream(socket.getInputStream());
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		BufferedReader reply = new BufferedReader(new InputStreamReader(System.in));
		String client = "";
		String answer = "";
		
		try {	
			while(true) {
				answer = input.readUTF();
				System.out.println("Server\t: "+answer);
				
				System.out.print("Client\t: ");
				client = reply.readLine();
				output.writeUTF(client);
				output.flush();
			}
		}
		finally {
			try {
				socket.close();
			}
			catch (Exception p) {
				System.out.println(p);
			}
		}
	}
}
