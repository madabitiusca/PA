import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.rmi.Remote;

public class GameServer {
    private static final int PORT =8100;
    private ServerSocket serverSocket;
    private boolean running = false;
    private List<ClientThread> clientsThread;


    public void ClientThreads() {
        this.clientsThread =new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        GameServer gameServer = new GameServer();
        gameServer.init();
        gameServer.clients();
    }

    public void init() throws IOException {
        if(!this.running) {
            serverSocket=new ServerSocket(PORT);
            this.running=true;
            System.out.println("Start");
        }
    }


    public void clients() throws IOException{
        while (this.running) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");


            ClientThread client = new ClientThread(socket);
            client.start();
            clientsThread.add(client);
        }
    }

    public void stop() throws IOException {
        this.running = false;
        serverSocket.close();
    }




}
