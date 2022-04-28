package ru.netology;

public class Main {
    public static void main(String[] args) {
        Account account1 = new CheckingAccount(1000);
        Account account2 = new SavingsAccount(3000);
        Account account3 = new CreditAccount(-2000);
        Account account4 = new CreditAccount(-500);
        account3.transfer(account4, 500);
        account4.transfer(account3,2400);
        account1.transfer(account2, 1100);
        account1.transfer(account4, 999);
        account1.pay(500);
        account4.addMoney(1500);
    }
}
