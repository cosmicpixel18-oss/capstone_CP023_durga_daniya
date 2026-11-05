package lifelink.service;

import lifelink.model.BloodStock;
import lifelink.util.BloodCompatibility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BloodMatchingService {

    private final BloodStockService stockService;

    public BloodMatchingService(BloodStockService stockService) {
        this.stockService = stockService;
    }

    // Find compatible blood groups with exact match first
    public List<String> findCompatibleBloodGroups(String recipientGroup) {

        List<String> compatibleGroups =
                new ArrayList<>(
                        BloodCompatibility.getCompatibleGroups(recipientGroup)
                );

        // Put exact blood group first
        compatibleGroups.sort(Comparator.comparing(
                group -> !group.equalsIgnoreCase(recipientGroup)
        ));

        return compatibleGroups;
    }

    // Find available compatible blood stock
    public void displayMatchingStock(String recipientGroup) {

        List<String> compatibleGroups =
                findCompatibleBloodGroups(recipientGroup);

        System.out.println("\n===== BLOOD MATCHING RESULTS =====");

        boolean found = false;

        for (String group : compatibleGroups) {

            int availableUnits = stockService.getTotalUnits(group);

            if (availableUnits > 0) {

                System.out.println(
                        "Blood Group: " + group +
                                " | Available Units: " + availableUnits
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No compatible blood stock available!");
        }
    }
}