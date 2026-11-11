package praktika11.task03;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student {
    private String name;        // Имя
    private String surname;     // Фамилия
    private String speciality;  // Специальность
    private int course;         // Курс
    private String group;       // Группа
    private Date birthDate;     // Дата рождения

    public Student(String name, String surname, String speciality, int course,
                   String group, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.course = course;
        this.group = group;
        this.birthDate = birthDate;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }

    public int getCourse() { return course; }
    public void setCourse(int course) { this.course = course; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    // Дата рождения по шаблону, например "dd.MM.yyyy" или "d MMMM yyyy"
    public String getBirthDateString(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.forLanguageTag("ru"));
        return format.format(birthDate);
    }

    // Дата рождения в стандартном стиле:
    // DateFormat.SHORT (короткий), DateFormat.MEDIUM (средний),
    // DateFormat.LONG (длинный), DateFormat.FULL (полный)
    public String getBirthDateString(int style) {
        DateFormat format = DateFormat.getDateInstance(style, Locale.forLanguageTag("ru"));
        return format.format(birthDate);
    }

    @Override
    public String toString() {
        return surname + " " + name + ", " + speciality + ", " + course
                + " курс, группа " + group
                + ", дата рождения: " + getBirthDateString(DateFormat.MEDIUM);
    }
}