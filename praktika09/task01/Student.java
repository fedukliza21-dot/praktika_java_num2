package praktika09.task01;
public class Student implements Comparable {
    private int iDNumber;
    private String surname;
    private double gpa;

    public Student(int iDNumber, String surname, double gpa) {
        this.iDNumber = iDNumber;
        this.surname = surname;
        this.gpa = gpa;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public String getSurname() {
        return surname;
    }

    public double getGpa() {
        return gpa;
    }

    // Естественный порядок студентов: по возрастанию iDNumber
    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        if (iDNumber < other.iDNumber) {
            return -1;
        }
        if (iDNumber > other.iDNumber) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%5d  %-12s %.2f", iDNumber, surname, gpa);
    }
}