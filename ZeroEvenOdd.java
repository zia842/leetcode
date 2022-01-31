import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;



public class ZeroEvenOdd {
	
	
	private int n;
	ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    final String[] methods = {"ZERO", "EVEN", "ODD"};
    private volatile String curentMethod = methods[0];

	public ZeroEvenOdd(int n) {
		this.n = n;
	}
	
	private class ThreadA extends Thread{
		public void run() {
			IntConsumer zero = a -> a *= n;
			try 
			{
				zero(zero);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private class ThreadB extends Thread {
		public void run() {
			IntConsumer odd = a -> a *= n;
			try {
				odd(odd);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private class ThreadC extends Thread {
		public void run() {
			IntConsumer even = a -> a *= n;
			try {
				even(even);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i < n+1; i++)
            job(printNumber, 0, methods[0]);
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i < n+1; i++)
            job(printNumber, i, methods[1]);
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i < n+1; i++)
            job(printNumber, i, methods[2]);
	}

	void job(IntConsumer printN, int cou, String method) throws InterruptedException{
		try 
		{
			lock.lock();
			
			while (!method.equals(curentMethod))
				condition.await();
			
			if (method.equals(methods[0])){
				curentMethod = methods[1];
				printN.accept(0);
				System.out.print(0);
			} 
			else if (method.equals(methods[1])){
				curentMethod = methods[2];
				if (cou % 2 == 0) {
					printN.accept(cou);
					System.out.print(cou);
				}
					
			}
			else if (method.equals(methods[2])){
				curentMethod = methods[0];
				if (cou % 2 != 0) {
					printN.accept(cou);
					System.out.print(cou);
				}
					
			}
			
			condition.signalAll();
		} 
		finally 
		{
			lock.unlock();
		}

	}
	
	public static void main(String []args) {
		ZeroEvenOdd z = new ZeroEvenOdd(100);
		
		ThreadA a = z.new ThreadA();
		ThreadB b = z.new ThreadB();
		ThreadC c = z.new ThreadC();
		
		a.start();
		b.start();
		c.start();
		
		try {
			a.join();
			b.join();
			c.join();
		}
		catch(Exception e) {
			
		}
	}

}
