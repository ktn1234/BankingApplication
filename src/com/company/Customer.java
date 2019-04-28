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
public class Customer {
    private String name;
    private double amount;
    private ArrayList<Double> transactions;

    public Customer(String name, double amount) {
        if (name == null || name.length() == 0){
            System.out.println("Name cannot be null or be empty");
            System.out.println("Error: Customer cannot be created");
            return;
            //throw new IllegalArgumentException("Name cannot be null or be empty");
        }

        if (amount < 0) {
            System.out.println("Amount cannot be less than 0");
            System.out.println("Error: Customer cannot be created");
            return;
            //throw new IllegalArgumentException("Amount cannot be less than 0");
        }

        this.name = name;
        this.amount = amount;
        transactions = new ArrayList<>();
        transactions.add(this.amount);
    }

    public boolean withdraw(double amount){
        double currentAmount = transactions.get(transactions.size() - 1);
        if(amount > currentAmount){
            System.out.println("Unable to withdraw because amount is greater than current balance");
            System.out.println("Transaction declined");
            return false;
        }
        transactions.add(currentAmount - amount);
        System.out.println("Successfully withdrew $" + amount);
        checkCurrentBalance();
        return true;
    }

    public boolean deposit(double amount){
        if(amount < 0){
            System.out.println("You cannot deposit a negative amount of $");
            System.out.println("Transaction declined");
            return false;
        }
        double currentAmount = transactions.get(transactions.size() - 1);
        transactions.add(currentAmount + amount);
        System.out.println("Successfully deposited $" + amount);
        checkCurrentBalance();
        return true;
    }

    public void checkCurrentBalance(){
        double balance = transactions.get(transactions.size() - 1);
        System.out.println("Current balance is: $" + balance);
    }

    public String getName() {
        return name;
    }

    public void printAllTransactions(Customer customer){
        for(int i = 0; i < customer.transactions.size(); i++){

            if(i == 0) {
                System.out.println("Initial Deposit: $" + transactions.get(i));
                continue;
            }
            if(i != customer.transactions.size() - 1){
                if(customer.transactions.get(i - 1) > customer.transactions.get(i)) {
                    System.out.println("Withdrew: $" + (customer.transactions.get(i - 1) - customer.transactions.get(i)));
                    continue;
                }
                if(customer.transactions.get(i - 1) < customer.transactions.get(i)){
                    System.out.println("Deposited: $" + (customer.transactions.get(i) - customer.transactions.get(i - 1)));
                    continue;
                }
            }

            //we are at last index
            if(i == customer.transactions.size() - 1){
                if(customer.transactions.get(i - 1) > customer.transactions.get(i)) {
                    System.out.println("Withdrew: $" + (customer.transactions.get(i - 1) - customer.transactions.get(i)));
                    checkCurrentBalance();
                    continue;
                }
                if(customer.transactions.get(i - 1) < customer.transactions.get(i)){
                    System.out.println("Deposited: $" + (customer.transactions.get(i) - customer.transactions.get(i - 1)));
                    checkCurrentBalance();
                    continue;
                }
            }

        }
    }

    public static Customer createCustomer(String name, double amount){
        return new Customer(name, amount);
    }
}
