/*
 * Author: Charles J. Walker
 * Date: 11/24/24
 * File Name: Assignment5.java
 * Note: This was the original code written before the usable versions were published on Canvas. 
 * Purpose: This program is part 1 of 2 for Assignment 5 in SE320. It is designed to calculate the number of days passed since the author's birthday. 
 * It uses partially designed Day class discussed in class. The day class is designed to assume the given dates are equal or greater than the reference julian
 * date of January 1st, 1970. The class also assumes that each day is at UT1 noon to simplify the julian date. 
 */
import java.time.LocalDate; //Used for creating a Day class for current day. 

public class Assignment5 {
    
    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();

        //Creates a day class for today.
        Day today = new Day(currentDate.getYear(), currentDate.getMonthValue(), currentDate.getDayOfMonth());
        //Creates a day class for the birthday.
        Day bDay = new Day(1991, 10, 07);

        //System.out.println("Test Julian Today: "+ today.getJulian());
        //System.out.println("Test Julian Bday: "+ bDay.getJulian());

        System.out.println("Today's date is " + currentDate.getMonthValue() + "/" + currentDate.getDayOfMonth() + "/" + currentDate.getYear());
        System.out.println("Charles J. Walker's birthday is on 10/07/1991");

        System.out.println("Charles J. Walker has been alive for " + today.daysFrom(bDay) + " days.");
      
    }
}

//Used to represent a say in the Gregorian calendar, compute the given date into 
//a julian date, and determine the number of days between two Day classes. The 
//class treats each day as UT1 noon time to simplify the julian date into a whole 
//number.  
class Day{
    //Jan 1, 1970  at noon = Julian Day 2,440,588
    private final int JULIAN_REF = 2440588;
    private final int REFERENCE_YEAR = 1970;
    private final int REFERENCE_MONTH = 1;
    private final int REFERENCE_DATE = 1;
    //All totals days into the year by month. 
    private final int FEB = 32;
    private final int MAR = 60;
    private final int APR = 91;
    private final int MAY = 121;
    private final int JUN = 152;
    private final int JUL = 182;
    private final int AUG = 213;
    private final int SEP = 244;
    private final int OCT = 274;
    private final int NOV = 305;
    private final int DEC = 335;
    //Holds the julian of the current date. 
    private int julian;

    /**Constructs a day with a given year, month, and day
    of the Gregorian calendar. Assumes the date given is 
    at or later than Jan 1st, 1970. Also assumes the correct
    number of days (aDate) is given.
    @param aYear a year >= 1970
    @param aMonth a month between 1 and 12
    @param aDate a date between 1 and 31 */
    public Day(int aYear, int aMonth, int aDate) {

        toJulian(aYear, aMonth, aDate);

    }

    /**
    Returns the julian date of this day.
    @return the julian date.
    */
    public int getJulian() {

        return julian;
        
    }
    /** Returns the number of days between this day and another
    day.
    @param other the other day
    @return the number of days that this day is away from
    the other (> 0 if this day comes later)
    */
    public int daysFrom(Day other) { 

        return julian - other.julian;
    }

    //This function requires that the year be <= to the reference year. 
    private void toJulian(int aYear, int aMonth, int aDate){

        julian = JULIAN_REF;
        int totLeapYears;

        if (aYear > REFERENCE_YEAR){

            julian += 365*(aYear - REFERENCE_YEAR);

            //System.out.println("Julian only with 356*years: " + julian);

            totLeapYears = leapYears(aYear, aMonth, aDate);//Includes current year if past Feb 29

            //System.out.println("Total leap years added: " + totLeapYears);

            julian += totLeapYears;

            //System.out.println("Julian before month added: " + julian);

            julian += monthToDays(aMonth);  

            //System.out.println("Julian before date added: "+ julian);

            julian += aDate - 1; //-1 b/c first day of the month is already accounted for. 

        }else if (aMonth > REFERENCE_MONTH){

            julian += monthToDays(aMonth); 

        }else if (aDate > REFERENCE_DATE){

            julian += (aDate - 1);//-1 b/c first day of the month is already accounted for. 

        }
    }

    //Calculates the number of leap years passed since 1970. Includes the current year iff the month is greater than 2.
    private int leapYears(int aYear, int aMonth, int aDate){

        int leapYears = 0;

        if((aYear%4 == 0) && !((aYear%100 == 0) && !(aYear%400 == 0))){//If the given date is on a leap year
        
            if(aMonth > 2 ){//If the month is greater than 2 (February) or the date falls on Feb 29. 

                    leapYears++;
            }
        }

        aYear--;//Accounts for the current year being checked.

        for (int i = aYear; i > REFERENCE_YEAR; i--){//Loops through each year in reverse until 1970.

            if((i%4 == 0) && !((i%100 == 0) && !(i%400 == 0))){

                leapYears++;
            }
        }

        return leapYears;
    }

    //This method uses the given month to determine how many days to add to the julian date via a switch case and 
    //constants.  
    private int monthToDays(int aMonth){

        int days = 0;

        switch(aMonth){
            case 1 -> {

                days = 0;

            }
            case 2 -> {

                days = FEB;

            }
            case 3 -> {

                days = MAR;

            }
            case 4 -> {

                days = APR;

            }
            case 5 -> {

                days = MAY;

            }
            case 6 -> {

                days = JUN;

            }
            case 7 -> {

                days = JUL;

            }
            case 8 -> {

                days = AUG;

            }
            case 9 -> {

                days = SEP;

            }
            case 10 -> {

                days = OCT;

            }
            case 11 -> {

                days = NOV;

            }
            case 12 -> {

                days = DEC;

            }
        }
        return days - 1;//-1 b/c January 1st is counted in the years.
    }
}


