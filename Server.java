import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) throws IOException {

	     ServerSocket sockets = new ServerSocket(6800);
	     Socket serSoc = sockets.accept();
	
             System.out.println("WAITING FOR CLIENT: " + serSoc.getLocalPort());
             System.out.println("JUST CONNECTED TO: " + serSoc.getRemoteSocketAddress());
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             OutputStream ostream = serSoc.getOutPutStream();
             PrintWriter writer = new PrintWriter(ostream, true);
	     writer.println("HELLO CLIENT!");

             InputStream input = serSoc.getInputStream();

             BufferedReader recvRead = new BufferedReader(new InputStreamReader(input));
             
             String receiveMessage, sendMessage;
             
             while(true)
             {
                if((receiveMessage = recvRead.readLine()) != null)
                {
                  System.out.println("SERVER CONNECTED!");
                  System.out.println(receiveMessage);
                }
             sendMessage = reader.readLine();
             writer.println(sendMessage);
             writer.flush();
}
}
}
