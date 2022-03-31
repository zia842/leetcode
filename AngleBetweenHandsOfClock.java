
public class AngleBetweenHandsOfClock {

	public double angleClock(int hour, int minutes) {
		int oneMinAngle = 6; //Circle is 360. There are 60 mins in an hour 360 / 60 = 6 Degree in each min
		int oneHourAngle = 30; //Similarly There are 12 Hours 360 / 12 = 30 Degree in Hour

		double minutesAngle = oneMinAngle * minutes;
		double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle; //For 12th hour actual angle is Zero

		double diff = Math.abs(hourAngle - minutesAngle);
		return Math.min(diff, 360 - diff);
	}

}
