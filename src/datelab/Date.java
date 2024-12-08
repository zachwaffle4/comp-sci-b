package datelab;

public class Date {
    private final int month, day, year;
    static  final int[] DAYS_IN_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public Date(String date) throws IllegalArgumentException {
        String[] parts = date.split("/");

        month = Integer.parseInt(parts[0]);
        day = Integer.parseInt(parts[1]);
        year = Integer.parseInt(parts[2]);

        if (day > DAYS_IN_MONTH[month-1]) {
            throw new IllegalArgumentException("Too many days in that month.");
        }
    }

    public String toString() {
        return String.format("%02d/%02d/%02d", month, day, year % 100);
    }

    public static int daysApart(Date date1, Date date2) {
        int days1, days2;

        if (date1.year == date2.year) {
            days1 = daysUntil(date1, false);
            days2 = daysUntil(date2, false);
        } else {
            days1 = daysUntil(date1, true);
            days2 = daysUntil(date2, true);
        }

        int diff = Math.abs(days1-days2);

        if (date1.year % 4 == 0
                && ((date1.month < 3 && date2.month > 3)
                || (date1.month > 3 && date2.month < 3)))
            diff += 1;

        return diff;
    }

    public static int daysUntil(Date date, boolean incYear) {
        int days = date.day;

        for (int i = 0; i < date.month-1; i++) {
            days += DAYS_IN_MONTH[i];
        }

        if (incYear) {
            days += (365*date.year) + (date.year/4);
        }

        return days;
    }
}