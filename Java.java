import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        System.out.println(ArithmeticMean(3.14));

        // Задание 2
//        var change = Vending(21, 50);
//        change.forEach((key, value) -> System.out.println(key + " " + value));

        // Задание 3
//        System.out.println(Lenses(new int[] {-1, 0, 1}));
    }

    // <summary> Задание 1 Среднее арифметическое цифр дробной части числа </summary>
    // <param name="x"> Число Х </param>
    // <returns> Среднее арифметическое </returns>
    public static Double ArithmeticMean(Double x) {

        double remainder = x % 1;

        if (remainder == 0) {
            System.out.println("Результат: 0");
            return;
        }
        // Преобразуем число в строку
        String numberStr = Double.toString(x);

        // Находим индекс символа запятой или точки
        int decimalIndex = numberStr.indexOf('.');

        // Обрезаем строку, начиная с индекса, следующего за запятой или точкой
        remainderStr = numberStr.substring(decimalIndex + 1);

        // Суммируем цифры остатка
        int sum = 0;
        for (int i = 0; i < remainderStr.length(); i++) {
            int digit = Character.getNumericValue(remainderStr.charAt(i));
            sum += digit;
        }

        // Получаем количество символов после запятой в исходном числе
        int decimalPlaces = String.valueOf(x).split("\\.")[1].length();

        // Вычисляем результат
        double result = (double) sum / decimalPlaces;

        System.out.println("Результат: " + result);
    }

    // <summary> Задание 2 ПО для вендингового аппарата </summary>
    // <param name="orderSum"> Сумма заказа </param>
    // <param name="clientSum"> Внесенная сумма клиентом </param>
    // <returns> Сдача в виде словаря { номинал : количество }</returns>
    public static HashMap<Integer, Integer> Vending(int orderSum, int clientSum) {
        //...
        return new HashMap<Integer, Integer>();
    }

    // <summary> Задание 3 Заказы на линзы для Инопланетян </summary>
    // <param name="dioptries"> Значения диоптрий каждого Инопланетянина </param>
    // <returns> Количество пар линз </returns>
    public static int Lenses(int[] dioptries) {
        //...
        return 0;
    }
}