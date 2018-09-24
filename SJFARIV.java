
package fcfsariv;
import java.util.Arrays;
import java.util.Scanner;

public class SJFARIV {

     public static void fcfs(int a[],int n,int av[])
    {
        Arrays.sort(a);
        System.out.println("array ");
        for(int i=0;i<n;i++)
        {
            System.out.println(a[i]);
        }
        int t=0;
        float awtat=0,atat=0;
        int[] wt=new int[n];
        int[] tat=new int[n];
        for(int i=0;i<n;i++)
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
    public static void main(String[] args) {
        int n;
        Scanner sc =new Scanner(System.in);
        System.out.println("enter no. of processes");
        n=sc.nextInt();
        //n=n-1;
        int[] a=new int[n];
        int[] av=new int[n];
        
        
        System.out.println("enter process burst time");
        for(int i=0;i<n;i++)
        {
            System.out.println("enter for process "+i+": ");
            a[i]=sc.nextInt();
        }
        for(int j=0;j<n;j++)
        {
            System.out.println("enter arrival time of process "+j+": ");
            av[j]=sc.nextInt();
        }
        fcfs(a,n,av);
    }
    
}
