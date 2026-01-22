package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();

        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        int dayOfMonth = currentDate.getDayOfMonth();
        Month month = currentDate.getMonth();
        int weekNumber = currentDate.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());

        String formattedOutput = String.format("Today is %s, %s %d. Week number: %d",
                                                dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault()),
                                                month.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault()),
                                                dayOfMonth,
                                                weekNumber);
        System.out.println(formattedOutput);
    }
}
