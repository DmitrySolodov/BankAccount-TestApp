package ru.netology;

public class CheckingAccount extends Account {
    protected CheckingAccount(int count) {
        super(count);
    }

    @Override
    public boolean pay(int amount) {
        if ((count - amount) < 0) {
            System.out.println("Невозможно выполнить операцию, баланс не может быть меньше 0");
            return false;
        } else {
            return super.pay(amount);
        }
    }

    @Override
    public boolean transfer(Account account, int amount) {
        if ((count - amount) >= 0 && account.addMoney(amount)) {
            count -= amount;
            System.out.println("Выполнен перевод на сумму: " + amount + ", баланс счета отправителя составляет " + count + " рублей");
            return true;
        } else {
            if ((count - amount) < 0) {
                System.out.println("Недостаточно средств на счету отправителя");
            }
            return false;
        }
    }
}
