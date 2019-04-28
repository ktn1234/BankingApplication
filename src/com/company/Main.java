package com.company;

import java.util.Scanner;

// You job is to create a simple banking application.
// There should be a Bank class
// It should have an arraylist of Branches
// Each Branch should have an arraylist of Customers
// The Customer class should have an arraylist of Doubles (transactions)

// Customer:
// Name, and the ArrayList of doubles.

// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch

// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
// Demonstration autoboxing and unboxing in your code

// Hint: Transactions
// Add data validation.
// e.g. check if exists, or does not exist, etc.
// Think about where you are adding the code to perform certain actions
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	    Bank bank = new Bank();

        System.out.println("Welcome to the " + bank.getBankName() + "!");
        System.out.println("Please create a branch name to add to Global bank to get started:\n");
        String branch = scanner.nextLine();
        while (branch == null || branch.length() == 0) {
            System.out.print("Branch name cannot be empty. Please enter a valid branch name:\n\n");
            branch = scanner.nextLine();
        }
        bank.addNewBranch(branch);
        printInstructions();
        String branchName;
        String customerName;
        double amount;
	    boolean running = true;
	    while(running) {
            System.out.println("Please enter a choice:\n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    printInstructions();
                    break;
                case "2":
                    System.out.println("Function: Adding a branch to global bank -> ");
                    System.out.println("Enter a branch name you would like to add: \n");
                    branchName = scanner.nextLine();
                    addBranch(bank, branchName);
                    break;
                case "3":
                    System.out.println("Function: Add customer to existing branch -> ");
                    System.out.println("Enter an existing branch:\n");
                    branchName = scanner.nextLine();
                    System.out.println("Enter the customer name: \n");
                    customerName = scanner.nextLine();
                    System.out.println("Enter a initial deposit: \n");
                    amount = scanner.nextDouble();
                    addCustomerToExistingBranch(bank, branchName, customerName, amount);
                    scanner.nextLine();
                    break;
                case "4":
                    System.out.println("Function: Check current balance for a customer at a branch -> ");
                    System.out.println("Please enter an existing branch: \n");
                    branchName = scanner.nextLine();
                    System.out.println("Please enter the customer name: \n");
                    customerName = scanner.nextLine();
                    checkCurrentBalanceForBranchAndCustomer(bank, branchName, customerName);
                    break;
                case "5":
                    System.out.println("Function: Deposit $ to a customer account at a branch -> ");
                    System.out.println("Please enter an existing branch: \n");
                    branchName = scanner.nextLine();
                    System.out.println("Please enter the customer name: \n");
                    customerName = scanner.nextLine();
                    System.out.println("Enter an amount you would like to deposit: \n");
                    amount = scanner.nextDouble();
                    deposit(bank, branchName, customerName, amount);
                    scanner.nextLine();
                    break;
                case "6":
                    System.out.println("Function: Withdraw $ in a customer account at a branch -> ");
                    System.out.println("Please enter an existing branch: \n");
                    branchName = scanner.nextLine();
                    System.out.println("Please enter the customer name: \n");
                    customerName = scanner.nextLine();
                    System.out.println("Enter an amount you would like to withdraw: \n");
                    amount = scanner.nextDouble();
                    withdraw(bank, branchName, customerName, amount);
                    scanner.nextLine();
                    break;
                case "7":
                    System.out.println("Function: Show customer transactions at a branch -> ");
                    System.out.println("Please enter an existing branch: \n");
                    branchName = scanner.nextLine();
                    System.out.println("Please enter the customer name: \n");
                    customerName = scanner.nextLine();
                    printAllBranchCustomerTransactions(bank, branchName, customerName);
                    break;
                case "8":
                    System.out.println("Function: Show branches of Global Bank -> ");
                    printBankBranches(bank);
                    break;
                case "9":
                    System.out.println("Function: Show customers at a branch -> ");
                    System.out.println("Please enter an existing branch:");
                    branchName = scanner.nextLine();
                    printAllBranchCustomers(bank, branchName);
                    break;
                case "10":
                    running = false;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Error: Invalid value. Please try again");
                    break;
            }
        }
	    scanner.close();
    }

    public static void printInstructions(){
        System.out.println("1: Print Instructions");
        System.out.println("2. Add a branch");
        System.out.println("3. Add Customer to existing branch");
        System.out.println("4. Check current balance for a customer at a branch");
        System.out.println("5. Deposit an amount of $ to a customer account at a branch");
        System.out.println("6. Withdraw an amount of $ to a customer account at a branch");
        System.out.println("7. Show list of transactions for a customer at a branch");
        System.out.println("8. Show list of all branches");
        System.out.println("9. Show list of customers at a particular branch");
        System.out.println("10. Exit the program");
    }

    public static void addBranch(Bank bank, String branchName){
        bank.addNewBranch(branchName);
    }

    public static void addCustomerToExistingBranch(Bank bank, String branchName, String customerName, double amount){
        bank.addCustomerToExistingBranch(branchName, customerName, amount);
    }

    public static void deposit(Bank bank, String branchName, String customerName, double amount){
        bank.deposit(branchName, customerName, amount);
    }

    public static void withdraw(Bank bank, String branchName, String customerName, double amount){
        bank.withdraw(branchName, customerName, amount);
    }

    public static void checkCurrentBalanceForBranchAndCustomer(Bank bank, String branchName, String customerName){
        bank.checkCurrentBalance(branchName, customerName);
    }

    public static void printAllBranchCustomerTransactions(Bank bank, String branchName, String customerName){
        bank.printAllBranchCustomerTransactions(branchName, customerName);
    }

    public static void printBankBranches(Bank bank){
        bank.printAllBranches();
    }

    public static void printAllBranchCustomers(Bank bank, String branchName){
        bank.printAllBranchCustomers(branchName);
    }

}
