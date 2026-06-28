package vendingMachine.models;

public class Slot {

    private String slotId;

    private Product product;

    private int quantity;

    public Slot(String slotId, Product product, int quantity) {
        this.slotId = slotId;
        this.product = product;
        this.quantity = quantity;
    }

    public String getSlotId() {
        return slotId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isEmpty() {
        return quantity == 0;
    }

    public void dispenseProduct() {

        if(quantity > 0) {
            quantity--;
        }
    }
}