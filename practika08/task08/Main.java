package practika08.task08;
import java.util.Scanner;
public class Main {
    // Сравниваем символы с краёв и сдвигаемся к середине
    static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {                         // дошли до середины
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {     // символы не совпали
            return false;
        }
        return isPalindrome(s, left + 1, right - 1); // шаг рекурсии
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String s = sc.next();
        System.out.println(isPalindrome(s, 0, s.length() - 1) ? "YES" : "NO");
    }
}