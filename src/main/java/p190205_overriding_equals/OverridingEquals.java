package p190205_overriding_equals;

import java.util.HashSet;
import java.util.Set;

public class OverridingEquals {
    public static void main(String[] args) {
//        addSameObjectToTheSet();
        changeFieldInOriginalObject();
    }

    private static void addSameObjectToTheSet() {
        User user1 = User.builder().name("Pol").age(7).counter(1).build();
        System.out.println("user1.hashCode() = " + user1.hashCode());
        Set<User> users = new HashSet<>();
        System.out.println("Add user1 to users set");
        users.add(user1);
        User user2 = User.builder().name("Pol").age(7).counter(2).build();
        System.out.println("user2.hashCode() = " + user2.hashCode());
        System.out.println("users.contains(user1) = " + users.contains(user1));
        System.out.println("users.contains(user2) = " + users.contains(user2));
        System.out.println("Add user2 to users set");
        users.add(user2);
        System.out.println("users.size() = " + users.size());
    }

    private static void changeFieldInOriginalObject() {
        User user1 = User.builder().name("Pol").age(7).counter(1).build();
        System.out.println("user1.hashCode() = " + user1.hashCode());
        Set<User> users = new HashSet<>();
        System.out.println("Add user1 to users set");
        users.add(user1);
        System.out.println("Change counter of user1 1 -> 2");
        user1.setCounter(2);
        System.out.println("new user1.hashCode() = " + user1.hashCode());
        System.out.println("users.contains(user1) = " + users.contains(user1));
        System.out.println("Change age of user1 7 -> 8");
        user1.setAge(8);
        System.out.println("new user1.hashCode() = " + user1.hashCode());
        System.out.println("users.contains(user1) = " + users.contains(user1));
        System.out.println("users.size() = " + users.size());

    }
}
