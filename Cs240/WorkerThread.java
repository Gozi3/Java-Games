package Cs240;

import java.net.*;
import java.io.*;

public class WorkerThread extends Thread {
    private Socket client;
    private int clientN;

    public WorkerThread(int clientN, Socket c) {
        this.client = c;
        this.clientN = clientN++;
    }

    public void run() {
        // pout is the output stream to the client
        try {
            PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
            pout.println(new java.util.Date().toString());
            System.out.println("...finished processing client" + clientN);
            client.close();
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
