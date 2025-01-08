package avoid_extra_objects;

import java.util.regex.Pattern;

public class RomanNumerals {
    private static final Pattern ROMAN =
            Pattern.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    public static boolean isRomanNumeral(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        return ROMAN.matcher(s).matches();
    }
}
