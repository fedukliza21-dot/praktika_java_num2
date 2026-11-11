package praktika13.task01;

public class Main {

    // 1) принимает любую строку и выполняет над ней все операции задания
    static void process(String s) {
        // 2) последний символ
        System.out.println("Последний символ: " + s.charAt(s.length() - 1));

        // 3) заканчивается ли подстрокой "!!!"
        System.out.println("Заканчивается на \"!!!\": " + s.endsWith("!!!"));

        // 4) начинается ли подстрокой "I like"
        System.out.println("Начинается с \"I like\": " + s.startsWith("I like"));

        // 5) содержит ли подстроку "Java"
        System.out.println("Содержит \"Java\": " + s.contains("Java"));

        // 6) позиция подстроки "Java"
        System.out.println("Позиция \"Java\": " + s.indexOf("Java"));

        // 7) заменить все символы "a" на "o" (строка в латинице, поэтому латинская 'a')
        System.out.println("Замена a на o: " + s.replace('a', 'o'));

        // 8) верхний регистр
        System.out.println("Верхний регистр: " + s.toUpperCase());

        // 9) нижний регистр
        System.out.println("Нижний регистр: " + s.toLowerCase());

        // 10) вырезать "Java" с помощью substring
        int pos = s.indexOf("Java");
        if (pos >= 0) {
            String cut = s.substring(0, pos) + s.substring(pos + "Java".length());
            System.out.println("Без \"Java\": " + cut);
        }

        // строка s при этом не изменилась: String неизменяема
        System.out.println("Исходная строка: " + s);
    }

    public static void main(String[] args) {
        process("I like Java!!!");
    }
}