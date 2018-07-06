package TryConsole;

import java.io.*;
import java.net.*;
import ConnectDB.*;

public class OServer{
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket server = new ServerSocket(1221);
		Socket socket = server.accept();
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		connection connect = new connection();
		System.out.println("Connected");
		int id = 0;
		String name = "";
		String address = "";
		
		try {
			Message mahasiswa = (Message)input.readObject();
			System.out.println("Object Received\t: "+mahasiswa);
			id = mahasiswa.getId();
			name = mahasiswa.getName();
			address = mahasiswa.getAddress();
			String Sql="INSERT INTO message values('"+id+"','"+name+"','"+address+"')";
			connect.saveData(Sql);
			socket.close();
			server.close();
		}
		catch (SocketException p) {
			System.exit(0);
		}
	}
}