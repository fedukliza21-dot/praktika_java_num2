package praktika09.task02;
import praktika09.task01.Student;
import java.util.Comparator;

// Второй компаратор: сортировка студентов по фамилии в алфавитном порядке
public class SortingStudentsBySurname implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student a = (Student) o1;
        Student b = (Student) o2;
        return a.getSurname().compareTo(b.getSurname());
    }
}