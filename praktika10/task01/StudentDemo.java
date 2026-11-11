package praktika10.task01;

public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student("Елизавета", "Федик", "ИВТ", 2, "КВБО-11-25");
        System.out.println(s);
        s.setCourse(2);
        System.out.println(s.getSurname() + " теперь на " + s.getCourse() + " курсе");
    }
}
