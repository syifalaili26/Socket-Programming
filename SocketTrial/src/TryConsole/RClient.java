package TryConsole;

import java.io.*;
import java.net.*;

public class RClient {
	public static void main(String [] args) {
		try {
			Socket socket = new Socket("localhost", 1996);
			DataInputStream Data = new DataInputStream(socket.getInputStream());
			DataOutputStream data = new DataOutputStream(socket.getOutputStream());
			data.writeUTF("Trial Client Done");
			data.flush();
			System.out.println(Data.readUTF());
			data.close();
			socket.close();
		}
		catch (Exception p) {
			System.out.println(p);
		}
	}
}
