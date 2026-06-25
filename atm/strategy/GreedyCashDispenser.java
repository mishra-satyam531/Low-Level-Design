package atm.strategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GreedyCashDispenser implements CashDispenser {

    @Override
    public Map<Integer, Integer> dispenseCash(int amount, Map<Integer, Integer> inventory) {

        int remainingAmount = amount;

        Map<Integer, Integer> dispensedNotes = new HashMap<>();

        TreeMap<Integer, Integer> sortedInventory = new TreeMap<>(Collections.reverseOrder());

        sortedInventory.putAll(inventory);

        for(Integer denomination : sortedInventory.keySet()) {

            int availableNotes = sortedInventory.get(denomination);

            int requiredNotes = remainingAmount / denomination;

            int notesToUse = Math.min(requiredNotes, availableNotes);

            if(notesToUse > 0) {

                dispensedNotes.put(denomination, notesToUse);

                remainingAmount -= denomination * notesToUse;
            }
        }

        if(remainingAmount != 0) {
            return null;
        }

        for(Integer denomination : dispensedNotes.keySet()) {
            inventory.put(denomination, inventory.get(denomination) - dispensedNotes.get(denomination));
        }

        return dispensedNotes;
    }
}