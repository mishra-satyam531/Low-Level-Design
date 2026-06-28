package vendingMachine.state;

import vendingMachine.models.VendingMachine;

public interface VendingMachineState {

    void insertMoney(VendingMachine machine, int amount);

    void selectProduct(VendingMachine machine, String slotId);

    void dispenseProduct(VendingMachine machine);

    void cancelTransaction(VendingMachine machine);
}