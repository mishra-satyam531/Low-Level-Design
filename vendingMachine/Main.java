package vendingMachine;

import java.util.ArrayList;
import java.util.List;

import vendingMachine.models.Product;
import vendingMachine.models.Slot;
import vendingMachine.models.VendingMachine;
import vendingMachine.state.IdleState;

public class Main {
    public static void main(String[] args) {
        Product coke = new Product("P1", "Coke", 40);

        Product pepsi = new Product("P2", "Pepsi",  50);

        Product chips = new Product("P3", "Lays", 30);

        List<Slot> slots = new ArrayList<>();

        slots.add(new Slot("A1", coke, 5));

        slots.add(new Slot("A2", pepsi, 3));

        slots.add(new Slot("A3", chips, 10));

        VendingMachine machine = new VendingMachine("VM001", slots, new IdleState());

        machine.insertMoney(20);

        machine.insertMoney(20);

        machine.selectProduct("A1");

        machine.dispenseProduct();
    }

}