package zjucst;

import java.math.BigInteger;

public class NextNdays {
    private BigInteger year;
    private int month;
    private int day;

    private final int[][] monthDays = {{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};

    private final BigInteger commonYearDay= new BigInteger("365");
    private final BigInteger leapYearDay = new BigInteger("366");
    private final BigInteger specialYearDay = new BigInteger("355");
    private final BigInteger specialYear = new BigInteger("1582");
    private final BigInteger afterSpecialYear = new BigInteger("1583");
    private final BigInteger beforeSpecialYear = new BigInteger("1581");

    int isLeapYear() {
        if (year.compareTo(specialYear) < 0) {
            if (year.remainder(Number.four).equals(Number.zero)) {
                return 1;
            }
            else
                return 0;
        }

        if (year.remainder(Number.four).equals(Number.zero) && !year.remainder(Number.oneHundred).equals(Number.zero) ||
                (year.remainder(Number.fourHundred).equals(Number.zero))) {
            return 1;
        }
        else
            return 0;
    }

    int isNextLeapYear() {
        BigInteger tmp_year = year.add(Number.one);
        if (tmp_year.compareTo(specialYear) < 0) {
            if (tmp_year.remainder(Number.four).equals(Number.zero)) {
                return 1;
            }
            else
                return 0;
        }

        if (tmp_year.remainder(Number.four).equals(Number.zero) && !tmp_year.remainder(Number.oneHundred).equals(Number.zero) ||
                (tmp_year.remainder(Number.fourHundred).equals(Number.zero))) {
            return 1;
        }
        else
            return 0;
    }

    void patchGaps() {
        if (year.compareTo(specialYear) == 0 && month == 10 && day > 4 && day < 15) {
            day += 10;
        }
    }

    void firstYearAD() {
        if (year.compareTo(Number.zero) == 0)
            year = year.add(Number.one);
    }

    void lastYearBD() {
        if (year.compareTo(Number.zero) == 0)
            year = year.subtract(Number.one);
    }

    int nextYear(BigInteger n) {
        while (n.compareTo(leapYearDay) > 0) {
            if (year.compareTo(beforeSpecialYear) == 0 && (month > 10 || (month == 10 && day >= 15))) {
                n = n.subtract(specialYearDay);
            }
            else if (year.compareTo(specialYear) == 0 && (month < 10 || (month == 10 && day <= 4))) {
                n = n.subtract(specialYearDay);
            }
            else if ((month > 2 ||  month == 2 && day == 29) && isNextLeapYear() == 1) {
                n = n.subtract(leapYearDay);
            }
            else if ((month < 2 || (month == 2 && day <= 28)) && isLeapYear() == 1) {
                n = n.subtract(leapYearDay);
            }
            else {
                n = n.subtract(commonYearDay);
            }
            year = year.add(Number.one);
            firstYearAD();
        }

        return n.intValue();
    }

    int lastYear(BigInteger n) {
        while (n.compareTo(Number.zero) < 0) {
            if (year.compareTo(specialYear) == 0 && (month > 10 || (month == 10 && day >= 15))) {
                n = n.add(specialYearDay);
            }
            else if (year.compareTo(afterSpecialYear) == 0 && (month < 10 || (month == 10 && day <= 4))) {
                n = n.add(specialYearDay);
            }
            else if (month > 2 && isLeapYear() == 1) {
                n = n.add(leapYearDay);

            }
            else if (month == 2 && day == 29) {
                n = n.add(leapYearDay);
                day = 28;
            }
            else {
                n = n.add(commonYearDay);
            }
            year = year.subtract(Number.one);
            lastYearBD();
        }

        return n.intValue();
    }


    void nextDay() {
        day++;
        if (day > monthDays[isLeapYear()][month-1]) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year = year.add(Number.one);
                firstYearAD();
            }
        }
        patchGaps();
    }

    BigInteger toBigInteger(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-' && s.charAt(i) != '+' && !(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return new BigInteger("0");
            }
        }
        return new BigInteger(s);
    }

    int toInt(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-' && s.charAt(i) != '+' && !(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return 0;
            }
        }
        return Integer.parseInt(s);
    }

    public String nextNdays(String y, String m, String d, String ndays) {
        year = toBigInteger(y);
        month = toInt(m);
        day = toInt(d);
        BigInteger n = toBigInteger(ndays);

        if (year.compareTo(Number.zero) == 0 || month < 1 || month > 12 || day < 1 || day > monthDays[isLeapYear()][month-1] ||
                (year.compareTo(specialYear) == 0 && month == 10 && day > 4 && day < 15)) {
            return "输入参数错误";
        }

        patchGaps();

        int remainDays;
        if (n.compareTo(Number.zero) >= 0) {
            remainDays = nextYear(n);
        }
        else {
            remainDays = lastYear(n);
        }
        for (int i = 0; i < remainDays; i++) {
            nextDay();
        }

        return this.year + "-" + this.month + "-" + this.day;
    }

}