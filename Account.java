public class Account<E> {
    Queue<E> shares;

    public Account() {
        shares = new ArrayQueue<E>();
    }

    public void buyShares(int numShares, E price) {
        for (int i = 0; i < numShares; i++) {
            shares.enqueue(price);
        }
    }

    public double sellShares(int numShares, double price) {
        double currentTotalAmount = numShares * price;
        double previousTotalAmount = 0;
        for (int i = 0; i < numShares; i++) {
            E prevPrice = shares.dequeue();
            previousTotalAmount += (double) prevPrice;
        }
        return previousTotalAmount - currentTotalAmount;
    }

    public double getTotalValue() {
        Queue<E> temp = new ArrayQueue<E>();
        double totalPrices = 0;
        while (!shares.isEmpty()) {
            E price = shares.dequeue();
            totalPrices += (double) price;
            temp.enqueue(price);
        }
        shares = temp;
        return totalPrices;
    }

    public int getTotalShares() {
        return shares.size();
    }

    public String toString() {
        return "Total shares: " + getTotalShares() + "\nTotal value: $" + getTotalValue() + "\n";
    }

}
