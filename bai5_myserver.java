package lab3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class bai5_myserver {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("Server da duoc tao");
			Socket client = server.accept();
			System.out.println("Client da ket noi den server");
			Scanner inFromClient = new Scanner(client.getInputStream());
			PrintStream outToClient = new PrintStream(client.getOutputStream());
			outToClient.println("Moi ban nhap mot chuoi:");
			String a = inFromClient.nextLine();
			char[] in = a.toCharArray();
		    int begin=0;
		    int end=in.length-1;
		    char temp;
		    while(end>begin){
		        temp = in[begin];
		        in[begin]=in[end];
		        in[end] = temp;
		        end--;
		        begin++;
		    }
		    outToClient.println(in);
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}
