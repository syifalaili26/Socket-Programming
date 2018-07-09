package TryConsole;

import java.io.*;
import java.net.*;
import ConnectDB.*;

public class SFServer {
	public static void main(String [] args) throws IOException {
		ServerSocket server = new ServerSocket(1945);
		Socket socket = server.accept();
		
		//Inisialisasi Input
		InputStream input = socket.getInputStream();
		BufferedReader read = new BufferedReader(new InputStreamReader(input));
		StringBuilder string = new StringBuilder();
		
		//Inisialisasi Connection
		connection connect = new connection();
		connect.Connect();

		String line = "";
			while ((line = read.readLine()) != null) {//jika barisdata ada
				System.out.println("Data\t: "+line);
				String Sql="INSERT INTO Socket values(null,'"+line+"','null,')";
				connect.saveData(Sql);     
			}
			socket.close();
			server.close();
	}
}
