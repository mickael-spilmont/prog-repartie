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
		dgPacket.setAddress(InetAddress.getByName("bouleau15"));
		dgPacket.setPort(9870);
				
//		On envoie le message
		dgSocket.send(dgPacket);

		byte[] bufReception = new byte[50];
		
		dgPacket.setData(bufReception);
		dgSocket.receive(p);
		
	}
}
