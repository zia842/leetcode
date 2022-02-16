import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

	private ReentrantLock tryEat = new ReentrantLock();

	public DiningPhilosophers() {

	}


	// call the run() method of any runnable to execute its code
	public void wantsToEat(int philosopher,
			Runnable pickLeftFork,
			Runnable pickRightFork,
			Runnable eat,
			Runnable putLeftFork,
			Runnable putRightFork) throws InterruptedException
	{
		tryEat.lock();       
		pickLeftFork.run();
		pickRightFork.run();
		eat.run();
		putLeftFork.run();
		putRightFork.run();        
		tryEat.unlock();
	}

}
