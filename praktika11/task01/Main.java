package praktika11.task01;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String developer = "Федик";
        String receivedAt = "28.09.2026 00:00:00";

        // дата и время сдачи: текущий момент
        Date submitted = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("Разработчик: " + developer);
        System.out.println("Задание получено: " + receivedAt);
        System.out.println("Задание сдано:    " + format.format(submitted));
    }
}