#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define NRFIGLI 2
//int wait(int*); ritorna il pid del figlio che ha terminato
//1)se nessun figlio ha terminato la wait ATTENDE la terminaizone del figlio
//2)se esiste un figlio che ha gia terminato la sua esecuzione (zombie) il padre non rimane in ATTESA
//3)se il padre chiama la wait senza aver prima creato dei figli: la wait ritorna un valore minore di 0

// waitpid peermette di attendere un specifico figlio
// int waitpid(int pid,int* status,int options);
// pid: indica quale processo deve attendere
   // < -1 attende tutti i processi appartenenti allo stesso gruppo del padre
   // -1 attende un qualsiasi figlio (si comporta come la wait)
   // 0 attende un qualsiasi figlio appartenente allo stesso gruppo del padre
   // pid del figlio da attendere
//status
//options: nel nostro caso sempre 0

//il processo padre genera 2 figli e attende la terminazione del processo figlio piu lungo

int main()
{	
	int stato;
	int pid, pid2;
	int i=0;
	
	    pid=fork();
	    if(pid==0)
	    {
	        printf("Sono il figlio corto, il mio pid e' %d\n",getpid());
	        printf("Mio padre ha pid %d\n",getppid());
		sleep(3);
		exit(2); 
	    }

	    pid2=fork();
	    if(pid2==0)
	    {
	        printf("Sono il figlio lungo, il mio pid e' %d\n",getpid());
	        printf("Mio padre ha pid %d\n",getppid());
		sleep(10);
		exit(2);
	    }
	printf("Mi metto in attesa del processo %d\n",pid2);
	waitpid(pid2,&stato,0);
	printf("Mio figlio %d e' terminato\n",pid2);
return 0;
}