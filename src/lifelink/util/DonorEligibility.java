package lifelink.util;

import lifelink.model.Donor;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DonorEligibility {

    private static final int WAITING_PERIOD = 90;

    // Check whether donor is eligible
    public static boolean isEligible(Donor donor) {

        LocalDate lastDonation = donor.getLastDonationDate();
        LocalDate today = LocalDate.now();

        if (lastDonation == null || lastDonation.isAfter(today)) {
            return false;
        }

        long daysPassed = ChronoUnit.DAYS.between(
                lastDonation, today
        );

        return daysPassed >= WAITING_PERIOD;
    }

    // Calculate remaining days before eligibility
    public static long daysUntilEligible(Donor donor) {

        LocalDate eligibleDate = donor.getLastDonationDate()
                .plusDays(WAITING_PERIOD);

        LocalDate today = LocalDate.now();

        if (!eligibleDate.isAfter(today)) {
            return 0;
        }

        return ChronoUnit.DAYS.between(today, eligibleDate);
    }
}