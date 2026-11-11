package praktika11.task04;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = readInt(sc, "Год: ");
        int month = readInt(sc, "Месяц (1-12): ");
        int day = readInt(sc, "Число: ");
        int hours = readInt(sc, "Часы (0-23): ");
        int minutes = readInt(sc, "Минуты (0-59): ");

        // календарь: месяцы в Calendar нумеруются с 0, поэтому month - 1
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day, hours, minutes, 0);

        // проверка на несуществующую дату или время
        if (month < 1 || month > 12
                || cal.get(Calendar.DAY_OF_MONTH) != day
                || cal.get(Calendar.HOUR_OF_DAY) != hours
                || cal.get(Calendar.MINUTE) != minutes) {
            System.out.println("Такой даты или времени не существует.");
            return;
        }

        // объект Date получаем из календаря
        Date date = cal.getTime();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        System.out.println("Date:     " + format.format(date));
        System.out.printf("Calendar: %4d/%02d/%02d %02d:%02d%n",
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE));
    }

    static int readInt(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Введите целое число: ");
        }
        return sc.nextInt();
    }
}