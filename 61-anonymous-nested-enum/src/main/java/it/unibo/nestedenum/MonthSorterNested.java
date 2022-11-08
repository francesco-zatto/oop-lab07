package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private static final int SHORT_MONTH = 28;
    private static final int USUAL_MONTH = 30;
    private static final int LONG_MONTH = 31;

    enum Month {

        JANUARY(LONG_MONTH, "JANUARY"), FEBRUARY(SHORT_MONTH, "FEBRUARY"), MARCH(LONG_MONTH, "MARCH"), 
        APRIL(USUAL_MONTH, "APRIL"), MAY(LONG_MONTH, "MAY"), JUNE(USUAL_MONTH, "JUNE"), 
        JULY(LONG_MONTH, "JULY"), AUGUST(LONG_MONTH, "AUGUST"), SEPTEMBER(USUAL_MONTH, "SEPTEMBER"),
        OCTOBER(LONG_MONTH, "OCTOBER"), NOVEMBER(USUAL_MONTH, "NOVEMBER"), DECEMBER(LONG_MONTH, "DECEMBER");

        private final int days;
        private final String name;

        private Month(int days, String name) {
            this.days = days;
            this.name = name;
        }

        public Month fromString(String string) throws IllegalArgumentException {
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
