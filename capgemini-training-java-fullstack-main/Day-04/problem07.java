/*write a java program to print factorial of a given number.
write a java program to print factorial of all numberes from the range 1 to 10;
write a java program to print factorial of all odd numbers from the range 10 to 1
write a java program to print factorial of all prime numbes from range 14 to 5.
write a java prograam to print addition of all prime numbers from the range 32 to 50.
*/


public class problem07 {
    public static void main(String[] args) {
        int num = 5;
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of " + num + " is: " + fact);
    }
}

