import java.io.*;

import java.net.*;

class Server

{

  public static void main(String[] args) throws Exception

  {

     Socket sock = new Socket("192.168.40.132", 9706);

                               // reading from keyboard (keyRead object)

     BufferedReader keyRead = new BufferedReader(new 
InputStreamReader(System.in));

                              // sending to client (pwrite object)

     OutputStream ostream = sock.getOutputStream(); 

     PrintWriter pwrite = new PrintWriter(ostream, true);



                              // receiving from server ( receiveRead  object)

     InputStream istream = sock.getInputStream();

     BufferedReader receiveRead = new BufferedReader(new 
InputStreamReader(istream));



     System.out.println("WELCOME:)");



     String receiveMessage, sendMessage;               

     while(true)

     {

        sendMessage = keyRead.readLine();  // keyboard reading

        pwrite.println(sendMessage);       // sending to server

        pwrite.flush();
	
	if((receiveMessage = receiveRead.readLine()) != null)
	{
		System.out.println("Server: " + receiveMessage);
	}
}
}
}
