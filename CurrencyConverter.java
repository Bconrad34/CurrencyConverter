
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CurrencyConverter  {

	public static void main(String[] args) {
        Map<Integer, Money> intMoneyType = new HashMap<>();
        //rates are as of Januray 30, 2020
        intMoneyType.put(1, new Money("USD", 1.0));
        intMoneyType.put(2, new Money("EUR", 0.91));
        intMoneyType.put(3, new Money("JPY", 108.74));
        intMoneyType.put(4, new Money("CNY", 6.94));
        intMoneyType.put(5, new Money("INR", 71.58));

            Scanner in = new Scanner(System.in);

            System.out.println("Please select your input currency type by typing the corresponding number.");
            System.out.println("USD: 1");
            System.out.println("Euro: 2");
            System.out.println("Japanese Yen: 3");
            System.out.println("Chinese Yuan: 4");
            System.out.println("Indian Rupee: 5");
            int input = in.nextInt();
            Money inputCurrency = intMoneyType.get(input);

            System.out.println("\nPlease select your output currency type by typing the corresponding number.");
            System.out.println("USD: 1");
            System.out.println("Euro: 2");
            System.out.println("Japanese Yen: 3");
            System.out.println("Chinese Yuan: 4");
            System.out.println("Indian Rupee: 5");
            int output = in.nextInt();
            Money outputCurrency = intMoneyType.get(output);

            System.out.println("\nPlease type the amount you would like to convert to 2 decimal places: ");
            double amount = in.nextDouble();

            System.out.printf("\n" + amount + " " + inputCurrency.type + "->" + outputCurrency.type + ": " + "%.2f", inputCurrency.convert(outputCurrency, amount));
	}
}

class Money {
    public final String type;
    public final double currentRate;

    //constructor to set money type and name
    public Money(String type, double currentRate) {
        this.type = type;
        this.currentRate = currentRate;
    }

    public double convert(Money outputType, double amount){
        return (amount / this.currentRate) * outputType.currentRate;
    }
}