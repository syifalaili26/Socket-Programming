package TryConsole;

import java.io.*;
import java.net.*;

public class PServer {
	public static void main(String args[]) throws Exception {
		ServerSocket ss=new ServerSocket(2000);
		System.out.println("Menunggu Klien mengirim pesan pertama, klien yang harus pertama kali mengirim pesan…");
		System.out.println(" chat dilakukan 2 arah, server klien, n bergantian kirim pesan.");
		Socket sk=ss.accept();
		System.out.println("Klien telah masuk. happy chat! untuk berhenti, ketik stop pada klien.\n\n");
		BufferedReader cin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream cout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int p=0;
		
		while ( true ) {
			s=cin.readLine();				
			if (s.equalsIgnoreCase("stop"))	{
				cout.println("Bye");
				break;
			} 
			System.out.print("Client\t: "+s+"\n");
			boolean isInteger = isInteger(s);
			if (isInteger == true) {
				p = Integer.parseInt(s);
				PenentuPrima penentuprima = new PenentuPrima(p);
				String hasil = penentuprima.getPrima();
				System.out.println("Server\t: " + hasil);
				cout.println(hasil);
				cout.flush();
			} else if (isInteger == false) {	
				System.out.print("Server\t: ");
				s=stdin.readLine();
				cout.println(s); 
			}
			
		}
		ss.close();
		sk.close();
		cin.close();
		cout.close();
		stdin.close();
	}
	
	public static boolean isInteger(String s) {
		boolean isValidInteger = false;
		try {
			Integer.parseInt(s);
			
			isValidInteger = true;
		} catch (NumberFormatException x) {
			
		}
		
		return isValidInteger;
	}
}
