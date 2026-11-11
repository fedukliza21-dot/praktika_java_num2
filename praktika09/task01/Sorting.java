package praktika09.task01;

public class Sorting {
    // Сортировка вставками для любых объектов, реализующих Comparable
    public static void insertionSort(Comparable[] list) {
        for (int i = 1; i < list.length; i++) {
            Comparable key = list[i];     // элемент, который вставляем
            int j = i - 1;
            // сдвигаем вправо все элементы, которые больше key
            while (j >= 0 && list[j].compareTo(key) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;            // ставим key на своё место
        }
    }
}
