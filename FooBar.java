import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
	private int n;
	
	private static final String FOO = "foo";
    private static final String BAR = "bar";
    
    private AtomicReference<String> lastProcessedString = new AtomicReference<>(BAR);
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {

			// printFoo.run() outputs "foo". Do not change or remove this line.
			process(FOO, printFoo);
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {

			// printBar.run() outputs "bar". Do not change or remove this line.
			process(BAR, printBar);
		}
	}
	
	private void process(String method, Runnable job) throws InterruptedException
    {
        lock.lock();
        try
        {
            while(lastProcessedString.get() == method)
            {
                condition.await();
            }
            job.run();
            lastProcessedString.set(method);
            condition.signalAll();
        }
        finally
        {
            lock.unlock();
        }
    }
}
