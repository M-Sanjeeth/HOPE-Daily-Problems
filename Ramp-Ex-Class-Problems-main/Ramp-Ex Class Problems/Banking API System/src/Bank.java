import java.util.*;
public class Bank {
    // create account
    // store Users, accounts
    public Bank(String bankName){
        System.out.println("Welcome to " + bankName);
    }

    // userList = Ley(user.phoneNum) -> Value(user)
    Map<Long, User> userList = new HashMap<>();

    void createAcc(User user, String type, long accNum, long passwd){
        Account acc;
        if(type.equals("Savings")){
            acc = new SavingsAcc(accNum, passwd);
            if(!userList.containsKey(user.phoneNum)){
                // adding User to UserList
                userList.put(user.phoneNum, user);
                // adding Account to User(accountList)
                user.accountList.put(accNum, acc);
                System.out.println("Savings Account created successfully");
            }
        }
        else if(type.equals("Current")){
            acc = new CurrentAcc(accNum, passwd);
            if(!userList.containsKey(user.phoneNum)){
                userList.put(user.phoneNum, user);
                user.accountList.put(accNum, acc);
                System.out.println("Current Account created successfully");
            }
        }
    }
    Account getAcc(long phoneNum, long accNum){
        if(!userList.containsKey(phoneNum)){
            System.out.println("User not found");
            return null;
        }
        User u = userList.get(phoneNum);

        if(!u.accountList.containsKey(accNum)){
            System.out.println("Account not found");
            return null;
        }
        Account acc = u.accountList.get(accNum);
        return acc;
    }
    void withdraw(long phoneNum, long accNum, long amt){
        Account acc = getAcc(phoneNum, accNum);
        if(acc == null)
            return;
        if(acc.balance < amt){
            System.out.println("Balance is lesser than withdraw Amount");
            System.out.println("Your Balance = " + acc.balance);
        }else{
            acc.balance -= amt;
            System.out.println("Withdrawn " + amt + " Successfully");
        }
    }
    void deposit(long phoneNum, long accNum, long amt)
    {
        Account acc = getAcc(phoneNum, accNum);
        if(acc == null) return;
        if(amt <= 0){
            System.out.println("Invalid deposit Amount");
        }
        acc.balance += amt;
        System.out.println(amt + " Deposited successfully");
    }
    void checkBalance(long phoneNum, long accNum){
        Account acc = getAcc(phoneNum, accNum);
        if(acc == null)
            return;
        System.out.println("Balance " + acc.balance);
    }

    void transfer(long senderPhoneNum, long receiverPhoneNum, long senderAccNum, long receiverAccNum,
                  long senderAccPasswd, long amt){
        Account senderAcc = getAcc(senderPhoneNum, senderAccNum);
        Account receiverAcc = getAcc(receiverPhoneNum, receiverAccNum);

        if(senderAcc == null || receiverAcc == null){
            System.out.println("Account does not Exist");
            return;
        }
        // password validation
        if(senderAcc.passwd != senderAccPasswd){
            System.out.println("Incorrect Password");
            return;
        }
        if(senderAcc.balance <= amt){
            System.out.println("Insufficient balance ");
            senderAcc.checkBalance();
            return;
        }
        senderAcc.withdraw(amt);
        receiverAcc.deposit(amt);
        System.out.println("Succefully transeferred " + amt);

    }
}
