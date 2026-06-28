package vendingMachine.state;

import vendingMachine.models.VendingMachine;

public class IdleState implements VendingMachineState {

    @Override
    public void insertMoney(VendingMachine machine, int amount) {
        machine.acceptMoney(amount);

        machine.changeState(new MoneyInsertedState());

        System.out.println("Rs " + amount + " inserted.");
    }

    @Override
    public void selectProduct(VendingMachine machine, String slotId) {
        System.out.println("Insert money first.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("Insert money first.");
    }

    @Override
    public void cancelTransaction(VendingMachine machine) {
        System.out.println("No transaction in progress.");
    }
    
}