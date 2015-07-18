package com.thoughtworks.tddintro.accountbalance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTests {

    private Account account;

    private void createAccount(int amount){
        account = new Account(amount);
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        createAccount(100);
        account.deposit(50);
        assertEquals(150, account.checkBalance());
    }

//    @Test
//    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
//
//    }
//
//    @Test
//    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
//
//    }
}
