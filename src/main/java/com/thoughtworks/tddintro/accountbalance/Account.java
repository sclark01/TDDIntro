package com.thoughtworks.tddintro.accountbalance;

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void deposit(int depositAmount) {
        balance += depositAmount;
    }

    public int checkBalance() {
        return balance;
    }

    public void withdraw(int withdrawalAmount){
        if(withdrawalAmount > balance){
           return;
        }
        balance -= withdrawalAmount;
    }
}
