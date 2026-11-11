package praktika13.task04;

public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    // Строка вида "S001,Black Polo Shirt,Black,XL" -> объект Shirt
    public static Shirt fromString(String line) {
        String[] f = line.split(",");
        return new Shirt(f[0].trim(), f[1].trim(), f[2].trim(), f[3].trim());
    }

    public String getId() { return id; }
    public String getDescription() { return description; }
    public String getColor() { return color; }
    public String getSize() { return size; }

    @Override
    public String toString() {
        return "Артикул: " + id + "\n"
                + "Описание: " + description + "\n"
                + "Цвет: " + color + "\n"
                + "Размер: " + size;
    }
}