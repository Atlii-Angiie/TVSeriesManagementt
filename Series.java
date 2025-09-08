/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesmanagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Series {

    public ArrayList<TVSeries> seriesList;
    public Scanner scanner;

    public Series() {
        seriesList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // 1. Capture Series
    public void captureSeries() {
        while (true) {
            System.out.println("\nCAPTURE A NEW SERIES");
            System.out.println("*********************************");

            System.out.print("Enter series ID : ");
            int id = Integer.parseInt(scanner.nextLine());
            if (id == 0) return;

            boolean exists = seriesList.stream().anyMatch(s -> s.getId() == id);
            if (exists) {
                System.out.println("Series ID already exists. Try again.");
                continue;
            }

            System.out.print("Enter series name: ");
            String name = scanner.nextLine();

            int age = 0;
            while (true) {
                System.out.print("Enter age restriction (2-18): ");
                try {
                    age = Integer.parseInt(scanner.nextLine());
                    if (age >= 2 && age <= 18) break;
                    else System.out.println("Age must be between 2 and 18.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a number.");
                }
            }

            System.out.print("Enter number of episodes: ");
            int episodes = Integer.parseInt(scanner.nextLine());

            seriesList.add(new TVSeries(id, name, age, episodes));
            System.out.println("Series captured successfully!");

            System.out.print("Do you want to add another series? (Y/N): ");
            if (!scanner.nextLine().equalsIgnoreCase("Y")) break;
        }
    }

    // 2. Search Series
    public void searchSeries() {
        System.out.print("\nEnter series ID to search: ");
        int id = Integer.parseInt(scanner.nextLine());

        TVSeries series = seriesList.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        if (series != null) System.out.println(series);
        else System.out.println("Series with ID " + id + " not found.");
    }

    // 3. Update Series
    public void updateSeries() {
        while (true) {
            System.out.print("\nEnter series ID to update (0 to return): ");
            int id = Integer.parseInt(scanner.nextLine());
            if (id == 0) return;

            TVSeries series = seriesList.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
            if (series == null) {
                System.out.println("Series with ID " + id + " not found.");
                continue;
            }

            System.out.print("Enter new name (current: " + series.getName() + "): ");
            String name = scanner.nextLine();
            if (!name.isBlank()) series.setName(name);

            while (true) {
                System.out.print("Enter new age restriction (current: " + series.getAgeRestriction() + "): ");
                String input = scanner.nextLine();
                if (input.isBlank()) break;
                try {
                    int age = Integer.parseInt(input);
                    if (age >= 2 && age <= 18) {
                        series.setAgeRestriction(age);
                        break;
                    } else System.out.println("Age must be between 2 and 18.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Try again.");
                }
            }

            System.out.print("Enter new number of episodes (current: " + series.getEpisodes() + "): ");
            String epsInput = scanner.nextLine();
            if (!epsInput.isBlank()) series.setEpisodes(Integer.parseInt(epsInput));

            System.out.println("Series updated successfully!");

            System.out.print("Do you want to update another series? (Y/N): ");
            if (!scanner.nextLine().equalsIgnoreCase("Y")) break;
        }
    }

    // 4. Delete Series
    public void deleteSeries() {
        while (true) {
            System.out.print("\nEnter series ID to delete (0 to return): ");
            int id = Integer.parseInt(scanner.nextLine());
            if (id == 0) return;

            TVSeries series = seriesList.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
            if (series == null) {
                System.out.println("Series with ID " + id + " not found.");
                continue;
            }

            System.out.println("Are you sure you want to delete series " + id + " from the system? Yes (y) to delete:");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                seriesList.remove(series);
                System.out.println("Series deleted successfully.");
            } else {
                System.out.println("Deletion cancelled.");
            }

            System.out.print("Do you want to delete another series? (Y/N): ");
            if (!scanner.nextLine().equalsIgnoreCase("Y")) break;
        }
    }

    // 5. Series Report
    public void seriesReport() {
        System.out.println("\nSERIES REPORT - 2025");
        System.out.println("*********************************");

        if (seriesList.isEmpty()) System.out.println("No series available in the system.");
        else seriesList.forEach(System.out::println);

        System.out.println("*********************************\n");
    }

    // 6. Exit Application
    public void exitSeriesApplication() {
        System.out.println("Exiting application...");
        System.exit(0);
    }

    // Add this getter at the end of the class (or anywhere inside the class body)
    public ArrayList<TVSeries> getSeriesList() {
        return seriesList;
    }
}

