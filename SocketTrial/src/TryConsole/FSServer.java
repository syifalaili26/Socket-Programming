package TryConsole;

import java.net.*;
import java.io.*;
import java.awt.*;

public class FSServer {
	public static void main(String[] args) throws IOException, IOException {
		//Inisialisasi Socket
		ServerSocket socket = new ServerSocket(1235);
		Socket server = socket.accept();
		byte[] contents = new byte[100000];
	
		//Inisialisasi FileOutputStream untuk menyimpan file yang diterima
		String nameTosave = "E:\\LPJ Tengah Tahun.pptx";
		FileOutputStream output = new FileOutputStream(nameTosave);
		BufferedOutputStream buffered = new BufferedOutputStream(output);
		InputStream input = server.getInputStream(); //File yang dikirim dari Client
		
		//simpan file
		int bytesRead = 0;	
		while((bytesRead = input.read(contents)) != -1) {
			buffered.write(contents, 0, bytesRead);
		}
		buffered.flush();
		buffered.close();
		
		File file = new File(nameTosave);
		if(!Desktop.isDesktopSupported()) {
			System.out.println("Desktop is not supported");
			return;
		}
		Desktop desktop = Desktop.getDesktop();
		if(file.exists()) {
			desktop.open(file);
		}
		
		server.close();
		socket.close();
		System.out.println("File Saved Successfully");
		System.out.println("Your file will be displayed");
	}
}
