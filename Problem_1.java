import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year, month;
        //taking the value of Year
        System.out.print("Enter a Year: ");
        year = input.nextInt();
        //checking the validity of the Year
        while (year < 1) {
            System.out.print("Wrong entry, please Enter a year: ");
            year = input.nextInt();
        }
        //taking the value of month
        System.out.print("Enter a Month: ");
        month = input.nextInt();
        //checking the validity of the month
        while (month < 1 || month > 12) {
            System.out.print("Wrong entry, please Enter a month: ");
            month = input.nextInt();
        }
        //checking Leap Year
        GregorianCalendar year1 = new GregorianCalendar();
        boolean L = year1.isLeapYear(year);

        int[] monthdays = {31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 29, 30};
        int[] monthdaysL = {31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 30};
        int dayNum = getDay(year);
        int counter = 1,temp;
        //getting the first day of the month
        if(L){
            temp=dayNum;
            if(month==10 || month==11 || month==12){
                dayNum=getDay(year-1);
                temp=dayNum;
                for(int i=0;i<month-1;i++){
                    temp=temp+monthdaysL[i];
                }
                dayNum=temp%7;
                if(dayNum==0){
                    dayNum=7;
                }
            }
            else if(month != 1){
                for(int i=0;i<month-1;i++){
                    temp=temp+monthdaysL[i];
                }
            }
            dayNum=temp%7;
            if(dayNum==0){
                dayNum=7;
            }
        }
        else{
            temp=dayNum;
            if(month==10 || month==11 || month==12){
                dayNum=getDay(year-1);
                temp=dayNum;
                for(int i=0;i<month-1;i++){
                    temp=temp+monthdays[i];
                }
                dayNum=temp%7;
                if(dayNum==0){
                    dayNum=7;
                }
            }
            else if(month != 1){
                for(int i=0;i<month-1;i++){
                    temp=temp+monthdays[i];
                }
            }
            dayNum=temp%7;
            if(dayNum==0){
                dayNum=7;
            }
        }
        //printing the output
            System.out.println();
            System.out.println("YEAR: " + year);
            System.out.println("MONTH: " + monthName(month));
            System.out.println("_________________________________________________");
            System.out.println("Robi  Som  Mongol  Budh  Brihos  Shukra  Soni");
        if (L) {
            for (int i = 0; i < dayNum - 1; i++, counter++) {
                System.out.printf("%-7s", "");
            }
            for (int i = 1; i <= monthdaysL[month-1]; i++, counter++) {
                System.out.printf("%-7d", i);
                if (counter % 7 == 0) {
                    System.out.println();
                }
            }
        }
        else{
            for (int i = 0; i < dayNum-1; i++, counter++) {
                System.out.printf("%-7s", "");
            }
            for (int i = 1; i <= monthdays[month-1]; i++, counter++) {
                System.out.printf("%-7d", i);
                if (counter % 7 == 0) {
                    System.out.println();
                }
            }
        }

        }

        public static String monthName ( int m){
            String monthName = "Error";
            switch (m) {
                case 1 -> {
                    monthName = "Boisakh";
                    return monthName;
                }
                case 2 -> {
                    monthName = "Jyoistho";
                    return monthName;
                }
                case 3 -> {
                    monthName = "Asharh";
                    return monthName;
                }
                case 4 -> {
                    monthName = "Shrabon";
                    return monthName;
                }
                case 5 -> {
                    monthName = "Bhadro";
                    return monthName;
                }
                case 6 -> {
                    monthName = "Ashshin";
                    return monthName;
                }
                case 7 -> {
                    monthName = "Kartik";
                    return monthName;
                }
                case 8 -> {
                    monthName = "Ogrohayon";
                    return monthName;
                }
                case 9 -> {
                    monthName = "Poush";
                    return monthName;
                }
                case 10 -> {
                    monthName = "Magh";
                    return monthName;
                }
                case 11 -> {
                    monthName = "Falgun";
                    return monthName;
                }
                case 12 -> {
                    monthName = "Choitro";
                    return monthName;
                }
            }
            return monthName;
        }

        public static int getDay ( int year){
            Calendar c = Calendar.getInstance();
            c.set(year, 3, 14);
            int day = c.get(Calendar.DAY_OF_WEEK);
            return day;
        }
    }