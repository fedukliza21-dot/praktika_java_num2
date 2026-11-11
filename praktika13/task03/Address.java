package praktika13.task03;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    public Address() {
    }

    // а) разделитель только запятая: метод split()
    public void parseWithSplit(String text) {
        String[] parts = text.split(",");
        country = part(parts, 0);
        region = part(parts, 1);
        city = part(parts, 2);
        street = part(parts, 3);
        house = part(parts, 4);
        building = part(parts, 5);
        apartment = part(parts, 6);
    }

    // б) разделитель любой из символов ',' '.' ';' : класс StringTokenizer
    public void parseWithTokenizer(String text) {
        StringTokenizer st = new StringTokenizer(text, ",.;");
        String[] parts = new String[7];
        int i = 0;
        while (st.hasMoreTokens() && i < parts.length) {
            parts[i] = st.nextToken();
            i++;
        }
        country = part(parts, 0);
        region = part(parts, 1);
        city = part(parts, 2);
        street = part(parts, 3);
        house = part(parts, 4);
        building = part(parts, 5);
        apartment = part(parts, 6);
    }

    // Часть адреса без пробелов в начале и конце; если части нет - пустая строка
    private String part(String[] parts, int index) {
        if (index < parts.length && parts[index] != null) {
            return parts[index].trim();
        }
        return "";
    }

    @Override
    public String toString() {
        return "Страна: " + country + "\n"
                + "Регион: " + region + "\n"
                + "Город: " + city + "\n"
                + "Улица: " + street + "\n"
                + "Дом: " + house + "\n"
                + "Корпус: " + building + "\n"
                + "Квартира: " + apartment;
    }
}
