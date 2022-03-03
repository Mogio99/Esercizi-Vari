#include<unistd.h>
#include<stdlib.h>
#include<stdio.h>

void sequenziale(int n,int m);
void parallelo(int n,int m);

int main()
{
   	char scelta;
   	int n,m,cod,cod1;

   	printf("Inserisci il numero di figli N \n");
   	scanf("%d",&n);
   	printf("Inserisci il numero di nipotiM \n");
   	scanf("%d",&m);
	printf("Inserisci (s) per sequenziali o (p) per paralleli \n");
	scanf(" %c",&scelta);

	if(scelta=='s')
	{
		sequenziale(n,m);
	}
	else 
	{
		if(scelta=='p')
		{
			parallelo(n,m);
		}
	}
}

void sequenziale(int n,int m)
{
	int a;
	int pid,pidf,padre,cod,cod1;
	int i,j;
	for(i=0;i<n;i++)
	{
		pid=fork();
		if(pid==0)
		{
			padre=getppid();
			printf("sono il figlio %d ho pid %d e mio padre ha pid %d \n",i,getpid(),padre);
			for(int j=0;j<m;j++)
			{
				pidf=fork();
					if(pidf==0)
					{
						printf("sono il nipote %d ho pid %d mio padre ha pid %d e mio nonno ha pid %d \n",y,getpid(),getppid(),pa);
						exit(0);
					}
				cod1=waitpid(pidf,&a,0);
			}
			exit(0);		
		}
		cod=waitpid(pid,&a,0);		
	}	
}
void parallelo(int n,int m)
{
	int a;
	int pid,pidf,padre;
	int i,j,z;
	for(i=0;i<n;i++)
	{
		pid=fork();
		if(pid==0)
		{
			pa=getppid();
			printf("sono il figlio %d ho pid %d e mio padre ha pid %d \n",i,getpid(),padre);
			for(int j=0;j<m;j++)
			{
				pidf=fork();
					if(pidf==0)
					{
						printf("sono il nipote %d ho pid %d mio padre ha pid %d e mio nonno ha pid %d \n",y,getpid(),getppid(),padre);
						exit(0);
					}
				
			}
			exit(0);		
		}
		for(z=0;z<n*m;z++)
		{
			wait();	
		}
		
	}	
}
