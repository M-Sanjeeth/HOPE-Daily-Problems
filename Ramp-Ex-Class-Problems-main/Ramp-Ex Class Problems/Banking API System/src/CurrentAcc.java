public class CurrentAcc extends Account{
    public CurrentAcc(long accNum, long passwd) {
        super(accNum, passwd);
    }

    void deposit(long amt){
        if(amt <= 0){
            System.out.println("Invalid deposit amount");
            return;
        }
        this.balance += amt;
    }
    void withdraw(long amt){
        if(balance < amt){
            System.out.println("Balance is lesser than withdraw Amount");
            System.out.println("Your Balance = " + this.balance);
        }else{
            this.balance -= amt;
            System.out.println("Withdrawn " + amt + " Successfully");
        }
    }
    void checkBalance(){
        System.out.println("Your Account Balance = " + this.balance);
    }

    // give rules
}
