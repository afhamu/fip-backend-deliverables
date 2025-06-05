import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.Scanner;

public class WorkingWithDatesAndTimes {

    // 1. For a given year, report the length of each month within that year.
    public static void printMonthLengths(int year) {
        System.out.println("Lengths of months in year " + year + ":");
        for (Month month : Month.values()) {
            YearMonth yearMonth = YearMonth.of(year, month);
            System.out.println(month + ": " + yearMonth.lengthOfMonth() + " days");
        }
    }

    // 2. For a given month of the current year, list all of the Mondays in that month.
    public static void listMondays(int month) {
        int year = LocalDate.now().getYear();
        System.out.println("Mondays in " + Month.of(month) + " " + year + ":");

        YearMonth yearMonth = YearMonth.of(year, month);
        for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
            LocalDate date = LocalDate.of(year, month, day);
            if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
                System.out.println(date);
            }
        }
    }

    // 3. Test whether a given date occurs on Friday the 13th.
    public static void isFridayThe13th(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        boolean isFriday13th = date.getDayOfWeek() == DayOfWeek.FRIDAY && day == 13;
        if (isFriday13th) {
            System.out.println(date + " is Friday the 13th!");
        } else {
            System.out.println(date + " is NOT Friday the 13th.");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1
        System.out.print("Enter year to get month lengths: ");
        int year = scanner.nextInt();
        printMonthLengths(year);

        // Task 2
        System.out.print("\nEnter month number (1-12) to list Mondays: ");
        int month = scanner.nextInt();
        listMondays(month);

        // Task 3
        System.out.print("\nEnter year, month, and day to check for Friday the 13th: ");
        int y = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        isFridayThe13th(y, m, d);

        scanner.close();
    }
}

