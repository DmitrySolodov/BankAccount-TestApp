package ru.netology;

public abstract class Account {
    protected int count;
    protected Account(int count) {
        this.count = count;
    }

    public boolean pay(int amount) {
        System.out.println("Оплачено: " + amount + " рублей, баланс составляет " + (count -= amount) + " рублей");
        return true;
    }

    public boolean transfer(Account account, int amount) {
        if (account.addMoney(amount)) {
            count -= amount;
            System.out.println("Выполнен перевод на сумму: " + amount + ", баланс счета отправителя составляет " + count + " рублей");
            return true;
        } else {
            return false;
        }
    }

    public boolean addMoney(int amount) {
        System.out.println("Пополнение счета на сумму: " + amount + " рублей, баланс составляет " + (count += amount) + " рублей");
        return true;
    }
}