package lifelink.service;

import java.util.Arrays;
import java.util.List;

public class ShortageReportService {

    private final BloodStockService stockService;

    private static final List<String> BLOOD_GROUPS =
            Arrays.asList(
                    "A+", "A-", "B+", "B-",
                    "AB+", "AB-", "O+", "O-"
            );

    public ShortageReportService(BloodStockService stockService) {
        this.stockService = stockService;
    }

    // Generate blood shortage report
    public void generateShortageReport(int minimumLevel) {

        System.out.println("\n========== BLOOD SHORTAGE REPORT ==========");

        System.out.println("Minimum Required Units: " + minimumLevel);

        boolean shortageFound = false;

        for (String group : BLOOD_GROUPS) {

            int availableUnits = stockService.getTotalUnits(group);

            if (availableUnits < minimumLevel) {

                System.out.println(
                        "Blood Group: " + group +
                                " | Available: " + availableUnits +
                                " | Shortage: " + (minimumLevel - availableUnits)
                );

                shortageFound = true;
            }
        }

        if (!shortageFound) {
            System.out.println("No blood shortages found!");
        }

        System.out.println("===========================================");
    }
}