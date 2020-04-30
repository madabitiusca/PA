
import javax.jnlp.FileContents;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {

    private final static String serverAddress = "127.0.0.1";
    private final static int PORT = 8100;


    public static void main(String[] args) throws IOException {
        GameClient gameClient = new GameClient();
        while (true) {
            String request = gameClient.readFromKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                break;
            } else {
                gameClient.sendRequestToServer(request);
            }
        }
    }


    private String readFromKeyboard()
    {

        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private void sendRequestToServer(String request) throws IOException {
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (
                        new InputStreamReader(socket.getInputStream())) ) {
            out.println(request);
            String response = in.readLine ();
            System.out.println(response);
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}



