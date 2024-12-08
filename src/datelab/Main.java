package datelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        try {
            File file = new File("src/datelab/dates.txt");
            Scanner sc = new Scanner(file);
            Date date1, date2;

            while (sc.hasNextLine()) {
                String[] datestrs = sc.nextLine().split(" ");
                try {
                    date1 = new Date(datestrs[0].substring(1, datestrs[0].length() - 2));
                    date2 = new Date(datestrs[1].substring(1, datestrs[1].length() - 1));

                    int diff = Date.daysApart(date1, date2);

                    System.out.printf("%s and %s are %d day%s apart\n",
                            date1, date2, diff, (diff == 1 ? "" : "s"));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        long totaltime = end - start;
        System.out.printf("Took %d millis to run.", totaltime);
    }
}