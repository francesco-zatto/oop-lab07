package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private static final String MAY_MARCH_AMBIGUOUS1 = "M"; 
    private static final String MAY_MARCH_AMBIGUOUS2 = "MA";
    private static final String JUNE_JULY_AMBIGUOUS = "JU";
    private static final String JUNE_JULY_JANUARY_AMBIGUOUS = "J";
    private static final String APRIL_AUGUST_AMBIGUOUS = "A";
    private static final int SHORT_MONTH = 28;
    private static final int USUAL_MONTH = 30;
    private static final int LONG_MONTH = 31;

    enum Month {

        JANUARY(LONG_MONTH), FEBRUARY(SHORT_MONTH), MARCH(LONG_MONTH), 
        APRIL(USUAL_MONTH), MAY(LONG_MONTH), JUNE(USUAL_MONTH), 
        JULY(LONG_MONTH), AUGUST(LONG_MONTH), SEPTEMBER(USUAL_MONTH),
        OCTOBER(LONG_MONTH), NOVEMBER(USUAL_MONTH), DECEMBER(LONG_MONTH);

        private final int days;

        private Month(int days) {
            this.days = days;
        }

        public static Month fromString(String string) throws IllegalArgumentException {
            Objects.requireNonNull(string);
            Month match = null;
            for (Month month : values()) {
                if (isStringAMonth(string.toUpperCase(), month)) {
                    match = month;
                }
            }
            try {
                return Objects.requireNonNull(match);
            } catch (NullPointerException npe) {
                throw new IllegalArgumentException(string + " is not matchable.");
            }
        }

        private static boolean isStringAMonth(String s, Month m) {
            List<String> ambiguousStrings = List.of(MAY_MARCH_AMBIGUOUS1, MAY_MARCH_AMBIGUOUS2, 
                JUNE_JULY_AMBIGUOUS, JUNE_JULY_JANUARY_AMBIGUOUS, APRIL_AUGUST_AMBIGUOUS);
            return !ambiguousStrings.contains(s) && m.toString().startsWith(s); 
        }

    }

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {

            @Override
            public int compare(String string1, String string2) {
                return Integer.compare(Month.fromString(string1).days, Month.fromString(string2).days);
            }
            
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {

            @Override
            public int compare(String month1, String month2) {
                return Month.fromString(month1).compareTo(Month.fromString(month2));
            }
            
        };
    }
}
