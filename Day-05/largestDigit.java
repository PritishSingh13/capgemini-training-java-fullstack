import java.util.Scanner;

public class largestDigit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int largest = 0;

        while (num > 0) {
            int digit = num % 10;

            if (digit > largest) {
                largest = digit;
            }

            num = num / 10;
        }

        System.out.println("Largest digit = " + largest);
    }
}
