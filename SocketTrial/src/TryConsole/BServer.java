package TryConsole;

import java.io.*;
import java.net.*;

public class BServer {
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(1968);
		Socket server = socket.accept();
		DataInputStream input = new DataInputStream(server.getInputStream());
		DataOutputStream output = new DataOutputStream(server.getOutputStream());
		String client = "";
			
		while(!client.equalsIgnoreCase("Done")){
			client = input.readUTF();
			System.out.println("Client\t: "+client);
			String reply = "";
			
			if(client.equalsIgnoreCase("A")) {
				reply = "Server\t: B";
				System.out.println(reply);
				output.writeUTF(reply);
				output.flush();
			}
			else if(client.equalsIgnoreCase("C")){
				reply = "Server\t: D";
				System.out.println(reply);
				output.writeUTF(reply);
				output.flush();
			}
			else if(client.equalsIgnoreCase("E")) {
				reply = "Server\t: F";
				System.out.println(reply);
				output.writeUTF(reply);
				output.flush();
			}
			else if(!client.equalsIgnoreCase("Done")) {
				reply = "Server\t: Your input false";
				System.out.println(reply);
				output.writeUTF(reply);
				output.flush();
			}
			else {
				output.writeUTF("Server\t: Trial Success");
				output.flush();
			}
		}
		System.out.print(input.readUTF());
		output.close();
		server.close();
		socket.close();
	}
}
