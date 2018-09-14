package prodcons;
import java.util.ArrayList;
import java.util.List;
public class ProdCons{


     public static void main(String []args){
     List<Integer> b = new ArrayList<Integer> ();
    Thread p=new Thread(new Producer(b));
    Thread c=new Thread(new Consumer(b));
    p.start();
    c.start();
     }
}
class Producer implements Runnable
{
    List<Integer> b = null ; private int i=0;final int max = 5;
    Producer(List<Integer> b)
    {
        this.b=b;
    }
    public void Produce(int i) throws InterruptedException
    {
        synchronized(b)
        {
            while(b.size()==max)
            {
                System.out.println("producer is waiting");
                b.wait();
            }
        }
        synchronized(b)
        {
            b.add(i);
            Thread.sleep(400);
            System.out.println("producer is producing");
                b.notify();
            
        }
    }
   public void run()
    {
        try
        {
            while(true)
            {
                i++;
                Produce(i);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
class Consumer implements Runnable
{
    List<Integer> b = null ; private int i=0;final int max = 5;
    Consumer(List<Integer> b)
    {
        this.b=b;
    }
    public void Consumer(int i) throws InterruptedException
    {
        synchronized(b)
        {
            while(b.isEmpty())
            {
                System.out.println("consumer is waiting");
                b.wait();
            }
        }
        synchronized(b)
        {
            b.remove(0);
            System.out.println("consumer is consuming");
            Thread.sleep(400);
                b.notify();
            
        }
    }
   public void run()
    {
        try
        {
            while(true)
            {
                i--;
                Consumer(i);
            }
        }
        catch(Exception e)
        {
            System.out.println("error");
        }
    }
    
}
