package lab3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class bai2_Server {
	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(9540);
			System.out.println("Server da duoc tao");
			Socket client = server.accept();
			System.out.println("Client da ket noi den server");
			Scanner inFromClient = new Scanner(client.getInputStream());
			PrintStream outToClient = new PrintStream(client.getOutputStream());
			outToClient.println("Xin chao, ban muon tim sach gi?");
			String tens = inFromClient.nextLine();
			System.out.println("client: " + tens);
			BufferedReader br= new BufferedReader(new FileReader("D:\\text.txt"));
			String tep=br.readLine();
			if(tep.contains(tens))
				outToClient.println("Co sach " + tens);
			else
				outToClient.println("Rat tiec khong co sach " + tens);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


