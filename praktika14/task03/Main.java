package praktika14.task03;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // Цена: целое или число с 1-2 знаками после точки, пробел и валюта USD / RUB / EU.
    // (?<![\d.]) - перед числом не должно быть цифры или точки, чтобы из "0.004 EU"
    // не вырезалось "004 EU".  \b - валюта заканчивается на границе слова.
    static final String REGEX = "(?<![\\d.])\\d+(?:\\.\\d{1,2})?\\s(?:USD|RUB|EU)\\b";

    public static void main(String[] args) {
        String text = "Прайс: наушники 25.98 USD, чехол 44 ERR, книга 100 RUB, "
                + "значок 0.004 EU, чайник 15.5 EU, куртка 1200.00 RUB, ручка 3 USD.";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(text);

        System.out.println("Текст: " + text);
        System.out.println("Найденные цены:");
        while (m.find()) {
            System.out.println("  " + m.group());
        }
    }
}