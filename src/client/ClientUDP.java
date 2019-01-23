package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDP {
	private DatagramSocket dgSocket;
	
	ClientUDP() throws IOException {
		dgSocket = new DatagramSocket();
	}
	

	void envoie() throws IOException {
		DatagramPacket dgPacket = new DatagramPacket(new byte[0], 0);
		dgPacket.setAddress(InetAddress.getByName("hevea13"));
		dgPacket.setPort(9876);
				
//		On envoie le message
		dgSocket.send(dgPacket);

		byte[] bufReception = new byte[50];
		
		dgPacket.setData(bufReception);
		dgSocket.receive(dgPacket);
		
		String str = new String(dgPacket.getData(), dgPacket.getOffset(), dgPacket.getLength());
		System.out.println(str);
	}
	
	public static void main(String[] args) throws IOException {
		new ClientUDP().envoie();
	}
}
