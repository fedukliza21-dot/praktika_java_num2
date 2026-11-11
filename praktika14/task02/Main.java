package praktika14.task02;
import java.util.regex.Pattern;

public class Main {
    static final String REGEX = "abcdefghijklmnopqrstuv18340";

    static boolean check(String s) {
        return Pattern.matches(REGEX, s);   // matches() проверяет всю строку целиком
    }

    public static void main(String[] args) {
        String[] tests = {
                "abcdefghijklmnopqrstuv18340",
                "abcdefghijklmnoasdfasdpqrstuv18340",
                "abcdefghijklmnopqrstuv18341",
                "xabcdefghijklmnopqrstuv18340",
                ""
        };
        for (int i = 0; i < tests.length; i++) {
            System.out.println("\"" + tests[i] + "\" -> " + check(tests[i]));
        }
    }
}