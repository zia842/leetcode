import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {

	public int start;
	public int end;

	public Interval() {}

	public Interval(int _start, int _end) {
		start = _start;
		end = _end;
	}
}

public class EmployeeFreeTime {

	/**
	 *  Time Complexity O (N LOG N)
	 *  Space Complexity O(N)
	 * @param schedule
	 * @return
	 */
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> freeTime = new ArrayList<Interval>();
		List<Interval> allIntervals = new ArrayList<Interval>();

		//Combine All Employee Schedule
		for(int i = 0; i < schedule.size(); i++) {
			allIntervals.addAll(schedule.get(i));
		}

		List<Interval> mergedIntervals = mergeIntervals(allIntervals);

		for(int i = 0; i < mergedIntervals.size() - 1; i++) {
			if(mergedIntervals.get(i).end < mergedIntervals.get(i + 1).start) {
				freeTime.add(new Interval(mergedIntervals.get(i).end, mergedIntervals.get(i + 1).start));
			}
		}

		return freeTime;
	}

	/**
	 * Time Complexity O (N LOG N)
	 * @param allIntervals
	 * @return
	 */
	public List<Interval> mergeIntervals(List<Interval> allIntervals) {
		List<Interval> mergedIntervals = new ArrayList<Interval>(); 

		//Sort Intervals by Start Time
		Collections.sort(allIntervals, new Comparator<Interval>() { //NLOG(N)
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		for(Interval interval : allIntervals) { //O(N)
			int lastIndex = mergedIntervals.size() - 1;
			if(mergedIntervals.size() == 0 || interval.start > mergedIntervals.get(lastIndex).end) {
				mergedIntervals.add(interval);
			} else {
				mergedIntervals.get(lastIndex).end = interval.end > mergedIntervals.get(lastIndex).end ? interval.end : mergedIntervals.get(lastIndex).end;
			}
		}

		return mergedIntervals;
	}

	public static void main(String []args) {
		EmployeeFreeTime e = new EmployeeFreeTime();
		Interval iOne = new Interval(1, 2);
		Interval iTwo = new Interval(5, 6);
		Interval iThree = new Interval(1, 3);
		Interval iFour = new Interval(4, 10);

		List<Interval> iListOne = new ArrayList<Interval>();
		iListOne.add(iOne); iListOne.add(iTwo);

		List<Interval> iListTwo = new ArrayList<Interval>();
		iListTwo.add(iThree); 

		List<Interval> iListThree = new ArrayList<Interval>();
		iListThree.add(iFour);

		List<List<Interval>> employeeInterval = new ArrayList<List<Interval>>();
		employeeInterval.add(iListOne);
		employeeInterval.add(iListTwo);
		employeeInterval.add(iListThree);

		List<Interval> resultList = e.employeeFreeTime(employeeInterval);
		System.out.println(resultList.get(0).start);
		System.out.println(resultList.get(0).end);


	}

}
