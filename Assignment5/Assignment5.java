public class Day{
/**Constructs a day with a given year, month, and day
of the Julian/Gregorian calendar. The Julian calendar
is used for all days before October 15, 1582.
@param aYear a year != 0
@param aMonth a month between 1 and 12
@param aDate a date between 1 and 31 */
public Day(int aYear, int aMonth, int aDate) { . . . }
/**Returns the year of this day.
@return the year */
public int getYear() { . . . }
/** Returns the month of this day.
@return the month */
public int getMonth() { . . . }
/**
Returns the day of the month of this day.
@return the day of the month
*/
public int getDate() { . . . }
/**
Returns a day that is a certain number of days away from
this day.
@param n the number of days, can be negative
@return a day that is n days away from this one
*/
public Day addDays(int n) { . . . }
/** Returns the number of days between this day and another
day.
@param other the other day
@return the number of days that this day is away from
the other (> 0 if this day comes later)
*/
public int daysFrom(Day other) { . . . }
}
