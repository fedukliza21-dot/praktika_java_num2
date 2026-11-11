package praktika13.task05;

public class PhoneFormatter {

    // Форматы на входе:
    //   +<код страны><10 цифр>   например +79175655655, +104289652211
    //   8<10 цифр>               для России, например 89175655655
    // Формат на выходе: +<код страны><3 цифры>-<3 цифры>-<4 цифры>
    public static String format(String phone) {
        phone = phone.trim();
        String digits;     // все цифры без плюса
        String code;       // код страны

        if (phone.startsWith("+")) {
            digits = phone.substring(1);
        } else if (phone.startsWith("8") && phone.length() == 11) {
            digits = "7" + phone.substring(1);    // 8 заменяем на код России 7
        } else {
            return "Неверный формат номера";
        }

        // проверяем, что остались только цифры, и что цифр от 11 до 13
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            if (c < '0' || c > '9') {
                return "Неверный формат номера";
            }
        }
        if (digits.length() < 11 || digits.length() > 13) {
            return "Неверный формат номера";
        }

        // последние 10 цифр - номер, всё, что левее - код страны
        int codeLength = digits.length() - 10;
        code = digits.substring(0, codeLength);
        String number = digits.substring(codeLength);

        return new StringBuilder()
                .append('+').append(code)
                .append(number.substring(0, 3)).append('-')
                .append(number.substring(3, 6)).append('-')
                .append(number.substring(6))
                .toString();
    }

    public static void main(String[] args) {
        String[] tests = {"+79175655655", "+104289652211", "89175655655", "+7917565", "9175655655", "+7917abc5655"};
        for (int i = 0; i < tests.length; i++) {
            System.out.println(tests[i] + " -> " + format(tests[i]));
        }
    }
}