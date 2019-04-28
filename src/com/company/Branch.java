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
public class Branch {
    private ArrayList<Customer> customer;
    private String branchName;

    public Branch(String branchName){
        this.customer = new ArrayList<>();
        this.branchName = branchName;
    }

    public boolean addCustomer(String name, double amount){
        boolean exist = queryCustomer(name);
        if(!exist){
            Customer customer = Customer.createCustomer(name, amount);
            this.customer.add(customer);
            return true;
        }
        System.out.println("This customer already exists, adding customer failed.");
        return false;

    }

    public void printAllCustomerTransactions(String name){
        Customer customer = findCustomer(name);
        if(customer != null){
            System.out.println("Transactions for " + name + " at " + getBranchName() + ":");
            customer.printAllTransactions(customer);
        } else {
            System.out.println("Customer does not exist");
        }
    }

    public void withdraw(String name, double amount){
        Customer customer = findCustomer(name);
        if(customer != null){
            if(customer.withdraw(amount)){
                System.out.println("Withdraw success!");
                //return true;
            } else {
                System.out.println("Error: Withdraw failed.");
                //return false;
            }
        } else {
            System.out.println("Error: Customer not found");
            //return false;
        }
    }

    public void deposit(String name, double amount){
        Customer customer = findCustomer(name);
        if(customer != null){
            if(customer.deposit(amount)){
                System.out.println("Deposit success!");
                //return true;
            } else {
                System.out.println("Error: Deposit failed.");
                //return false;
            }
        } else {
            System.out.println("Error: Customer not found");
            //return false;
        }
    }

    public void checkCurrentBalance(String name){
        Customer customer = findCustomer(name);
        if(customer != null){
            customer.checkCurrentBalance();
        } else {
            System.out.println("Error: Customer not found");
        }
    }

    private Customer findCustomer(String name){
        for(int i = 0; i < this.customer.size(); i++){
            Customer customer = this.customer.get(i);
            if(customer.getName().equals(name)){
                return customer;
            }
        }
        return null;
    }

    private boolean queryCustomer(String name){
        Customer customer = findCustomer(name);
        if(customer != null){
            return true;
        }
        return false;
    }

    public String getBranchName() {
        return branchName;
    }

    public static Branch createBranch(String branchName){
        return new Branch(branchName);
    }

    public void printAllCustomers(){
        for(int i = 0; i < this.customer.size(); i++){
            System.out.println((i + 1) + ". -> " + customer.get(i).getName());
        }
    }
}
