package algorithm.problems.baekjoon.greedy.unsolved;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_1138 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] inputs = sc.nextLine().split(" ");
        Person[] persons = new Person[N];
        
        for (int i = 0; i < N; i++) {
            persons[i] = new Person(i + 1, Integer.parseInt(inputs[i]));
        }
        Arrays.sort(persons);
        
        for (int i = N - 1; i > 0; i--) {
            swap(persons, i, persons[i].personTaller);
        }
        
        String[] height = new String[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.toString(persons[i].height);
        }
        
        System.out.println(String.join(" ", height));
    }
    
    static void swap(Person[] persons, int i, int j) {
        Person tmp = persons[i];
        persons[i] = persons[j];
        persons[j] = tmp;
    }
}

class Person implements Comparable<Person> {
    
    int height;
    int personTaller;
    
    public Person(int height, int personTaller) {
        this.height = height;
        this.personTaller = personTaller;
    }
    
    @Override
    public int compareTo(Person o) {
        if (this.personTaller < o.personTaller) {
            return -1;
        } else if (this.personTaller == o.personTaller) {
            if (this.height < o.height) {
                return -1;
            }
        }
        return 1;
    }
}
