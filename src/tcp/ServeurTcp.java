package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTcp {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;


    /**
     * Création du serveur
     * @throws IOException
     */
    public ServeurTcp() throws IOException {
       // Création de la socket serveur
        serverSocket = new ServerSocket(1313);
    }

    public void go() throws IOException {
       // Mise en attente de connexion
        while(true) {
            // Permet d'accepter un client
            clientSocket = serverSocket.accept();

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            String chaine;
            do {
                chaine = in.readLine();
                out.println("Reçue : " + chaine);
            } while (chaine.equalsIgnoreCase("fin"));
            // On ferme buffer et socket
            out.close();
            clientSocket.close();
        }
    }

    public static void main(String[] args) {
        try {
            ServeurTcp serveurTcp = new ServeurTcp();
            serveurTcp.go();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
