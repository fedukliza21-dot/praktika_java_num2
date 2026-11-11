package praktika09.task02;
import praktika09.task01.Student;
import java.util.Comparator;

// Компаратор: чем выше балл, тем студент "меньше", т.е. порядок по убыванию GPA
public class SortingStudentsByGPA implements Comparator {

    private Student[] iDNumber;   // массив студентов

    @Override
    public int compare(Object o1, Object o2) {
        Student a = (Student) o1;
        Student b = (Student) o2;
        return Double.compare(b.getGpa(), a.getGpa());
    }

    // 1) заполнение массива
    public void setArray() {
        iDNumber = new Student[] {
                new Student(1042, "Иванов", 4.3),
                new Student(1007, "Петрова", 4.9),
                new Student(1031, "Сидоров", 3.8),
                new Student(1015, "Кузнецова", 4.6),
                new Student(1023, "Смирнов", 4.1),
                new Student(1050, "Орлов", 4.6)
        };
    }

    // 3) вывод массива
    public void outArray() {
        for (int i = 0; i < iDNumber.length; i++) {
            System.out.println(iDNumber[i]);
        }
    }

    // 2) быстрая сортировка по баллам (по убыванию)
    public void quickSort() {
        quickSort(iDNumber, 0, iDNumber.length - 1, this);
    }

    // быстрая сортировка по любому компаратору (например, по фамилии)
    public void quickSort(Comparator c) {
        quickSort(iDNumber, 0, iDNumber.length - 1, c);
    }

    // 2) сортировка слиянием по баллам (по убыванию)
    public void mergeSort() {
        mergeSort(iDNumber, 0, iDNumber.length - 1, this);
    }

    // сортировка слиянием по любому компаратору
    public void mergeSort(Comparator c) {
        mergeSort(iDNumber, 0, iDNumber.length - 1, c);
    }

    // ---------- быстрая сортировка ----------
    private void quickSort(Student[] arr, int low, int high, Comparator c) {
        if (low >= high) {                         // базовый случай
            return;
        }
        int p = partition(arr, low, high, c);      // опорный элемент встал на место p
        quickSort(arr, low, p - 1, c);
        quickSort(arr, p + 1, high, c);
    }

    private int partition(Student[] arr, int low, int high, Comparator c) {
        Student pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (c.compare(arr[j], pivot) < 0) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    private void swap(Student[] arr, int i, int j) {
        Student tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // ---------- сортировка слиянием ----------
    private void mergeSort(Student[] arr, int low, int high, Comparator c) {
        if (low >= high) {                         // базовый случай
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid, c);               // левая половина
        mergeSort(arr, mid + 1, high, c);          // правая половина
        merge(arr, low, mid, high, c);             // слияние двух отсортированных частей
    }

    private void merge(Student[] arr, int low, int mid, int high, Comparator c) {
        Student[] tmp = new Student[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (c.compare(arr[i], arr[j]) <= 0) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= high) {
            tmp[k++] = arr[j++];
        }
        for (k = 0; k < tmp.length; k++) {
            arr[low + k] = tmp[k];
        }
    }
}