package vendingMachine.state;

import vendingMachine.models.Slot;
import vendingMachine.models.VendingMachine;

public class ProductSelectedState implements VendingMachineState {

    @Override
    public void insertMoney(VendingMachine machine, int amount) {
        System.out.println("Product already selected.");
    }

    @Override
    public void selectProduct(VendingMachine machine, String slotId) {
        System.out.println("Product already selected.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        Slot slot = machine.getSelectedSlot();

        slot.dispenseProduct();

        int change = machine.getInsertedMoney() - slot.getProduct().getPrice();

        System.out.println("Dispensing " + slot.getProduct().getName());

        if(change > 0) {
            System.out.println("Returning Change : Rs " + change);
        }

        machine.endTransaction();
    }

    @Override
    public void cancelTransaction(VendingMachine machine) {
        machine.cancelCurrentTransaction();
    }
    
}