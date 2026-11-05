package lifelink;

import lifelink.model.Donor;
import lifelink.model.BloodStock;
import lifelink.model.BloodRequest;

import lifelink.service.DonorService;
import lifelink.service.BloodStockService;
import lifelink.service.BloodMatchingService;
import lifelink.service.ShortageReportService;
import lifelink.service.BloodRequestService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create service objects
        DonorService donorService = new DonorService();

        BloodStockService stockService = new BloodStockService();

        BloodMatchingService matchingService =
                new BloodMatchingService(stockService);

        ShortageReportService shortageService =
                new ShortageReportService(stockService);

        BloodRequestService requestService =
                new BloodRequestService(stockService);

        int choice;

        do {

            System.out.println("\n========================================");
            System.out.println("               LIFELINK");
            System.out.println("    Blood Inventory and Donor Matching");
            System.out.println("========================================");

            System.out.println("1. Register Donor");
            System.out.println("2. View Donors");
            System.out.println("3. Add Blood Stock");
            System.out.println("4. View Blood Stock");
            System.out.println("5. Search Compatible Blood");
            System.out.println("6. Find Eligible Donors");
            System.out.println("7. Generate Shortage Report");
            System.out.println("8. Expire Old Blood Units");
            System.out.println("9. Issue Blood to Hospital");
            System.out.println("10. View Hospital Requests");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Donor ID: ");
                    String donorId = sc.nextLine();

                    System.out.print("Enter Donor Name: ");
                    String donorName = sc.nextLine();

                    System.out.print("Enter Blood Group: ");
                    String donorGroup = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Last Donation Date (YYYY-MM-DD): ");
                    LocalDate donationDate =
                            LocalDate.parse(sc.nextLine());

                    Donor donor = new Donor(
                            donorId,
                            donorName,
                            donorGroup,
                            phone,
                            donationDate
                    );

                    donorService.registerDonor(donor);

                    break;

                case 2:

                    List<Donor> donors = donorService.getAllDonors();

                    if (donors.isEmpty()) {
                        System.out.println("No donors registered!");
                    } else {
                        for (Donor d : donors) {
                            System.out.println("\n" + d);
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Stock ID: ");
                    String stockId = sc.nextLine();

                    System.out.print("Enter Blood Group: ");
                    String bloodGroup = sc.nextLine();

                    System.out.print("Enter Number of Units: ");
                    int units = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Collection Date (YYYY-MM-DD): ");
                    LocalDate collectionDate =
                            LocalDate.parse(sc.nextLine());

                    BloodStock stock = new BloodStock(
                            stockId,
                            bloodGroup,
                            units,
                            collectionDate
                    );

                    stockService.addStock(stock);

                    break;

                case 4:

                    List<BloodStock> stocks = stockService.getAllStock();

                    if (stocks.isEmpty()) {
                        System.out.println("No blood stock available!");
                    } else {
                        for (BloodStock s : stocks) {
                            System.out.println("\n" + s);
                        }
                    }

                    break;

                case 5:

                    System.out.print("Enter Recipient Blood Group: ");
                    String recipientGroup = sc.nextLine();

                    matchingService.displayMatchingStock(recipientGroup);

                    break;

                case 6:

                    List<Donor> eligible =
                            donorService.getEligibleDonors();

                    if (eligible.isEmpty()) {
                        System.out.println("No eligible donors found!");
                    } else {
                        System.out.println("\n===== ELIGIBLE DONORS =====");

                        for (Donor d : eligible) {
                            System.out.println("\n" + d);
                        }
                    }

                    break;

                case 7:

                    System.out.print("Enter Minimum Stock Level: ");
                    int minimumLevel = sc.nextInt();
                    sc.nextLine();

                    shortageService.generateShortageReport(minimumLevel);

                    break;

                case 8:

                    stockService.removeExpiredStock();

                    System.out.println("Blood expiry check completed!");

                    break;

                case 9:

                    System.out.print("Enter Request ID: ");
                    String requestId = sc.nextLine();

                    System.out.print("Enter Hospital Name: ");
                    String hospitalName = sc.nextLine();

                    System.out.print("Enter Required Blood Group: ");
                    String requiredGroup = sc.nextLine();

                    System.out.print("Enter Required Units: ");
                    int requiredUnits = sc.nextInt();
                    sc.nextLine();

                    if (requiredUnits <= 0) {
                        System.out.println("Invalid number of units!");
                        break;
                    }

                    BloodRequest request = new BloodRequest(
                            requestId,
                            hospitalName,
                            requiredGroup,
                            requiredUnits,
                            LocalDate.now()
                    );

                    requestService.addRequest(request);

                    requestService.fulfillRequest(request);

                    break;

                case 10:

                    List<BloodRequest> requests =
                            requestService.getAllRequests();

                    if (requests.isEmpty()) {
                        System.out.println("No hospital requests found!");
                    } else {
                        System.out.println("\n===== HOSPITAL REQUESTS =====");

                        for (BloodRequest r : requests) {
                            System.out.println("\n" + r);
                        }
                    }

                    break;

                case 0:

                    System.out.println("\nThank you for using LifeLink!");
                    break;

                default:

                    System.out.println("Invalid choice! Please try again.");

            }

        } while (choice != 0);

        sc.close();
    }
}