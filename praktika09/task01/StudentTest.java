package praktika09.task01;

public class StudentTest {
    public static void main(String[] args) {
        Student[] students = {
                new Student(1042, "Иванов", 4.3),
                new Student(1007, "Петрова", 4.9),
                new Student(1031, "Сидоров", 3.8),
                new Student(1015, "Кузнецова", 4.6),
                new Student(1023, "Смирнов", 4.1)
        };

        System.out.println("До сортировки:");
        print(students);

        // Student реализует Comparable, поэтому массив можно передать как Comparable[]
        Sorting.insertionSort(students);

        System.out.println("\nПосле сортировки вставками по iDNumber:");
        print(students);
    }

    static void print(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}