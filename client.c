#include <stdio.h> 
#include <sys/socket.h> 
#include <stdlib.h> 
#include <netinet/in.h> 
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/types.h>

int main()
{ 
   char server_msg [256]="Hi";
   int net_socket;
   net_socket = socket (AF_INET,SOCK,STREAM,0);
   
   struct sockaddr_in server_address;
   server_address.sin_family=AF_INET;
   server_address.sin_port=htons(8080);
   server_address.sin_addr.s_addr=ip address;
   
   int status=connect(net_socket,(struct sockaddr *) &server_address, sizeof (server_address));
   if (status== -1)
{ 
    println ("There was an error %s\n");
}

   send (net_socket,server_msg,sizeof(server_msg), 0);
   
   char server_response[256];
   recv(net_socket, &server_response, sizeof(server_response),0);
   
   println ("Server message : %s\n", server_response);
   close(net_socket);
   
    return 0; 
} 
