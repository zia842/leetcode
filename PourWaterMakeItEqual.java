public class PourWaterMakeItEqual {

	public double equalizeWater(int[] buckets, int loss) {
		double lo = 0;
		double hi = 100_000;
		double retainPercent = (100.0 - loss) / 100;
		
		while(hi - lo > 0.00001) { //Precision as double 
			
			double mid = (lo + hi) / 2, need = 0, have = 0;
            for(int b : buckets)
                if(b >= mid)
                    have += b - mid;
                else need += mid - b;
            if(have * retainPercent >= need)
                lo = mid;
            else hi = mid;
			
		}
		
		return lo;

	}

}
