package praktika14.task01;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String text = sc.nextLine();

        int choice = -1;
        while (choice != 0) {
            System.out.println();
            System.out.println("Строка: \"" + text + "\"");
            System.out.println("1 - разбить на части по разделителям (пробел , . ;)");
            System.out.println("2 - найти все слова");
            System.out.println("3 - найти все числа");
            System.out.println("4 - заменить все цифры на #");
            System.out.println("5 - ввести другую строку");
            System.out.println("0 - выход");
            System.out.print("Ваш выбор: ");

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Введите число от 0 до 5: ");
            }
            choice = sc.nextInt();
            sc.nextLine();          // забираем остаток строки после числа

            switch (choice) {
                case 1:
                    split(text);
                    break;
                case 2:
                    findAll(text, "\\p{L}+", "Слова");
                    break;
                case 3:
                    findAll(text, "\\d+(\\.\\d+)?", "Числа");
                    break;
                case 4:
                    replaceDigits(text);
                    break;
                case 5:
                    System.out.print("Введите строку: ");
                    text = sc.nextLine();
                    break;
                case 0:
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Нет такого пункта меню.");
            }
        }
    }

    // Разбиение строки: шаблон задаёт разделитель (Pattern.split)
    static void split(String text) {
        Pattern p = Pattern.compile("[\\s,.;]+");
        String[] parts = p.split(text);
        System.out.println("Частей: " + parts.length);
        for (int i = 0; i < parts.length; i++) {
            System.out.println((i + 1) + ") " + parts[i]);
        }
    }

    // Поиск всех фрагментов, подходящих под шаблон (Matcher.find)
    static void findAll(String text, String regex, String title) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        int count = 0;
        System.out.println(title + ":");
        while (m.find()) {
            count++;
            System.out.println("  " + m.group() + "  (позиции " + m.start() + "-" + m.end() + ")");
        }
        if (count == 0) {
            System.out.println("  ничего не найдено");
        }
    }

    // Замена всех найденных фрагментов (Matcher.replaceAll)
    static void replaceDigits(String text) {
        Matcher m = Pattern.compile("\\d").matcher(text);
        System.out.println(m.replaceAll("#"));
    }
}