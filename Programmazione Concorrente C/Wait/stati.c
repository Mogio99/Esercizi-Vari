#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#define NRFIGLI 2

/*
bool WIFEXITED(status): restituisce vero se il figlio eì terminato VOLONTARIAMENTE
int WEXITSTATUS(status): restituisce lo stato di temrinazione del figlio specificato nella exit


bool WIFSIGNALED(status): restituisce vero se il figlio e' terminato INVOLONTARIAMENTE
INT WTERMISIG(status): restituisce il segnale che ha terminato il figlio


*/

int main()
{	
	int stato;
	int pid;
	
	pid=fork();
	if(pid==0)
	{
	     printf("Sono il figlio corto, il mio pid e' %d\n",getpid());
	     printf("Mio padre ha pid %d\n",getppid());
             sleep(10);
	     exit(5); 
	}
	pid=wait(&stato);
	if(WIFEXITED(stato))
	 printf("Mio figlio e' terminato volontariamente con stato %d",WEXITSTATUS(stato));
	else
	 if(WIFSIGNALED(stato))
	  printf("Mio figlio e' terminato involontariamente con stato %d",WTERMSIG(stato));   

}