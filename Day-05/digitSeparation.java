//WAJP to print the digit of a given number

import java.util.Scanner;

public class digitSeparation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Digits of the number are:");
        while (num > 0) {
            int digit = num % 10;
            System.out.println(digit);
            num = num / 10;
        }
    }
}
