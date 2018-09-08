#include<iostream>
using namespace std;
int S=1,E=10,F=0;

int wait(int s)
{
	s--;
	
	return s;
}

int signal(int s)
{
	s++;
	return s;
}

void produce()
{
	S=wait(S);
	E=wait(E);
	F=signal(F);
	cout<<"\n **Produced item **\n";
	S=signal(S);
	
}

void consume()
{
	S=wait(S);
	F=wait(F);
	E=signal(E);
	cout<<"\n** Consumed item **\n";
	S=signal(S);
}

int main()
{
	cout<<"PRODUCER CONSUMER PROBLEM\n";
	cout<<"box can have 10 produced items\n";
	while(1)
	{   int ch;
		cout<<"\n1.Produce\n2.Consume\n3.Exit\n";
		cout<<"\n ENTER YOUR CHOICE: ";
		cin>>ch;
		
		switch(ch)
		{
			case 1:
				if(S==1 && E!=0)
				{
					produce();
					break;
				}
				else
				{
					cout<<"\ncan't produce more stack FULL'\n";
					break;
			    }
			case 2:
				if(S==1 && F!=0)
				{
					consume();
					break;
				}
				else
				{
					cout<<"\n empty box can't consume ''\n";
					break;
				}
			case 3:
				exit(0);
			default:
				cout<<"\n Invalid choice";
		}
	}
	
	return 0;
}
