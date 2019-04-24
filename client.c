#include <unistd.h>
#include <stdio.h>
#include <sys/socket.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <string.h>
#include <arpa/inet.h>
#include <sys/types.h>

int main()
{
	int sockid = socket(AF_INET, SOCK_STREAM, 0);
    char server_msg[300] = "HI SERVER!";
    struct sockaddr_in addrport ;    
    addrport.sin_family = AF_INET;
    addrport.sin_port = htons(6800);
    addrport.sin_addr.s_addr = inet_addr("192.168.47.128");
    int status = connect(sockid, (struct sockaddr *) &addrport, sizeof(addrport));

    if (status == -1) {

       printf("There was an error %s\n");
    }

    send(sockid, server_msg, sizeof(server_msg),0);
    char server_response[300];
    recv(sockid, &server_response, sizeof(server_response), 0);
    printf("SERVER MESSAGE: %s\n", server_response);
	close(sockid);

	return 0;

}
