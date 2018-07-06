package TryConsole;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import ConnectDB.*;

public class FRServer {
	public static void main(String[] args) throws IOException, IOException {
		//Inisialisasi Socket
		ServerSocket socket = new ServerSocket(1233);
		Socket server = socket.accept();

		InputStream input = server.getInputStream(); //File yang dikirim dari Client
		BufferedReader read = new BufferedReader(new InputStreamReader(input));
		StringBuilder string = new StringBuilder();
		
		//Database
		connection connect = new connection();
		connect.Connect();
		
		String line = "";
		int jum = 0;
		while ((line = read.readLine()) != null) {//jika barisdata ada
			jum = jum + Integer.parseInt(line);
	          string.append(line).append("\n");//mencetak baris kata dalam dokumen   
	          System.out.println("Data\t: "+line);
	          String Sql="INSERT INTO Socket values(null,'"+line+"','"+jum+"')";
	          connect.saveData(Sql);       
		}
		String hasil = String.valueOf(jum);
		System.out.println("Hasil perhitungan\t: " +hasil);
		
		server.close();
		socket.close();
	}
}
