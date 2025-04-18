/*
 * Author: Charles J. Walker
 * Date: 11/25/24
 * File Name: Assignment5.java 
 * Purpose: This program is part 1 of 2 for Assignment 5 in SE320. It is designed to calculate the number of days passed since the author's birthday. 
 * It uses the second impelmentation of the Day class. java.time.LocalDate is impoted to use the LocalDate class to get the current date when the program is launched. 
 */
import java.time.LocalDate; //Used for creating a Day class for current day.

/*The below were used for the testing of the function in question 2.  
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
*/

public class Assignment5{

    private static final int BDAY_YEAR = 1991;
    private static final int BDAY_MONTH = 10;
    private static final int BDAY_DATE = 7;

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();

        Day today = new Day(currentDate.getYear(), currentDate.getMonthValue(), currentDate.getDayOfMonth());

        Day bDay = new Day(BDAY_YEAR, BDAY_MONTH, BDAY_DATE);

        System.out.println("Today's date is " + currentDate.getMonthValue() + "/" + currentDate.getDayOfMonth() + "/" + currentDate.getYear());
        System.out.println("Charles J. Walker's birthday is on 10/07/1991");

        System.out.println("Charles J. Walker has been alive for " + today.daysFrom(bDay) + " days.");
        /*This section was used as testing for quesiton 2. 
        Vector<Integer> test = new Vector<>(6, 10);
        LinkedList<Day> test2 = new LinkedList<>();
        Stack<String> test3 = new Stack<>();

        System.out.println("test before remove: " + test);
        System.out.println("test2 before remove: "+ test2);
        System.out.println("test3 before remove: "+ test3);

        removeDuplicates(test);
        removeDuplicates(test2);
        removeDuplicates(test3);

        System.out.println("test after remove "+ test);
        System.out.println("test2 after remove "+ test2);
        System.out.println("test3 after remove "+ test3);
        */
    }

    /*This section was used as testing for question 2.
    public static void removeDuplicates(List lst) {
        
        if (lst == null || lst.size() == 0) return;
        List copy = new ArrayList(lst);
        Iterator elements = copy.iterator();
        Object pre = elements.next();

        while(elements.hasNext()) {
            Object nex = elements.next();
            if (pre.equals(nex)) lst.remove(nex);
            else pre = nex;
 	    }
    }
    */

}

 class Day
 {
    private int julian;
    /**
       Constructs a day with a given year, month, and day
       of the Julian/Gregorian calendar. The Julian calendar
       is used for all days before October 15, 1582
       @param aYear a year != 0
       @param aMonth a month between 1 and 12
       @param aDate a date between 1 and 31
    */
    public Day(int aYear, int aMonth, int aDate)
    {
       julian = toJulian(aYear, aMonth, aDate);
    }
 
    /**
       Returns the year of this day
       @return the year
    */
    public int getYear()
    {
       return fromJulian(julian)[0];
    }
 
    /**
       Returns the month of this day
       @return the month
    */
    public int getMonth()
    {
       return fromJulian(julian)[1];
    }
 
    /**
       Returns the day of the month of this day
       @return the day of the month
    */
    public int getDate()
    {
       return fromJulian(julian)[2];
    }
 
    /**
       Returns a day that is a certain number of days away from
       this day
       @param n the number of days, can be negative
       @return a day that is n days away from this one
    */
    public Day addDays(int n)
    {
       return new Day(julian + n);
    }
 
    /**
       Returns the number of days between this day and another day.
       @param other the other day
0       @return the number of days that this day is away from 
       the other (>0 if this day comes later)
    */
    public int daysFrom(Day other)
    {
       return julian - other.julian;
    }
 
    private Day(int aJulian)
    {
       julian = aJulian;
    }
 
    /**
       Computes the Julian day number of the given day.
       @param year a year
       @param month a month
       @param date a day of the month
       @return The Julian day number that begins at noon of 
       the given day
       Positive year signifies CE, negative year BCE. 
       Remember that the year after 1 BCE was 1 CE.
 
       A convenient reference point is that May 23, 1968 noon
       is Julian day number 2440000.
 
       Julian day number 0 is a Monday.
 
       This algorithm is from Press et al., Numerical Recipes
       in C, 2nd ed., Cambridge University Press 1992
    */
    private static int toJulian(int year, int month, int date)
    {
        
       int jy = year;
       if (year < 0) jy++;
       int jm = month;
       if (month > 2) jm++;
       else
       {  
          jy--;
          jm += 13;
       }
       int jul = (int) (java.lang.Math.floor(365.25 * jy) 
             + java.lang.Math.floor(30.6001 * jm) + date + 1720995.0);
 
       int IGREG = 15 + 31 * (10 + 12 * 1582);
          // Gregorian Calendar adopted Oct. 15, 1582
 
       if (date + 31 * (month + 12 * year) >= IGREG)
          // Change over to Gregorian calendar
       {  
          int ja = (int) (0.01 * jy);
          jul += 2 - ja + (int) (0.25 * ja);
       }
       return jul;
    }
 
    /**
       Converts a Julian day number to a calendar date.
       
       This algorithm is from Press et al., Numerical Recipes
       in C, 2nd ed., Cambridge University Press 1992
 
       @param j  the Julian day number
       @return an array whose 0 entry is the year, 1 the month,
       and 2 the day of the month.
    */
    private static int[] fromJulian(int j)
    {  
       int ja = j;
    
       int JGREG = 2299161;
          // The Julian day number of the adoption of the Gregorian calendar    
 
       if (j >= JGREG)
          // Cross-over to Gregorian Calendar produces this correction
     {  
          int jalpha = (int) (((float) (j - 1867216) - 0.25) 
              / 36524.25);
         ja += 1 + jalpha - (int) (0.25 * jalpha);
       }
       int jb = ja + 1524;
       int jc = (int) (6680.0 + ((float) (jb - 2439870) - 122.1)
           / 365.25);
       int jd = (int) (365 * jc + (0.25 * jc));
       int je = (int) ((jb - jd) / 30.6001);
       int date = jb - jd - (int) (30.6001 * je);
       int month = je - 1;
       if (month > 12) month -= 12;
       int year = jc - 4715;
      if (month > 2) --year;
       if (year <= 0) --year;
       return new int[] { year, month, date };

    }
} 
