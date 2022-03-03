#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void faifiglio(void)
{
    int pid;
    pid=fork();

    if(pid==0){
    //figlio
    sleep(5);
    printf("Sono il processo figlio con PID %d e mio padre ha PID %d\n",getpid(),getppid());
    exit(0);
    }
    else{
    //padre
    printf("Sono il processo padre con PID %d\n",getpid());
    }
}

int main(){
int nfigli=0;
int i;

printf("Inserisci numero di processi figli da creare: ");
scanf("%d",&nfigli);

for(i=0;i<nfigli;i++)
{
	faifiglio();
}
}
