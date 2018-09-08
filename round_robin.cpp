#include<iostream>
using namespace std;
void round_robin(int n,int bt[],int sum,int t,int tq,int rbt[])
{
	int j=1,tat[10],wt[10];
	float tatt=0,wtt=0;
	while(t<=sum && j<=n)
	{
		
		if(rbt[j]>tq)
		{
			t=t+tq;
			rbt[j]=rbt[j]-tq;			
		}
		else
		{
			t=t+rbt[j];
			rbt[j]=0;		
			wt[j]=t-bt[j];								
			tat[j]=wt[j]+bt[j];
			cout<<j<<" bt "<<bt[j]<<" , ";
			cout<<j<<" wt "<<wt[j]<<" , ";
			cout<<j<<"tat "<<tat[j]<<"\n";
			j++;
		}
		
	}
	for(int i=1;i<=n;i++)
	{
		wtt=wtt+wt[i];
		tatt=tatt+tat[i];	
	}
	cout<<"\naverage waiting time = "<<wtt/n<<"\n\n";
	cout<<"average turn around time = "<<tatt/n;
}
int main()
{
	int i,n,bt[10],t=0,tq,sum=0,rbt[10];
	cout<<"ROUND ROBIN SHEDULING\n\n";
	cout<<"enter the no. of procecess n: ";
	cin>>n;
	cout<<"enter the time quantum tq: ";
	cin>>tq;
	
	cout<<"\n**enter the burst time\n";
	for(i=1;i<=n;i++)
	{
		cout<<"enter for process "<<i<<" :";
		
		cin>>bt[i];
		sum=sum+bt[i];
	
	}
	for(i=1;i<=n;i++)
	{
		rbt[i]=bt[i];
	}
	cout<<"\ntotal time required : "<<sum<<"\n\n";
	round_robin(n,bt,sum,t,tq,rbt);
	return 0;

}
