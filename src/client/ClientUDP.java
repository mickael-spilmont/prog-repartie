package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class ClientUDP {
	private DatagramSocket dgSocket;
	
	ClientUDP() throws IOException {
		dgSocket = new DatagramSocket();
	}
	

	void envoie() throws IOException {
		DatagramPacket dgPacket = new DatagramPacket(new byte[0], 0);
		
//		On entre en entête les info de la machine avec laquelle on désire communiquer
//		Pour ça deux méthodes :
		/*
		dgPacket.setAddress(InetAddress.getByName("hevea13"));
		dgPacket.setPort(9876);
		*/
		dgPacket.setSocketAddress(new InetSocketAddress("hevea13", 9876));
				
//		On envoie le paquet (sans message)
		dgSocket.send(dgPacket);

//		On prépare un buffer pour la réception de la réponse
		byte[] bufReception = new byte[50];
		
//		On indique le buffer dans le datagrame et on se met en attente de reception
		dgPacket.setData(bufReception);
		dgSocket.receive(dgPacket);
		
//		On reconvertie les infos reçues en string et on les affiches
		String str = new String(dgPacket.getData(), dgPacket.getOffset(), dgPacket.getLength());
		System.out.println(str);
	}
	
	public static void main(String[] args) throws IOException {
		new ClientUDP().envoie();
	}
}
