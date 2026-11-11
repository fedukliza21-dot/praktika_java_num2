package praktika09.task02;
import praktika09.task01.Student;
public class GPATest {
    public static void main(String[] args) {
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();

        sorter.setArray();
        System.out.println("Исходный массив:");
        sorter.outArray();

        sorter.quickSort();
        System.out.println("\nБыстрая сортировка по баллам (по убыванию):");
        sorter.outArray();

        sorter.setArray();
        sorter.mergeSort();
        System.out.println("\nСортировка слиянием по баллам (по убыванию):");
        sorter.outArray();

        sorter.setArray();
        sorter.quickSort(new SortingStudentsBySurname());
        System.out.println("\nБыстрая сортировка по фамилии:");
        sorter.outArray();

        sorter.setArray();
        sorter.mergeSort(new SortingStudentsBySurname());
        System.out.println("\nСортировка слиянием по фамилии:");
        sorter.outArray();
    }
}