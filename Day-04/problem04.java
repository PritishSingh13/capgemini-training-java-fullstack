// Write a Java program to check whether the given number is prime or not

import java.util.*;

public class Problem04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;

        // 1 and below are not prime
        if (n <= 1) {
            System.out.println("Not a Prime Number");
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 1) {
            System.out.println("Prime Number");
        } else {
            System.out.println("Not a Prime Number");
        }
    }
}
