package vendingMachine.models;

public class Product {
    private String productId;

    private String name;

    private int price;

    public Product(String productId, String name, int price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}