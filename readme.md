Problem Title: LifeLink: Blood Inventory and Donor Matching System

Problem ID: CP-023

Team Members

1. Name:B. Durgashree| USN: [Enter Your USN]
2. Name: DANIYA ALI | USN: [Enter USN]

How to Run the Program

Prerequisites:

- GCC compiler installed on your system.
- A terminal or command prompt.

Steps:

1. Clone or download this repository.

2. Open the project folder in your terminal.

3. Compile the program:

   gcc main.c -o main

4. Execute the program:

   ./main

   For Windows, use:

   main.exe

Features Implemented

- Register blood donors with their blood group, phone number, and last donation date.
- Maintain blood inventory by blood group and collection date.
- Find compatible blood groups available in stock, prioritizing an exact match.
- Identify donors eligible to donate based on the 90-day interval since their last donation.
- Generate blood shortage reports for groups below the minimum stock level.

Sample Run

Input:

Enter your choice: 1

Enter donor name: Rahul
Enter blood group: O+
Enter phone number: 9876543210
Enter last donation date (DD-MM-YYYY): 15-06-2026

Donor registered successfully!

Enter your choice: 6

Output:

===== LIFELINK: BLOOD INVENTORY AND DONOR MATCHING SYSTEM =====

1. Register Donor
2. Add Blood Stock
3. Find Compatible Blood
4. Check Eligible Donors
5. View Blood Shortage Report
6. Exit

Donor registered successfully!

Exiting LifeLink. Thank you!
