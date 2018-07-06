package TryConsole;

import java.io.*;
import java.net.*;

public class FClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//Inisialisasi Socket
		Socket socket = new Socket("localhost", 1233);
		
		//Spesifikasi file
		File file = new File("E:\\Calculate.txt");
		FileInputStream input = new FileInputStream(file);
		BufferedInputStream buffered = new BufferedInputStream(input);
		DataInputStream data = new DataInputStream(socket.getInputStream());
		
		//Socket OutputStream
		OutputStream output = socket.getOutputStream();
		
		//Membaca konten file dalam konten array
		byte[] contents;
		long fileLength = file.length();
		long current = 0;
		//long start = System.nanoTime();
		
		while(current != fileLength) {
			int size = 100000;
			if(fileLength - current >= size) {
				current += size;
			}
			else {
				size = (int)(fileLength - current);
				current = fileLength;
			}
			contents = new byte[size];
			buffered.read(contents, 0, size);
			output.write(contents);
			System.out.println("Sending File ..."+(current*100)/fileLength+"% Complete");
		}
		output.flush();
		buffered.close();
		socket.close();
		System.out.println("File Sent Succesfully");
	}
}
