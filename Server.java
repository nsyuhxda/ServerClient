import java.io.*;
import java.net.*;
public class Server
{
public static void main(String[] args)throws Exception
{
ServerSocket Syuda = new ServerSocket(8080);
Socket s = Syuda.accept();
    System.out.println("Client connected");

InputStreamReader gt = new InputStreamReader (s.getInputStream());
BufferedReader ot = new BufferedReader(gt);

PrintWriter rp = new PrintWriter(s.getOutputStream());
rp.println("What's up?");
rp.flush();
    
String recvr = ot.readLine();
    System.out.println ("Client",recvr);
    
}
}
}
    
