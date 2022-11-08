package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    enum Month {
        JANUARY(31, "JANUARY"), FEBRUARY(28, "FEBRUARY"), MARCH(31, "MARCH"), 
        APRIL(30, "APRIL"), MAY(31, "MAY"), JUNE(30, "JUNE"), 
        JULY(31, "JULY"), AUGUST(31, "AUGUST"), SEPTEMBER(30, "SEPTEMBER"),
        OCTOBER(31, "OCTOBER"), NOVEMBER(30, "NOVEMBER"), DECEMBER(31, "DECEMBER");

        private final int days;
        private final String name;

        private Month(int days, String name) {
            this.days = days;
            this.name = name;
        }

        public Month fromString(String string) {
            for (Month month : Month.values()) {
                if (isStringAMonth(string.toUpperCase(), month)) {
                    return month;
                }
            }
            throw new IllegalArgumentException("Month not found!");
        }

        private static boolean isStringAMonth(String s, Month m) {
            List<String> ambiguousStrings = List.of("MA", "M", "JU", "J", "A");
            return !ambiguousStrings.contains(s) && m.name.startsWith(s); 
        }

    }

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
