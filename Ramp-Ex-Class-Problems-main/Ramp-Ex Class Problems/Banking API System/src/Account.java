public abstract class Account {
    long accNum;
    long passwd;
    long balance;

    public Account(long accNum, long passwd) {
        this.accNum = accNum;
        this.passwd = passwd;
        this.balance = 0;
    }

    abstract void deposit(long amt);
    abstract void checkBalance();
    abstract void withdraw(long amt);
}
