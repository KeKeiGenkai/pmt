import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        System.out.println(ArithmeticMean(3.14));

        // Задание 2
        var change = Vending(21, 50);
        change.forEach((key, value) -> System.out.println(key + " " + value));

        // Задание 3
        System.out.println(Lenses(new int[] {-1, 0, 1}));
    }

    // <summary> Задание 1 Среднее арифметическое цифр дробной части числа </summary>
    // <param name="x"> Число Х </param>
    // <returns> Среднее арифметическое </returns>
    public static Double ArithmeticMean(Double x) {

        if (x % 1 == 0)
            return 0.0;

        String numStr = String.valueOf(x);

        int commaIndex = numStr.indexOf('.');

        double sum = 0;
        int count = numStr.length() - commaIndex - 1;

        for (int i = commaIndex + 1; i < numStr.length(); i++)
            sum += Character.getNumericValue(numStr.charAt(i));

        return sum / count;
    }

    // <summary> Задание 2 ПО для вендингового аппарата </summary>
    // <param name="orderSum"> Сумма заказа </param>
    // <param name="clientSum"> Внесенная сумма клиентом </param>
    // <returns> Сдача в виде словаря { номинал : количество }</returns>
    public static HashMap<Integer, Integer> Vending(int orderSum, int clientSum) {
        HashMap<Integer, Integer> result = new LinkedHashMap<>();
        int fin = clientSum - orderSum;
        int[] denominations = {5000, 2000, 1000, 500, 200, 100, 50, 10, 5, 2, 1};

        for (int denomination : denominations) {
            int count = fin / denomination;
            if (count > 0) {
                result.put(denomination, count);
                fin -= count * denomination;
            }
        }
        return result;
    }

    // <summary> Задание 3 Заказы на линзы для Инопланетян </summary>
    // <param name="dioptries"> Значения диоптрий каждого Инопланетянина </param>
    // <returns> Количество пар линз </returns>
    public static int Lenses(int[] dioptries) {
        int pairs = 0;

        Arrays.sort(dioptries);

        for (int i = 0; i < dioptries.length; i++) {
            if (i + 1 < dioptries.length && dioptries[i + 1] - dioptries[i] <= 2)
                i++;
            pairs++;
        }

        return pairs;
    }
}