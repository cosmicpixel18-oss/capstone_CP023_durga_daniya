package lifelink.model;

import java.time.LocalDate;

public class BloodRequest {

    private String requestId;
    private String hospitalName;
    private String recipientBloodGroup;
    private int requiredUnits;
    private LocalDate requestDate;

    // Constructor
    public BloodRequest(String requestId, String hospitalName,
                        String recipientBloodGroup,
                        int requiredUnits, LocalDate requestDate) {

        this.requestId = requestId;
        this.hospitalName = hospitalName;
        this.recipientBloodGroup = recipientBloodGroup;
        this.requiredUnits = requiredUnits;
        this.requestDate = requestDate;
    }

    // Getters
    public String getRequestId() {
        return requestId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getRecipientBloodGroup() {
        return recipientBloodGroup;
    }

    public int getRequiredUnits() {
        return requiredUnits;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    // Display request details
    @Override
    public String toString() {
        return "Request ID: " + requestId +
                "\nHospital: " + hospitalName +
                "\nRequired Blood Group: " + recipientBloodGroup +
                "\nRequired Units: " + requiredUnits +
                "\nRequest Date: " + requestDate;
    }
}
