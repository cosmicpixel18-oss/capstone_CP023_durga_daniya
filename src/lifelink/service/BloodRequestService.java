package lifelink.service;

import lifelink.model.BloodRequest;

import java.util.ArrayList;
import java.util.List;

public class BloodRequestService {

    private final List<BloodRequest> requestList = new ArrayList<>();

    private final BloodStockService stockService;

    // Constructor
    public BloodRequestService(BloodStockService stockService) {
        this.stockService = stockService;
    }

    // Register hospital blood request
    public void addRequest(BloodRequest request) {

        if (request.getRequiredUnits() <= 0) {
            System.out.println("Invalid number of units!");
            return;
        }

        requestList.add(request);

        System.out.println("Blood request registered successfully!");
    }

    // View all hospital requests
    public List<BloodRequest> getAllRequests() {

        return new ArrayList<>(requestList);
    }

    // Fulfil hospital blood request
    public boolean fulfillRequest(BloodRequest request) {

        boolean issued = stockService.issueStock(
                request.getRecipientBloodGroup(),
                request.getRequiredUnits()
        );

        if (issued) {

            System.out.println("Blood issued successfully!");
            System.out.println("Hospital: " + request.getHospitalName());
            System.out.println("Blood Group: " + request.getRecipientBloodGroup());
            System.out.println("Units Issued: " + request.getRequiredUnits());

            return true;
        }

        System.out.println("Insufficient blood stock!");
        System.out.println("Request could not be fulfilled.");

        return false;
    }
}