package com.learnJava.streams.introStreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Trader{
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
class Transaction
{
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
public class Practice {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. Find all transactions in the year 2011 and sort them by value (small to high).

        List<Transaction> tran2011=transactions.stream()
                .filter(transaction -> transaction.getYear()==2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(tran2011);


        //  2.  What are all the unique cities where the traders work?
        List<String> uniqueCities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct().collect(Collectors.toList());
        System.out.println(uniqueCities);


        //3. Find all traders from Cambridge and sort them by name.

        List<Trader> tradersCambridge=transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(tradersCambridge);

        //4. Return a string of all traders’ names sorted alphabetically.

        String allTradersSorted=transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(s1,s2)->s1+s2);
        System.out.println(allTradersSorted);

        String allTradersSorted2=transactions
                .stream()
                        .map(transaction -> transaction.getTrader().getName())
                                .distinct()
                                        .sorted()
                                                .collect(Collectors.joining());
        System.out.println(allTradersSorted2);

        //5. Are any traders based in Milan?

        boolean isMilanPresent=transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(isMilanPresent);

        //6. Print all transactions’ values from the traders living in Cambridge.
        transactions
                .stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);






        // 7. What’s the highest value of all the transactions?
        transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max).ifPresent(System.out::println);


        //8. Find the transaction with the smallest value.

        transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::min).ifPresent(System.out::println);




    }
}
