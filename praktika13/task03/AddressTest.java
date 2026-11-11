package praktika13.task03;

public class AddressTest {
    public static void main(String[] args) {
        String[] withCommas = {
                "Россия, Московская область, Москва, Волгоградский пр., 7, 4, 112",
                "Россия, Тамбовская область, Тамбов, ул. Советская, 10, 6, 8",
                "Россия, Тверская область , Тверь, б-р Ногина, 10, 1, 100",
                "Россия, Ленинградская область, Санкт-Петербург, Невский пр., 28, 1, 101"
        };

        System.out.println("=== а) split(\",\") ===");
        for (int i = 0; i < withCommas.length; i++) {
            Address a = new Address();
            a.parseWithSplit(withCommas[i]);
            System.out.println(a);
            System.out.println();
        }

        // Те же адреса, но с разными разделителями: , . ;
        // Внутри частей адреса точек нет ("пр", а не "пр."), иначе токенайзер
        // примет их за разделитель и разобьёт часть пополам.
        String[] mixed = {
                "Россия; Московская область, Москва; Волгоградский пр., 7; 4, 112",
                "Россия, Тамбовская область; Тамбов, ул Советская; 10, 6; 8",
                "Россия. Тверская область . Тверь. б-р Ногина. 10. 1. 100",
                "Россия; Ленинградская область; Санкт-Петербург; Невский пр.; 28; 1; 101"
        };

        System.out.println("=== б) StringTokenizer (разделители , . ;) ===");
        for (int i = 0; i < mixed.length; i++) {
            Address a = new Address();
            a.parseWithTokenizer(mixed[i]);
            System.out.println(a);
            System.out.println();
        }
    }
}