package TryConsole;

import java.io.*;
import java.net.*;

public class CServer {
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(1972);
		Socket server = socket.accept();
		DataInputStream input = new DataInputStream(server.getInputStream());
		DataOutputStream output = new DataOutputStream(server.getOutputStream());
		BufferedReader reply = new BufferedReader(new InputStreamReader(System.in));
		String client = "";
		String answer ="";
		
		try {
			while(true){
				System.out.println("Server\t: ");
				answer = reply.readLine();
				output.writeUTF(answer);
				output.flush();
				
				client = input.readUTF();
				System.out.println("Client\t: "+client);
				
			}
		}
		finally {
			try {
				server.close();
				socket.close();
			}
			catch(Exception p) {
				System.out.println(p);
			}
		}
		/*output.writeUTF("Server\t: Trial Success");
		output.flush();
		System.out.print(input.readUTF());
		output.close();
		server.close();
		socket.close();*/
	}
}
