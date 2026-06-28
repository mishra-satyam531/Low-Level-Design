package vendingMachine.state;

import vendingMachine.models.Slot;
import vendingMachine.models.VendingMachine;

public class MoneyInsertedState implements VendingMachineState {

    @Override
    public void insertMoney(VendingMachine machine, int amount) {
        machine.acceptMoney(amount);

        System.out.println("Rs " + amount + " inserted.");
    }

    @Override
    public void selectProduct(VendingMachine machine, String slotId) {
        Slot selectedSlot = machine.findSlot(slotId);
        
        if(selectedSlot == null) {

            System.out.println("Invalid Slot.");

            return;
        }

        if(selectedSlot.isEmpty()) {

            System.out.println(
                    "Product Out of Stock.");

            return;
        }

        if(machine.getInsertedMoney() < selectedSlot.getProduct().getPrice()) {

            System.out.println("Insufficient Money.");
            return;
        }

        machine.selectSlot(selectedSlot);

        machine.changeState(new ProductSelectedState());

        System.out.println("Product Selected.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("Select a product first.");
    }

    @Override
    public void cancelTransaction(VendingMachine machine) {
        machine.cancelCurrentTransaction();
    }

}