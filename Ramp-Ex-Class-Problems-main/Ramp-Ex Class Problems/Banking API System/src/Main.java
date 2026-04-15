public class Main {
    public static void main(String[] args) {
        Bank sbi = new Bank("SBI");

        User u1 = new User("San",74489);
        sbi.createAcc(u1, "Savings", 1122, 123);
        sbi.deposit(74489, 1122, 5000);

        User u2 = new User("Abhi", 55555);
        sbi.createAcc(u2, "Savings", 100, 123);

        sbi.transfer(74489, 55555, 1122, 100, 123, 1000);
    }
}
