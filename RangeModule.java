import java.util.TreeMap;

public class RangeModule 
{

	public TreeMap<Integer, Integer> map;

	public RangeModule() {
		this.map = new TreeMap<>();
	}

	public void addRange(int left, int right) {
		int start = left, end = right;
		Integer floorKey = this.map.floorKey(left);
		if (floorKey != null && this.map.get(floorKey) >= left) {
			start = Math.min(start, floorKey);
			end = Math.max(end, this.map.get(floorKey));
			this.map.remove(floorKey);
		}
		Integer higherKey = this.map.higherKey(left);
		while (higherKey != null && higherKey <= right) {
			end = Math.max(end, this.map.get(higherKey));
			this.map.remove(higherKey);
			higherKey = map.higherKey(left);
		}
		this.map.put(start, end);
	}

	public boolean queryRange(int left, int right) {
		Integer floorKey = this.map.floorKey(left);
		if (floorKey == null)
			return false;
		return this.map.get(floorKey) >= right;
	}

	public void removeRange(int left, int right) {
		int start = left, end = right;
		Integer floorKey = this.map.floorKey(left);
		if (floorKey != null && this.map.get(floorKey) > left) {
			if (this.map.get(floorKey) <= right)
				this.map.put(floorKey, left);
			else {
				int temp = map.get(floorKey);
				this.map.put(floorKey, left);
				this.map.put(right, temp);
			}
		}
		Integer higherKey = this.map.higherKey(left);
		while (higherKey != null && higherKey < right) {
			if (this.map.get(higherKey) <= right)
				this.map.remove(higherKey);
			else {
				int temp = this.map.get(higherKey);
				this.map.remove(higherKey);
				this.map.put(right, temp);
			}
			higherKey = this.map.higherKey(left);
		}
	}	

		public static void main(String []args) {
			TreeMap<Integer, String> numMap = new TreeMap<Integer, String>();

			// Insert the values
			numMap.put(6, "Six");
			numMap.put(1, "One");
			numMap.put(5, "Five");
			numMap.put(3, "Three");
			numMap.put(8, "Eight");
			numMap.put(10, "Ten");

			System.out.println(numMap.floorKey(11));
			System.out.println(numMap.floorKey(10));
			System.out.println(numMap.floorKey(10));
			System.out.println(numMap.floorKey(9));
			
			RangeModule rangeModule = new RangeModule();
			rangeModule.addRange(10, 20);
			rangeModule.removeRange(14, 16);
			rangeModule.queryRange(10, 14); // return True,(Every number in [10, 14) is being tracked)
			rangeModule.queryRange(13, 15); // return False,(Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
			rangeModule.queryRange(16, 17); // return True, (The number 16 in [16, 17) is still being tracked, despite the remove operation)
		}


	}
