package com.christodd;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Contacts contacts = new Contacts();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    contacts.printContactList();
                    break;
                case 2:
                    addNameAndNumber();
                    break;
                case 3:
                    modifyNameOrNumber();
                    break;
                case 4:
                    removeName();
                    break;
                case 5:
                    searchNameOrNumber();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    //print Instructions
    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the contact list of names and numbers.");
        System.out.println("\t 2 - To add a new name and number.");
        System.out.println("\t 3 - To modify a name or number.");
        System.out.println("\t 4 - To remove a name from your contacts.");
        System.out.println("\t 5 - To search for a name or number.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addNameAndNumber() {
        System.out.print("Enter a name to be added:");
        String name = scanner.nextLine();
        System.out.print("Enter the number for this name:");
        int number = scanner.nextInt();
        contacts.addNameNumber(name,number);
    }

    public static void modifyNameOrNumber() {
        System.out.print("Choose contact name to modify: ");
        String name = scanner.nextLine();
        System.out.print("To modify name, press 1. To modify number, press 2: ");
        int answer = scanner.nextInt();
        scanner.nextLine();
        if(answer == 1) {
            System.out.print("Enter the new name: ");
            String newName = scanner.nextLine();
            contacts.modifyName(name, newName);
        } else {
            System.out.print("Enter the new number: ");
            int newNumber = scanner.nextInt();
            contacts.modifyNumber(contacts.getNumberOfName(name), newNumber);
        }
    }

    public static void removeName() {
        System.out.print("What contact would you like to remove: ");
        String name = scanner.nextLine();
        contacts.removeByName(name);
    }

    public static void searchNameOrNumber() {
        System.out.print("Search for name, press 1. Search for number, press 2: ");
        int answer = scanner.nextInt();
        scanner.nextLine();
        if(answer == 1) {
            System.out.print("Enter name to search for: ");
            if(contacts.findNameFound(scanner.nextLine())) {
                System.out.println("Found");
            } else {
                System.out.println("Not Found");
            }
        } else {
            System.out.println("Enter number to search for: ");
            if(contacts.findNumberFound(scanner.nextInt())) {
                System.out.println("Found");
            } else {
                System.out.println("Not Found");
            }
        }
    }

}
