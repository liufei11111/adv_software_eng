package util;

import java.sql.Timestamp;

import models.data.Game;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * 
 * @author Susan Fung
 * 
 *         This is a utility class for game related activity
 */
public class GameUtil {


	/**
	 * This returns the current day. Meaning the number of days from the start
	 * date
	 * 
	 * @param game
	 * @return
	 */
	public static int getCurrentDay(Game game) {
		DateTime startDate = new DateTime(game.getVirtualStartDate().getTime());
		DateTime currentDate = new DateTime(game.getVirtualCurrentDate().getTime());
		// got from
		// http://stackoverflow.com/questions/3802893/number-of-days-between-two-dates-in-joda-time
		int diff = Days.daysBetween(startDate.toDateMidnight(),
				currentDate.toDateMidnight()).getDays();

		return diff - game.getVirtualDaysSkipped();
	}

	/**
	 * Gets current system date
	 * 
	 * @return
	 */
	public static DateTime getCurrentDate() {
		return new DateTime();
	}

	/**
	 * Gets current system timestamp
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimeStamp() {
		return new Timestamp(System.currentTimeMillis());
	}

}
