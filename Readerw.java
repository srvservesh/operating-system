
package readerw;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
public class Readerw {
    static int rc=0;
    static Semaphore s=new Semaphore(1);
    static Semaphore wrt=new Semaphore(1);
    static class Reader implements Runnable
    {
        public void run()
        {
            try{                          
            s.acquire();
            rc=rc+1;
            if(rc==1)
            {
                wrt.acquire();
               
            }
            s.release();
            System.out.println(Thread.currentThread().getName()+"is reading");
            Thread.sleep(500);
            s.acquire();
            rc=rc-1;
            if(rc==0)
                wrt.release();
            s.release();
            }
            catch(Exception e)
            {
                
            }
        }
    }
    static class Writer implements Runnable{

        public void run() {
            try
            {
                wrt.acquire();
                System.out.println("writer is wri9tng");
                Thread.sleep(100);
                wrt.release();
            }
            catch(Exception e)
            {
                
            }
            }
        
    }

    public static void main(String[] args) {
        int i;
        String a;
        System.out.println("enter no. of readers");
        Scanner sc = new Scanner(System.in);
        i=sc.nextInt();
        i=i/2;
        Reader r=new Reader();
        Writer w=new Writer();
        Thread t3 = new Thread(w);      
        t3.start();
        while(i>0)
        {
        Thread t1 = new Thread(r);
            System.out.println("enter name");
        a=sc.next();
        t1.setName(a);
        t1.start();
        Thread t2 = new Thread(r);
            System.out.println("enter name");
        a=sc.next();
        t2.setName(a);
        t2.start();
        i--;
        }
        
        
        
    }
    
}
