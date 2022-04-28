package ru.netology;

public class CreditAccount extends Account {
    protected CreditAccount(int count) {
        super(count);
    }

    @Override
    public boolean addMoney(int amount) {
        if ((count + amount) > 0) {
            System.out.println("Невозможно выполнить операцию, баланс не может быть положительным");
            return false;
        } else {
            return super.addMoney(amount);
        }
    }

}
