package TryConsole;

import java.io.*;
import java.net.*;

public class RServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1996);
			Socket socket = server.accept();
			DataInputStream data = new DataInputStream(socket.getInputStream());
			DataOutputStream Data = new DataOutputStream(socket.getOutputStream());
			String write = (String)data.readUTF();
			String reply = "Message : "+write;
			System.out.println(reply);
			Data.writeUTF(reply);
			Data.flush();
			Data.close();
			server.close();
		}
		catch(Exception p) {
			System.out.println(p);
		}
	}
}
