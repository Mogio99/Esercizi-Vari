//Programma per utilizzare l'istruzione fork()
#include<stdio.h>
#include<stdlib.h>

int main()
{
    int pid;
    int pid_figlio;
    int pid_padre;
    //printf("Prima della fork\n");
    pid=fork(); //ritorna al padre il PID del figlio e al figlio ritorna 0
    //printf("Dopo la fork\n");
    if(pid==0)
    {
        //figlio
	sleep(60); //dorme per 60 secondi
	pid_figlio=getpid();
	pid_padre=getppid();
	printf("Sono il processo figlio con PID: %d e mio padre ha PID: %d\n",pid_figlio,pid_padre);
        exit(1); //parametro: stato //termina il proc figlio
    }
    else
    {
        //padre     
	printf("Sono il processo padre con PID: %d e mio figlio ha PID: %d\n",getpid(),getppid()); 
	exit(0); //termina il proc padre
    }
    printf("Siamo qui!\n");
    return 0;
}