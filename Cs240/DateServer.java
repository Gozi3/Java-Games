// This is the Server code, save as DateServer.java
package Cs240;

import java.net.*;

public class DateServer {

   public static void main(String[] args) throws Exception {
      int clientN = 0;
      ServerSocket sock = new ServerSocket(21);
      try {
         // This creates a listener socket
         while (true) {
            Socket client = sock.accept();
            System.out.println("Yo");
            WorkerThread worker = new WorkerThread(clientN, client);
            worker.start();
         }
      } catch (Exception ioe) {

         System.err.println(ioe);
      }
      sock.close();
   }

}
