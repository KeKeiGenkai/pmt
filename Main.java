import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        System.out.println(ArithmeticMean(3.14));
        System.out.println(ArithmeticMean(10.12345));
        System.out.println(ArithmeticMean(5.0));

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

        if (x % 1 == 0) {
            return 0.0;
        }

        String numStr = String.valueOf(x);

        int commaIndex = numStr.indexOf('.');

        double sum = 0;
        int count = 0;

        for (int i = commaIndex + 1; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            if (digit >= 0 && digit <= 9) {
                sum += digit;
                count++;
            }
        }

        double mean = sum / count;
        return mean;
    }

    // <summary> Задание 2 ПО для вендингового аппарата </summary>
    // <param name="orderSum"> Сумма заказа </param>
    // <param name="clientSum"> Внесенная сумма клиентом </param>
    // <returns> Сдача в виде словаря { номинал : количество }</returns>
    public static HashMap<Integer, Integer> Vending(int orderSum, int clientSum) {
        HashMap<Integer, Integer> result = new HashMap<>();
        int fin = clientSum - orderSum;
        int[] denominations = {5000, 2000, 1000, 500, 200, 100, 50, 10, 5, 2, 1};

        for (int denomination : denominations) {
            while (fin >= denomination) {
                result.put(denomination, result.getOrDefault(denomination, 0) + 1);
                fin -= denomination;
            }
        }
        return result;
    }

    // <summary> Задание 3 Заказы на линзы для Инопланетян </summary>
    // <param name="dioptries"> Значения диоптрий каждого Инопланетянина </param>
    // <returns> Количество пар линз </returns>
    public static int Lenses(int[] dioptries) {
        //...
        return 0;
    }
}