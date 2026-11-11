package practika08.task07;
import java.util.Scanner;

public class Main {
    // выводит простые множители n по возрастанию, начиная с делителя d
    static void factorize(int n, int d) {
        if (n == 1) {              // базовый случай: раскладывать нечего
            return;
        }
        if (d * d > n) {           // остаток n сам является простым
            System.out.print(n + " ");
            return;
        }
        if (n % d == 0) {          // d - множитель, делим и остаёмся на том же d
            System.out.print(d + " ");
            factorize(n / d, d);
        } else {                   // иначе пробуем следующий делитель
            factorize(n, d + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите n (n > 1): ");
        int n = sc.nextInt();
        factorize(n, 2);
        System.out.println();
    }
}