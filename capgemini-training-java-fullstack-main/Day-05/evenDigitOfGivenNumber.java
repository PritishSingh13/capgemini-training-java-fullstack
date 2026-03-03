//WAJP to print the even digit of a given number

import java.util.Scanner;
public class evenDigitOfGivenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Even digits are:");
        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 == 0) {
                System.out.println(digit);
            }
            num = num / 10;
        }
    }
}
