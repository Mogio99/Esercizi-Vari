#include<unistd.h>
#include<stdlib.h>
#include<stdio.h>
void stampa();

int main()
{
	int pid;
	pid=fork();
	if(pid==0)
	{
		printf("sono il figlio \n");
		sleep(10);
		exit(0);
	}
	else
	{
		wait();
		printf("sono il padre e mio figlio ha gia' terminato \n");
	}
}


