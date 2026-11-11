package practika08.task06;
import java.util.Scanner;
public class Main {
    // рекурсия по делителю: проверяем d, d+1, ... пока d*d <= n
    static boolean isPrime(int n, int d) {
        if (d * d > n) {          // базовый случай: делителей не нашли
            return true;
        }
        if (n % d == 0) {         // базовый случай: нашли делитель
            return false;
        }
        return isPrime(n, d + 1); // шаг рекурсии: следующий делитель
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите n (n > 1): ");
        int n = sc.nextInt();
        System.out.println(isPrime(n, 2) ? "YES" : "NO");
    }
}