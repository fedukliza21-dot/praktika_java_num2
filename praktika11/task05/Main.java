package praktika11.task05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static final int N = 30000;

    public static void main(String[] args) {
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();

        System.out.println("N = " + N + " элементов, время в миллисекундах");
        System.out.printf("%-34s %10s %10s%n", "Операция", "ArrayList", "LinkedList");

        // 1) добавление в конец
        print("Добавление в конец", addToEnd(arrayList), addToEnd(linkedList));

        // 2) поиск по значению (indexOf перебирает элементы)
        print("Поиск по значению (1000 поисков)", search(arrayList), search(linkedList));

        // 3) доступ по индексу
        print("Доступ по индексу (get)", getByIndex(arrayList), getByIndex(linkedList));

        // 4) удаление из середины
        print("Удаление из середины", removeMiddle(arrayList), removeMiddle(linkedList));

        // 5) вставка в начало
        print("Вставка в начало", insertAtStart(arrayList), insertAtStart(linkedList));

        // 6) удаление из начала
        print("Удаление из начала", removeFirst(arrayList), removeFirst(linkedList));
    }

    static void print(String title, double a, double l) {
        System.out.printf("%-34s %10.2f %10.2f%n", title, a, l);
    }

    // Все методы возвращают время в миллисекундах (замер через System.nanoTime)
    static double addToEnd(List list) {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(i));
        }
        return (System.nanoTime() - start) / 1000000.0;
    }

    static double search(List list) {
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.indexOf(Integer.valueOf(N - 1 - i));   // ищем элементы ближе к концу
        }
        return (System.nanoTime() - start) / 1000000.0;
    }

    static double getByIndex(List list) {
        long start = System.nanoTime();
        for (int i = 0; i < list.size(); i += 10) {
            list.get(i);
        }
        return (System.nanoTime() - start) / 1000000.0;
    }

    static double removeMiddle(List list) {
        long start = System.nanoTime();
        for (int i = 0; i < 5000; i++) {
            list.remove(list.size() / 2);   // индекс -> remove(int)
        }
        return (System.nanoTime() - start) / 1000000.0;
    }

    static double insertAtStart(List list) {
        long start = System.nanoTime();
        for (int i = 0; i < 5000; i++) {
            list.add(0, Integer.valueOf(i));
        }
        return (System.nanoTime() - start) / 1000000.0;
    }

    static double removeFirst(List list) {
        long start = System.nanoTime();
        for (int i = 0; i < 5000; i++) {
            list.remove(0);
        }
        return (System.nanoTime() - start) / 1000000.0;
    }
}