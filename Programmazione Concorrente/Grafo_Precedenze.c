#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <wait.h>

int main()
{
	int retVal;
    	int a,b,z;

    	int pidFiglio = fork();

    	if(pidFiglio==0)
    	{
    		a=3+2;
    		sleep(3);
    		exit(a);
    	}
	else
	{
        	b=4-6;
       		wait(&retVal);
        	a=WEXITSTATUS(retVal);
        	z=a*b;
		printf("Mio figlio ha terminato con valore: %d \nIo ho terminato con valore: %d \na*b: %d \n",a,b,z);
    	}
   	return 0;
}
	