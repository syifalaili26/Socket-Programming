package TryConsole;

import java.io.*;
import java.net.*;

public class BClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",1968);
		DataInputStream input = new DataInputStream(socket.getInputStream());
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		BufferedReader reply = new BufferedReader(new InputStreamReader(System.in));
		String client = "";
			
		while(!client.equalsIgnoreCase("Done")) {
			System.out.print("Client\t: ");
			client = reply.readLine();
			output.writeUTF(client);
			output.flush();
			
			String answer = input.readUTF();
			System.out.println(answer);
		}
		output.writeUTF("Server\t: Trial Success");
		output.flush();
		input.close();
		output.close();
		socket.close();
	}
}
