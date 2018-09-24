package fcfs;

import java.util.Scanner;

public class FCFS {

    public static void fcfs(int a[],int n)
    {
        int t=0;
        float awtat=0,atat=0;
        int[] wt=new int[10];
        int[] tat=new int[10];
        for(int i=1;i<=n;i++)
        {
            wt[i]=t;
            t=t+a[i];
            tat[i]=t;
            awtat=wt[i]+awtat;
            atat=tat[i]+atat;
        }
        System.out.println("average waiting time is "+awtat/3);
        System.out.println("average turn around time is "+atat/3);
        
    }

    public static void main(String[] args) 
    {
        int n;
        int[] a=new int[10];
        Scanner sc =new Scanner(System.in);
        System.out.println("enter no. of processes");
        n=sc.nextInt();
        System.out.println("enter process burst time");
        for(int i=1;i<=n;i++)
        {
            System.out.println("enter for process "+i+": ");
            a[i]=sc.nextInt();
        }
        fcfs(a,n);
    }
    
}
