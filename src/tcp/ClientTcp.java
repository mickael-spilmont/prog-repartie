package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTcp {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientTcp() throws IOException {
        // Création de la socket du client
        socket = new Socket("localhost", 1313);

        // On créer le buffer d'entrée
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // Puis le buffer de sortie
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    private void go() throws IOException {
        // On créer la requette http dans le printWritter
        out.println("GET / HTTP/1.0\r\n");

        // On lis les données reçues dans le bufferReader
        String chaineRecue;
        do {
            chaineRecue = in.readLine();
            System.out.println(chaineRecue);
        } while (chaineRecue != null);

        socket.close();
    }

    public static void main(String[] args) {
        try {
            ClientTcp clientTcp = new ClientTcp();
            clientTcp.go();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
