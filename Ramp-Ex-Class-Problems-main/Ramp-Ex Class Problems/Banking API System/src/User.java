import java.util.*;
public class User {
    String name;
    long phoneNum;

    Map<Long, Account> accountList = new HashMap<>();

    public User(String name, long phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
    }
}
