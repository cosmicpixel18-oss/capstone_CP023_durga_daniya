package lifelink.service;

import lifelink.model.BloodStock;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BloodStockService {

    private final List<BloodStock> stockList = new ArrayList<>();

    // Add blood stock
    public void addStock(BloodStock stock) {

        removeExpiredStock();

        stockList.add(stock);

        System.out.println("Blood stock added successfully!");
    }

    // View all blood stock
    public List<BloodStock> getAllStock() {

        removeExpiredStock();

        return new ArrayList<>(stockList);
    }

    // Calculate total units of a particular blood group
    public int getTotalUnits(String bloodGroup) {

        removeExpiredStock();

        int total = 0;

        for (BloodStock stock : stockList) {

            if (stock.getBloodGroup().equalsIgnoreCase(bloodGroup)) {
                total += stock.getUnits();
            }
        }

        return total;
    }

    // Reduce blood stock after issuing units
    public boolean issueStock(String bloodGroup, int units) {

        removeExpiredStock();

        if (units <= 0 || getTotalUnits(bloodGroup) < units) {
            return false;
        }

        int remaining = units;

        for (BloodStock stock : stockList) {

            if (stock.getBloodGroup().equalsIgnoreCase(bloodGroup)) {

                int available = stock.getUnits();

                int issued = Math.min(available, remaining);

                stock.setUnits(available - issued);

                remaining -= issued;

                if (remaining == 0) {
                    break;
                }
            }
        }

        return true;
    }

    // Automatically remove blood older than 35 days
    public void removeExpiredStock() {

        LocalDate today = LocalDate.now();

        int removedCount = 0;

        for (int i = stockList.size() - 1; i >= 0; i--) {

            BloodStock stock = stockList.get(i);

            long daysOld = ChronoUnit.DAYS.between(
                    stock.getCollectionDate(), today
            );

            if (daysOld > 35) {

                stockList.remove(i);

                removedCount++;
            }
        }

        if (removedCount > 0) {

            System.out.println(
                    removedCount + " expired blood stock record(s) removed!"
            );
        }
    }
}