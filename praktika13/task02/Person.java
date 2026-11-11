package praktika13.task02;

public class Person {
    private String surname;     // Фамилия
    private String name;        // Имя (может отсутствовать)
    private String patronymic;  // Отчество (может отсутствовать)

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    // Возвращает "Фамилия И.О."; если имени или отчества нет, соответствующая
    // часть пропускается. Для быстродействия используется один StringBuilder
    // нужной ёмкости и charAt(0) вместо создания лишних подстрок.
    public String getShortName() {
        StringBuilder sb = new StringBuilder(surname.length() + 5);
        sb.append(surname);
        if (name != null && !name.isEmpty()) {
            sb.append(' ').append(name.charAt(0)).append('.');
            if (patronymic != null && !patronymic.isEmpty()) {
                sb.append(patronymic.charAt(0)).append('.');
            }
        } else if (patronymic != null && !patronymic.isEmpty()) {
            // имени нет, но есть отчество
            sb.append(' ').append(patronymic.charAt(0)).append('.');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Person("Федик", "Елизавета", "Александровна").getShortName());
        System.out.println(new Person("Федик", "Елизавета", null).getShortName());
        System.out.println(new Person("Федик", "", "Александровна").getShortName());
        System.out.println(new Person("Федик", null, null).getShortName());
    }
}