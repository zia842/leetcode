import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
import java.util.function.Predicate;

public class FizzBuzz {

	private int n;
	private int i;
	private ReentrantLock lock;

	public FizzBuzz(int n) {
		this.n = n;
		this.i = 1;
		this.lock = new ReentrantLock();
	}

	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		Predicate<Integer> pred = val -> val % 5 !=0 && val % 3 == 0;
		runThread(() -> printFizz.run(), pred);
	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		Predicate<Integer> pred = val -> val % 5 == 0 && val % 3 != 0;
		runThread(() -> printBuzz.run(), pred);
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		Predicate<Integer> pred = val -> val % 3 == 0 && val % 5 == 0;
		runThread(() -> printFizzBuzz.run(), pred);
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		Predicate<Integer> pred = val -> val % 3 != 0 && val % 5 != 0;
		runThread(() -> printNumber.accept(i), pred);
	}

	private void runThread(Runnable runnable, Predicate p) throws InterruptedException {
		try {
			lock.lock();
			while (i <= n) {
				if (p.test(i)) {
					runnable.run();
					i++;
				}
				lock.unlock();
				lock.lock();
			}
		}
		finally {
			lock.unlock();
		}
	}
}
