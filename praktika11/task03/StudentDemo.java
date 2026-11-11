package praktika11.task03;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class StudentDemo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2007, Calendar.JUNE, 19);
        Date birth = cal.getTime();

        Student s = new Student("Елизавета", "Федик", "ИВТ", 2, "КВБО-11-25", birth);

        System.out.println(s);
        System.out.println("Короткий формат: " + s.getBirthDateString(DateFormat.SHORT));
        System.out.println("Средний формат:  " + s.getBirthDateString(DateFormat.MEDIUM));
        System.out.println("Длинный формат:  " + s.getBirthDateString(DateFormat.LONG));
        System.out.println("Полный формат:   " + s.getBirthDateString(DateFormat.FULL));
        System.out.println("Свой шаблон 1:     " + s.getBirthDateString("dd.MM.yyyy"));
        System.out.println("Свой шаблон 2:     " + s.getBirthDateString("d MMMM yyyy 'г.'"));
    }
}