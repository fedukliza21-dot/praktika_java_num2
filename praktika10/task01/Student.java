package praktika10.task01;

public class Student {
    private String name;        // Имя
    private String surname;     // Фамилия
    private String speciality;  // Специальность
    private int course;         // Курс
    private String group;       // Группа

    public Student(String name, String surname, String speciality, int course, String group) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.course = course;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return surname + " " + name + ", " + speciality + ", " + course + " курс, группа " + group;
    }
}