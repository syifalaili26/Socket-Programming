package TryConsole;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class PClient {
	public static void main(String args[]) throws Exception {
		Socket sk=new Socket("localhost",2000);
		BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream sout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ( true ) {
			
			System.out.print("Client\t: ");
			s=stdin.readLine();
			boolean isInteger = isInteger(s);
			if(isInteger) {
				sout.println(s);
			}
						
			s=sin.readLine();
			System.out.println("Server\t: "+s);
			if ( s.equalsIgnoreCase("Bye") )
				break;
		}
		sk.close();
		sin.close();
		sout.close();
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
