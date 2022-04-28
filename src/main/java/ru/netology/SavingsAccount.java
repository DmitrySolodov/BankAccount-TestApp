package ru.netology;

public class SavingsAccount extends Account {
    protected SavingsAccount(int count) {
        super(count);
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("Операция не может быть выполнена, со сберегательного счета нельзя оплачивать");
        return false;
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
