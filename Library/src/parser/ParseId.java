package parser;

import java.util.Calendar;
import java.util.Objects;

public class ParseId {
    public ParseId() {
    }

    public static String getGender(String id) {
        String initNumber = id.substring(0,1);
        String gender = null;

        switch (initNumber) {
            case "3":
                gender = "MEN";
                break;
            case "4":
                gender = "WOMEN";
                break;
            case "5":
                gender = "MEN";
                break;
            case "6":
                gender = "WOMEN";
                break;
        }

        return gender;
    }

    public static String birthday(String id) {
        String subStr = id.substring(1, 7);
        String firstSymbol = id.substring(0, 1);
        
        String year = null;

        if (Objects.equals(firstSymbol, "3") || Objects.equals(firstSymbol, "4")) {
            year = "19" + id.substring(1, 3);
        } else if (Objects.equals(firstSymbol, "5") || Objects.equals(firstSymbol, "6")){
            year = "20" + id.substring(1, 3);
        }
        
        subStr = subStr.substring(2, 4) + "-" + subStr.substring(4) + "-" + year;
        return subStr;
    }

    public static int getAge(String id) {
        int curYear = Calendar.getInstance().get(Calendar.YEAR);
        int yearOfBirth = 0;

        String firstSymbol = id.substring(0, 1);

        if (Objects.equals(firstSymbol, "3") || Objects.equals(firstSymbol, "4")) {
            yearOfBirth = Integer.valueOf("19" + id.substring(1, 3) );
        } else if (Objects.equals(firstSymbol, "5") || Objects.equals(firstSymbol, "6")){
            yearOfBirth = Integer.valueOf("20" + id.substring(1, 3) );
        }

        System.out.println(curYear + " " + yearOfBirth + " " + firstSymbol);
        return curYear - yearOfBirth;
    }

    public static int getYear(String id) {
        return Integer.valueOf(id.substring(1, 3) );
    }

    public static int getMonth(String id) {
        return Integer.valueOf(id.substring(3, 5) );
    }

    public static int getDay(String id) {
        return Integer.valueOf(id.substring(5, 7) );
    }
}
