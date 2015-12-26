package com.happydesk.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

	/**
	 * @return
	 */
	public static Date getCurrentDateTimeInGMT() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MILLISECOND, cal.getTimeZone().getRawOffset() * (-1));
		return cal.getTime();
	}

	/**
	 * @return
	 */
	public static Date getCurrentDateTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.getTime();
	}

	/**
	 * @return
	 */
	public static Calendar getCustomCalendarInstance() {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(0);
		return cal;
	}

	/**
	 * @param currentDate
	 * @param noOfDays
	 * @return
	 */
	public static Date getPreviousDateByDays(Date currentDate, int noOfDays) {
		Calendar currentCalander = Calendar.getInstance();
		currentCalander.setTime(currentDate);
		currentCalander.add(Calendar.DAY_OF_YEAR, -noOfDays);
		return currentCalander.getTime();
	}

	/**
	 * @param date
	 * @return
	 */
	public static long getTimeInMilis(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

}
