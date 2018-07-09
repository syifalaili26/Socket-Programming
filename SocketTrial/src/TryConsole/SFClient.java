package TryConsole;

import java.io.*;
import java.net.*;
import java.util.*;

public class SFClient {
	public static void main(String [] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 1945);
		File file = null;
		FileInputStream toInput = null;
		BufferedInputStream buffered = null;
		OutputStream output = socket.getOutputStream();
		DataOutputStream string = new DataOutputStream(socket.getOutputStream());
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Silahkan masukkan input: ");
		String input = scan.nextLine();
		string.writeUTF(input);
		string.flush();
		file = new File(input);
		if(file.isFile() == true) {
			System.out.println("File to send: "+file);
			toInput = new FileInputStream(file);
			buffered = new BufferedInputStream(toInput);
			byte[] contents;
			long fileLength = file.length();
			long current = 0;
			
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
		}
		
		else {
			String Client = input;
			System.out.println("Message to Send\t: "+Client);
		}
		output.close();
		socket.close();
	}
}
