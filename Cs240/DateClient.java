// This is the Client Code, save as DateClient.java
package Cs240;

import java.net.*;
import java.io.*;

public class DateClient {
   public static void main(String[] args) throws Exception {
      try {
         Socket sock = new Socket("godstime@127.0.0.1", 21);

         InputStream in = sock.getInputStream();
         // bin is the input stream from the server
         BufferedReader bin = new BufferedReader(new InputStreamReader(in));

         String line;
         while ((line = bin.readLine()) != null)
            System.out.println(line);

         sock.close();
      } catch (Exception ioe) {
         System.err.println(ioe);
      }
   }
}
