import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Задание 1
//        System.out.println(ArithmeticMean(3.14));
//        System.out.println(ArithmeticMean(10.12345));
//        System.out.println(ArithmeticMean(5.0));
//
//        // Задание 2
//        var change = Vending(21, 150);
//        change.forEach((key, value) -> System.out.println(key + " " + value));

        // Задание 3
        System.out.println(Lenses(new int[] {-1, 0, 1}));
        System.out.println(Lenses(new int[] {-1, 3, -3, 7}));
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
            int count = fin / denomination; // Сколько купюр данного номинала мы можем взять
            if (count > 0) {
                result.put(denomination, count);
                fin -= count * denomination; // Уменьшаем остаток
            }
        }
        return result;
    }

    // <summary> Задание 3 Заказы на линзы для Инопланетян </summary>
    // <param name="dioptries"> Значения диоптрий каждого Инопланетянина </param>
    // <returns> Количество пар линз </returns>
    public static int Lenses(int[] dioptries) {
        int pairs = 0;
        boolean[] used = new boolean[dioptries.length];

        for (int i = 0; i < dioptries.length; i++) {
            if (!used[i]) {
                int closestPositive = Integer.MAX_VALUE;
                int closestNegative = Integer.MIN_VALUE;

                for (int j = 0; j < dioptries.length; j++) {
                    if (dioptries[j] > dioptries[i]) {
                        closestPositive = Math.min(closestPositive, dioptries[j]);
                    } else if (dioptries[j] <= dioptries[i]) {
                        closestNegative = Math.max(closestNegative, dioptries[j]);
                    }
                }

                // Ищем ближайшие пары линз для текущего инопланетянина
                for (int j = 0; j < dioptries.length; j++) {
                    if (dioptries[j] == closestPositive || dioptries[j] == closestNegative) {
                        used[j] = true;
                    }
                }

                pairs++;
            }
        }

        return pairs;
    }
}