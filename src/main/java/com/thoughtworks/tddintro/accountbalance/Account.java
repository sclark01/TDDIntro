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
           throw new InsufficientBalance("Withdrawal amount greater than available funds.");
        }
        balance -= withdrawalAmount;
    }
    protected class InsufficientBalance extends RuntimeException{
        public InsufficientBalance(){}
        public InsufficientBalance(String message){
            super(message);
        }
        public InsufficientBalance(Throwable cause){
            super(cause);
        }
        public InsufficientBalance(String message, Throwable cause){
            super(message, cause);
        }
    }
}
