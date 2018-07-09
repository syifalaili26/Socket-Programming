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
		DataInputStream in = new DataInputStream(socket.getInputStream());
		StringBuilder string = new StringBuilder();
		int jum = 0;
		
		//Inisialisasi Connection
		connection connect = new connection();
		connect.Connect();
		
		String send = in.readUTF();
		File file = new File(send);
		if(file.isFile() == true){
			String line = "";
			while ((line = read.readLine()) != null) {//jika barisdata ada
				System.out.println("Data\t: "+line);
				jum = jum + Integer.parseInt(line);
				String Sql="INSERT INTO Socket values(null,'"+line+"','"+jum+"')";
				connect.saveData(Sql);     
			}
			String hasil = String.valueOf(jum);
			System.out.println("Hasil\t: "+hasil);
		}
		else {
			System.out.println("Client\t: "+send);
		}
	}
}
