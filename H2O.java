import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class H2O {
	
	private final Queue<Runnable> hydrogens = new ConcurrentLinkedQueue<>();
	private final Queue<Runnable> oxygens = new ConcurrentLinkedQueue<>();

	public H2O() {

	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hydrogens.add(releaseHydrogen);
		canFormWater();
		
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		oxygens.add(releaseOxygen);
		canFormWater();
	}
	
	public void canFormWater() {
		synchronized (this) {
			
			while(hydrogens.size() >= 2 && oxygens.size() >= 1) {
				hydrogens.remove().run();
				hydrogens.remove().run();
				oxygens.remove().run();
			}
			
		}
	}

}
