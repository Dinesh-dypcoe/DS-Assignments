import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {

        try {
            // Create server socket on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server started...");
            System.out.println("Waiting for client connection...");

            // Accept client connection
            Socket socket = serverSocket.accept();

            System.out.println("Client connected!");

            // Input stream to receive data
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Output stream to send data
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            // Read number from client
            String received = br.readLine();

            System.out.println("Received from client: " + received);

            // Convert string to integer
            int number = Integer.parseInt(received);

            // Double the number
            int result = number * 2;

            // Send result back to client
            bw.write("Result after doubling: " + result);
            bw.newLine();
            bw.flush();

            System.out.println("Result sent to client.");

            // Close connections
            br.close();
            bw.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}