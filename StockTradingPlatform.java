import java.util.Scanner;

// Simple OOP class to represent a Stock
class Stock {
    String ticker;
    double price;

    public Stock(String ticker, double price) {
        this.ticker = ticker;
        this.price = price;
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 10000.00;

        // Simple arrays instead of complex maps
        Stock[] market = {
                new Stock("AAPL", 175.50),
                new Stock("GOOGL", 150.25),
                new Stock("TSLA", 220.10)
        };
        int[] myPortfolio = {0, 0, 0}; // Tracks shares bought for AAPL, GOOGL, TSLA

        while (true) {
            System.out.println("\n===== Stock Trading Platform =====");
            System.out.println("1. View Market Prices");
            System.out.println("2. Buy Stock");
            System.out.println("3. View Portfolio & Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            if (choice == 4) break;

            if (choice == 1) {
                System.out.println("\n--- Live Market Data ---");
                for (int i = 0; i < market.length; i++) {
                    System.out.println(market[i].ticker + ": $" + market[i].price);
                }
            }
            else if (choice == 2) {
                System.out.println("Select stock to buy (0 for AAPL, 1 for GOOGL, 2 for TSLA): ");
                int index = sc.nextInt();
                if (index < 0 || index >= market.length) {
                    System.out.println("Invalid selection.");
                    continue;
                }
                System.out.print("Enter quantity to buy: ");
                int qty = sc.nextInt();
                double cost = market[index].price * qty;

                if (cost > balance) {
                    System.out.println("Insufficient funds!");
                } else {
                    balance -= cost;
                    myPortfolio[index] += qty;
                    System.out.println("Successfully bought " + qty + " shares of " + market[index].ticker);
                }
            }
            else if (choice == 3) {
                System.out.println("\n--- Your Status ---");
                System.out.println("Cash Balance: $" + balance);
                for (int i = 0; i < market.length; i++) {
                    System.out.println(market[i].ticker + " owned: " + myPortfolio[i] + " shares");
                }
            }
        }
        System.out.println("=========================");
        System.out.println("Status: Completed");
        sc.close();
    }
}
