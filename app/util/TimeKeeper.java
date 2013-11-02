package util;

import constants.ApplicationConstants;
import java.sql.Timestamp;
import java.util.Calendar;
import models.data.Game;
import models.data.StockPrice;

import org.joda.time.DateTime;
import play.Logger;

public class TimeKeeper {

    public static long aDayInMS = 86400000;

    /**
     * @param raw
     * @return round the timestamp to day *
     */
    public static Timestamp round_to_day(Timestamp raw) {
        Calendar cal = Calendar.getInstance(); // locale-specific
        cal.setTime(raw);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return new Timestamp(cal.getTimeInMillis());
    }

    /**
     * @param thisGame
     * @return virtual time corresponding to the current real time *
     */
    public static Timestamp convert(Game thisGame) {
        int virtualDaysPast = ((int) Math.ceil((System.currentTimeMillis() - thisGame.getRealStartTime().getTime()) / (double) ApplicationConstants.MILLSECS_A_DAY))
                + thisGame.getVirtualDaysSkipped(); //always add the number of virtual days skipped.

        // by interval representing one day
        DateTime dt = new DateTime(thisGame.getVirtualStartDate().getTime());	// virtual start day

        // virtual date that is virtualDaysPast after the start day
        Timestamp ts = new Timestamp(dt.plusDays(virtualDaysPast).getMillis());
        Timestamp todaysDate = round_to_day(new Timestamp(System.currentTimeMillis()));
        //Logger.info("days past: "+virtualDaysPast);
        while (ts.before(todaysDate) && !isTradingDay(ts)) {
            ts = new Timestamp(ts.getTime() + aDayInMS);
            thisGame.setVirtualDaysSkipped(thisGame.getVirtualDaysSkipped() + 1);
        }

        return ts;
    }

    public static Timestamp getLastTradingDay(Game game) {
        Timestamp lastTradeDay = new Timestamp(game.getVirtualCurrentDate().getTime() - aDayInMS);
        while (!isTradingDay(lastTradeDay)) {
            lastTradeDay = new Timestamp(lastTradeDay.getTime() - aDayInMS);
        }

        return lastTradeDay;
    }

    public static boolean isTradingDay(Timestamp day) {
        Calendar checker = Calendar.getInstance();
        checker.setTime(day);
        if (checker.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || checker.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            //is this weekend?
            return false;
        } else {
            //if not weekend then check if stocks were traded on that day
            return StockPrice.find.where().eq("Date", round_to_day(day)).findRowCount() > 0;
        }
    }

}
