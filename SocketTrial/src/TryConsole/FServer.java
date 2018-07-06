package TryConsole;

import java.net.*;
import java.io.*;

public class FServer {
	public static void main(String[] args) throws IOException, IOException {
		//Inisialisasi Socket
		ServerSocket socket = new ServerSocket(1233);
		Socket server = socket.accept();
		byte[] contents = new byte[100000];
		
		//Inisialisasi FileOutputStream untuk menyimpan file yang diterima
		FileOutputStream output = new FileOutputStream("F:\\calculate.txt");
		BufferedOutputStream buffered = new BufferedOutputStream(output);
		InputStream input = server.getInputStream(); //File yang dikirim dari Client
		
		//Byte yang dibaca awal (?)
		int bytesRead = 0;
		
		while((bytesRead = input.read(contents)) != -1) {
			buffered.write(contents, 0, bytesRead);
		}
		buffered.flush();
		buffered.close();
		server.close();
		socket.close();
		System.out.println("File Saved Successfully");
	}
}
