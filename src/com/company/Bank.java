package com.company;

import java.util.ArrayList;

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
public class Bank {
    private ArrayList<Branch> branch;
    private String bankName;

    public Bank() {
        this.branch = new ArrayList<Branch>();
        this.bankName = "Global Bank";
    }

    public void addNewBranch(String branchName) {
        if (branchName == null || branchName.length() == 0) {
            System.out.println("Error: Cannot create a branch with no branch name");
        }

        if (!queryBranch(branchName)) {
            Branch branch = Branch.createBranch(branchName);
            this.branch.add(branch);
            System.out.println("Branch: \"" + branchName + "\" was successfully created to " + bankName + "!!!");
        } else {
            System.out.println("Error: Branch \"" + branchName + "\" already exists. Failed to create a new branch");
        }
    }

    public void addCustomerToExistingBranch(String branchName, String name, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            branch.addCustomer(name, amount);
            System.out.println("Successfully added customer to " + branch.getBranchName() + " with initial deposit of $" + amount);
        } else {
            System.out.println("Error: Could not add customer to branch because branch does not exist");
        }
    }

    public void withdraw(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            branch.withdraw(customerName, amount);
        } else {
            System.out.println("Error: Branch does not exist. Failed to withdraw");
        }

    }

    public void deposit(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            branch.deposit(customerName, amount);
        } else {
            System.out.println("Error: Branch does not exist. Failed to deposit");
        }
    }

    public void printAllBranchCustomerTransactions(String branchName, String customerName) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            branch.printAllCustomerTransactions(customerName);
        } else {
            System.out.println("Error: Branch does not exist. Failed to print branch's customer transactions.");
        }
    }

    public void printAllBranches() {
        System.out.println("Branches for " + this.bankName + ":");
        for (int i = 0; i < this.branch.size(); i++) {
            System.out.println("Branch " + (i + 1) + " -> " + this.branch.get(i).getBranchName());
        }
    }

    public void printAllBranchCustomers(String branchName) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Branch: " + branchName + " -> Customers:");
            branch.printAllCustomers();
        } else {
            System.out.println("Error: Branch does not exist. Failed to print branch's customer");
        }
    }

    private Branch findBranch(String name) {
        for (int i = 0; i < this.branch.size(); i++) {
            Branch branch = this.branch.get(i);
            if (branch.getBranchName().equals(name)) {
                return branch;
            }
        }
        return null;
    }

    //Finds if a branch exists
    //If branch equals null, no Branch was found
    //If branch does not equal null, Branch was not found
    private boolean queryBranch(String name) {
        Branch branch = findBranch(name);
        if (branch != null) {
            return true;
        }
        return false;
    }

    public void checkCurrentBalance(String branchName, String customerName) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            branch.checkCurrentBalance(customerName);
        }
    }

    public String getBankName() {
        return bankName;
    }
}
