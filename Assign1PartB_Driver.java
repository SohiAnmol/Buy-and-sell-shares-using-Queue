import java.util.Scanner;

public class Assign1PartB_Driver {
    public static void main(String[] args) {
        Account acc = new Account();
        Scanner kb = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Make a selection:");
            System.out.println("1. Buy Shares");
            System.out.println("2. Sell Shares");
            System.out.println("3. Quit");
            choice = kb.nextInt();
            if (choice == 1) {
                System.out.print("Enter number of shares to buy: ");
                int numShares = kb.nextInt();

                System.out.print("Enter purchase price per share: ");
                double price = kb.nextDouble();

                acc.buyShares(numShares, price);

                System.out.println();
                System.out.println(acc.toString());
                System.out.println("----------------------------------------");
                System.out.println();

            } else if (choice == 2) {
                System.out.print("Enter number of shares to sell: ");
                int numShares = kb.nextInt();
                System.out.print("Enter selling price per share: ");
                double price = kb.nextDouble();

                double totalGainLoss = acc.sellShares(numShares, price);

                if (totalGainLoss >= 0) {
                    System.out.println("Total gain: $" + totalGainLoss);
                } else {
                    System.out.println("Total loss: $" + Math.abs(totalGainLoss));
                }
                System.out.println();
                System.out.println(acc.toString());
                System.out.println("----------------------------------------");
                System.out.println();
            }
        } while (choice != 3);
        System.out.println("*** End of Program ***");
    }
}
