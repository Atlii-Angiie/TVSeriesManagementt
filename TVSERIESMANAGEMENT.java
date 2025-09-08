

package com.mycompany.tvseriesmanagement;
import java.util.Scanner;

public class TVSERIESMANAGEMENT {

    public static void main(String[] args) {
        Series seriesApp = new Series();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\nLATEST SERIES - 2025");
            System.out.println("*********************************");
            System.out.print("Enter (1) to launch menu or any other key to exit: ");

            String launch = scanner.nextLine();
            if (!launch.equals("1")) {
                System.out.println("Exiting application...");
                break;
            }

            // Show the main menu
            System.out.println("Please select the following menu items");
            System.out.println("1. Capture a new series");
            System.out.println("2. Search for a series");
            System.out.println("3. Update a series");
            System.out.println("4. Delete a series");
            System.out.println("5. Series report");
            System.out.println("6. Exit application");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1": seriesApp.captureSeries(); break;
                case "2": seriesApp.searchSeries(); break;
                case "3": seriesApp.updateSeries(); break;
                case "4": seriesApp.deleteSeries(); break;
                case "5": seriesApp.seriesReport(); break;
                case "6": seriesApp.exitSeriesApplication(); break;
                default: System.out.println("Invalid choice! Try again."); break;
            }
        }
    }
}

