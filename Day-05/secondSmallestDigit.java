import java.util.Scanner;

public class secondSmallestDigit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int smallest = 9;
        int secondSmallest = 9;

        while (num > 0) {
            int digit = num % 10;

            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }

            num = num / 10;
        }

        System.out.println("Second smallest digit = " + secondSmallest);
    }
}
