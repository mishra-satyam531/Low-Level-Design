package vendingMachine.models;

import java.util.List;

import vendingMachine.state.IdleState;
import vendingMachine.state.VendingMachineState;;;

public class VendingMachine {

    private String machineId;

    private List<Slot> slots;

    private Slot selectedSlot;

    private int insertedMoney;

    private VendingMachineState currentState;

    public VendingMachine(String machineId, List<Slot> slots, VendingMachineState initialState) {

        this.machineId = machineId;
        this.slots = slots;
        this.currentState = initialState;
    }

    // -------- Client APIs --------

    public void insertMoney(int amount) {
        currentState.insertMoney(this, amount);
    }

    public void selectProduct(String slotId) {
        currentState.selectProduct(this, slotId);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct(this);
    }

    public void cancelTransaction() {
       currentState.cancelTransaction(this);
    }

    // -------- Methods used by States --------

    public void changeState(VendingMachineState state) {
        this.currentState = state;
    }

    public void acceptMoney(int amount) {
        insertedMoney += amount;
    }

    public void returnInsertedMoney() {

        System.out.println("Refunded Rs " + insertedMoney);

        insertedMoney = 0;
    }

    public void resetTransaction() {

        insertedMoney = 0;

        selectedSlot = null;
    }

    public int getInsertedMoney() {
        return insertedMoney;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public Slot getSelectedSlot() {
        return selectedSlot;
    }

    public void selectSlot(Slot slot) {
        selectedSlot = slot;
    }

    public void endTransaction() {

        resetTransaction();

        changeState(new IdleState());
    }

    public void cancelCurrentTransaction() {

        returnInsertedMoney();

        endTransaction();
    }
}