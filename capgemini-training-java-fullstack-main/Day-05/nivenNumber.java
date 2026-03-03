//✅ What is a Niven Number?
/*
A Niven number (also called Harshad number) is a number that is divisible by the sum of its digits.

Example:
18
Sum of digits = 1 + 8 = 9
18 ÷ 9 = 2 → divisible ✅
So, 18 is a Niven number*/

import java.util.Scanner;

public class nivenNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int temp = num;
        int sum = 0;

        // find sum of digits
        while (temp > 0) {
            int digit = temp % 10;
            sum = sum + digit;
            temp = temp / 10;
        }

        // check niven condition
        if (num % sum == 0) {
            System.out.println(num + " is a Niven Number");
        } else {
            System.out.println(num + " is not a Niven Number");
        }
    }
}
