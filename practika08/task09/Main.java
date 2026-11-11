package practika08.task09;
import java.util.Scanner;

public class Main {
    // Сколько последовательностей из a нулей и b единиц без двух нулей подряд
    static long count(int a, int b) {
        if (a == 0) {              // одни единицы: ровно один вариант
            return 1;
        }
        if (b == 0) {              // одни нули: подходит только один нуль
            return a == 1 ? 1 : 0;
        }
        // последовательность заканчивается на 1: count(a, b-1)
        // заканчивается на 0, перед ним обязательно 1: count(a-1, b-1)
        return count(a, b - 1) + count(a - 1, b - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите a и b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(count(a, b));
    }
}