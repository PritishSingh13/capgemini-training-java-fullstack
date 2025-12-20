import java.util.Scanner;

class Switchchoice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        int choice = sc.nextInt();
        System.out.println("Enter number of values (2 / 3 / 4): ");
        int n = sc.nextInt();
        double a, b, c, d, result = 0;
        switch (choice) {
            case 1: // ADDITION
                if (n == 2) {
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    result = a + b;
                } else if (n == 3) {
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    c = sc.nextDouble();
                    result = a + b + c;
                } else if (n == 4) {
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    c = sc.nextDouble();
                    d = sc.nextDouble();
                    result = a + b + c + d;
                } else {
                    System.out.println("Invalid count");
                    return;
                }
                break;

            case 2: // SUBTRACTION
                if (n == 2) {
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    result = a - b;
                } else if (n == 3) {
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    c = sc.nextDouble();
                    result = a - b - c;
                } else if (n == 4) {
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    c = sc.nextDouble();
                    d = sc.nextDouble();
                    result = a - b - c - d;
                } else {
                    System.out.println("Invalid count");
                    return;
                }
                break;

            case 3: // MULTIPLICATION
                if (n == 2) {
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    result = a * b;
                } else if (n == 3) {
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    c = sc.nextDouble();
                    result = a * b * c;
                } else if (n == 4) {
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    c = sc.nextDouble();
                    d = sc.nextDouble();
                    result = a * b * c * d;
                } else {
                    System.out.println("Invalid count");
                    return;
                }
                break;

            case 4: // DIVISION
                if (n == 2) {
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    result = a / b;
                } else {
                    System.out.println("Division allowed only for 2 numbers");
                    return;
                }
                break;

            default:
                System.out.println("Invalid operation");
                return;
        }

        System.out.println("Result = " + result);
    }
}
