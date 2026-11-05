package lifelink.service;

import lifelink.model.Donor;
import lifelink.util.DonorEligibility;

import java.util.ArrayList;
import java.util.List;

public class DonorService {

    private final List<Donor> donors = new ArrayList<>();

    // Register a new donor
    public void registerDonor(Donor donor) {

        donors.add(donor);

        System.out.println("Donor registered successfully!");
    }

    // View all registered donors
    public List<Donor> getAllDonors() {

        return new ArrayList<>(donors);
    }

    // Find donor using donor ID
    public Donor findDonorById(String donorId) {

        for (Donor donor : donors) {

            if (donor.getDonorId().equalsIgnoreCase(donorId)) {
                return donor;
            }
        }

        return null;
    }

    // Find all eligible donors
    public List<Donor> getEligibleDonors() {

        List<Donor> eligibleDonors = new ArrayList<>();

        for (Donor donor : donors) {

            if (DonorEligibility.isEligible(donor)) {
                eligibleDonors.add(donor);
            }
        }

        return eligibleDonors;
    }
}