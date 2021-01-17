package algorithm.problems.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_10814 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        User[] users = new User[N];
        for (int i = 0; i < N; i++) {
            String[] userInfo = sc.nextLine().split(" ");
            users[i] = new User(i, Integer.parseInt(userInfo[0]), userInfo[1]);
        }
        Arrays.sort(users);
        for (User user : users) {
            System.out.println(user.age + " " + user.name);
        }
    }
}

class User implements Comparable<User> {
    
    int idx;
    int age;
    String name;
    
    public User(int idx, int age, String name) {
        this.idx = idx;
        this.age = age;
        this.name = name;
    }
    
    @Override
    public int compareTo(User o) {
        if (this.age != o.age) {
            return (this.age - o.age);
        }
        return (this.idx - o.idx);
    }
}
