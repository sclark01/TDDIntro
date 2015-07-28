package com.thoughtworks.tddintro.accountbalance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTests {

    private Account account;

    private void createAccount(int startingBalance){
        account = new Account(startingBalance);
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        createAccount(100);
        account.deposit(50);
        assertEquals(150, account.checkBalance());
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        createAccount(100);
        account.withdraw(50);
        assertEquals(50, account.checkBalance());
    }

    @Test(expected = Account.InsufficientBalance.class)
    public void shouldThrowInsufficientBalanceExceptionWhenWithdrawingMoreMoneyThanIsInTheAccount(){
        createAccount(50);
        account.withdraw(100);
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        createAccount(50);
        try {
            account.withdraw(100);
        } catch (Account.InsufficientBalance e) {
            assertEquals(50, account.checkBalance());
        }
    }

}
