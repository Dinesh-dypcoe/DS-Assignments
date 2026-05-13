import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {

            // Connect to server
            Socket socket = new Socket("localhost", 5000);

            System.out.println("Connected to server.");

            // Input and Output streams
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            // Scanner for user input
            Scanner sc = new Scanner(System.in);

            // Take number from user
            System.out.print("Enter a number: ");
            int number = sc.nextInt();

            // Send number to server
            bw.write(String.valueOf(number));
            bw.newLine();
            bw.flush();

            System.out.println("Sent to server: " + number);

            // Receive response from server
            String response = br.readLine();

            System.out.println("Response from server: " + response);

            // Close resources
            sc.close();
            br.close();
            bw.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}