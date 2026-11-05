 package lifelink.model;

import java.time.LocalDate;

public class BloodStock {

    private String stockId;
    private String bloodGroup;
    private int units;
    private LocalDate collectionDate;

    // Constructor
    public BloodStock(String stockId, String bloodGroup,
                      int units, LocalDate collectionDate) {

        this.stockId = stockId;
        this.bloodGroup = bloodGroup;
        this.units = units;
        this.collectionDate = collectionDate;
    }

    // Getters
    public String getStockId() {
        return stockId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public int getUnits() {
        return units;
    }

    public LocalDate getCollectionDate() {
        return collectionDate;
    }

    // Setter
    public void setUnits(int units) {
        this.units = units;
    }

    // Display stock details
    @Override
    public String toString() {
        return "Stock ID: " + stockId +
                "\nBlood Group: " + bloodGroup +
                "\nUnits: " + units +
                "\nCollection Date: " + collectionDate;
    }
}


