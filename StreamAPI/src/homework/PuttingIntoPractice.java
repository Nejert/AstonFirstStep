package homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).");
        transactions.stream()
                .filter(a -> a.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("2. Вывести список неповторяющихся городов, в которых работают трейдеры.");
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(a -> a.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.");
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .forEach(a -> System.out.print(a + " "));
        System.out.println("\n");

        System.out.println("5. Выяснить, существует ли хоть один трейдер из Милана.");
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(a -> a.getCity().equals("Milan")) + "\n");

        System.out.println("6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        transactions.stream()
                .filter(a -> a.getTrader().getCity().equals("Cambridge"))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("7. Какова максимальная сумма среди всех транзакций?");
        System.out.println(transactions.stream()
                .max(Comparator.comparing(Transaction::getValue)) + "\n");

        System.out.println("8. Найти транзакцию с минимальной суммой.");
        System.out.println(transactions.stream()
                .min(Comparator.comparing(Transaction::getValue)));
    }
}
