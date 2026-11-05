package lifelink.model;

import java.time.LocalDate;

public class Donor {

    private String donorId;
    private String donorName;
    private String bloodGroup;
    private String phoneNumber;
    private LocalDate lastDonationDate;

    // Constructor
    public Donor(String donorId, String donorName,
                 String bloodGroup, String phoneNumber,
                 LocalDate lastDonationDate) {

        this.donorId = donorId;
        this.donorName = donorName;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
        this.lastDonationDate = lastDonationDate;
    }

    // Getters
    public String getDonorId() {
        return donorId;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getLastDonationDate() {
        return lastDonationDate;
    }

    // Setters
    public void setLastDonationDate(LocalDate lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }

    // Display donor details
    @Override
    public String toString() {
        return "Donor ID: " + donorId +
                "\nName: " + donorName +
                "\nBlood Group: " + bloodGroup +
                "\nPhone: " + phoneNumber +
                "\nLast Donation: " + lastDonationDate;
    }
}