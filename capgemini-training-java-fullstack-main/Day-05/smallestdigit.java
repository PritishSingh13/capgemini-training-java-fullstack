import java.util.Scanner;

public class smallestdigit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int smallest = 9;

        while (num > 0) {
            int digit = num % 10;

            if (digit < smallest) {
                smallest = digit;
            }

            num = num / 10;
        }

        System.out.println("Smallest digit = " + smallest);
    }
}
