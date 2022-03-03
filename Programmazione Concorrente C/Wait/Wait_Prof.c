#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

//int wait(int*); ritorna il pid del figlio che ha terminato
//1)se nessun figlio ha terminato la wait ATTENDE la terminaizone del figlio
//2)se esiste un figlio che ha gia terminato la sua esecuzione (zombie) il padre non rimane in ATTESA
//3)se il padre chiama la wait senza aver prima creato dei figli: la wait ritorna un valore minore di 0


int main()
{	
	int stato;
	int pid=fork();
	
	if(pid==0)
	{
	    printf("Sono il figlio, il mio pid e' %d\n",getpid());
	    printf("Mio padre ha pid %d\n",getppid());
	    sleep(20);
	    exit(2);
	}
	else
        {
	    printf("Sono il padre, il mio pid e' %d\n",getpid());
	    int pidf=wait(&stato);
	    if((char)stato==0)
	     printf("Mio figlio %d ha terminato volontariamente con esito %d\n",pidf,stato);
	    else
	     printf("Terminazione errata del figlio con segnale %d\n",(char)stato);
	}




return 0;
}
