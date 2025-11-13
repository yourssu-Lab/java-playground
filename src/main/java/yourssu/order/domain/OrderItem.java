package yourssu.order.domain;

public class OrderItem {
    private final String name;
    private final int price;
    private final int count;

    public OrderItem(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
