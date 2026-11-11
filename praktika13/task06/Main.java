package praktika13.task06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[] order;      // текущая цепочка (индексы слов)
    private static int[] best;       // лучшая найденная цепочка
    private static int bestLen;      // её длина

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = console.nextLine();

        // читаем слова из файла (разделитель - пробел или конец строки)
        Scanner file = new Scanner(new File(fileName));
        String[] words = new String[0];
        while (file.hasNext()) {
            words = Arrays.copyOf(words, words.length + 1);
            words[words.length - 1] = file.next();
        }
        file.close();

        System.out.println(getLine(words));
    }

    // Расставляет слова так, чтобы последняя буква слова совпадала
    // с первой буквой следующего (без учёта регистра); каждое слово - один раз.
    public static String getLine(String[] words) {
        int n = words.length;
        if (n == 0) {
            return "";
        }
        order = new int[n];
        best = new int[n];
        bestLen = 0;
        boolean[] used = new boolean[n];

        // пробуем каждое слово как первое; перебор с возвратом
        for (int first = 0; first < n && bestLen < n; first++) {
            used[first] = true;
            order[0] = first;
            search(words, used, 1);
            used[first] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bestLen; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(words[best[i]]);
        }
        return sb.toString();
    }

    // depth - сколько слов уже стоит в цепочке
    private static void search(String[] words, boolean[] used, int depth) {
        if (depth > bestLen) {                  // запоминаем самую длинную цепочку
            bestLen = depth;
            for (int i = 0; i < depth; i++) {
                best[i] = order[i];
            }
        }
        if (depth == words.length) {            // базовый случай: использованы все слова
            return;
        }
        String last = words[order[depth - 1]];
        char end = Character.toLowerCase(last.charAt(last.length() - 1));

        for (int i = 0; i < words.length && bestLen < words.length; i++) {
            if (!used[i] && Character.toLowerCase(words[i].charAt(0)) == end) {
                used[i] = true;
                order[depth] = i;
                search(words, used, depth + 1);  // шаг рекурсии
                used[i] = false;                 // возврат
            }
        }
    }
}