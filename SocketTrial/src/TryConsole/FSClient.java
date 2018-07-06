package TryConsole;

import java.awt.Desktop;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FSClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//Inisialisasi Socket
		Socket socket = new Socket("localhost", 1235);
			
		//Spesifikasi file
		File file = new File("F:\\LPJ Tengah Tahun.pptx");
		FileInputStream input = new FileInputStream(file);
		BufferedInputStream buffered = new BufferedInputStream(input);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Do you want to preview the file? Yes/No");
		System.out.print("Please input your choice: ");
		String toAnswer = scan.next();
		
		if(toAnswer.equalsIgnoreCase("Yes")) {
			if(!Desktop.isDesktopSupported()) {
				System.out.println("Desktop is not supported");
				return;
			}
			Desktop desktop = Desktop.getDesktop();
			if(file.exists()) {
				desktop.open(file);
			}
		}
		else {
				System.out.println("We'll Continue to Send Your File");;
		}
		
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
		System.out.println("File Sent Succesfully");
		System.out.println("");
		System.out.println("-----------------------------------------------------------");
		//String hasil = in.readUTF();
		//System.out.println("Count: "+hasil);
		socket.close();
	}

}
