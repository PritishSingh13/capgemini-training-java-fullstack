//WAp to print prime numbers from the range 20 to 1.

public class problem05 {
    public static void main(String[] args) {

        for (int i = 20; i >= 1; i--) {
            int count = 0;
            // check divisibility
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            // prime number condition
            if (count == 2) {
                System.out.println(i);
            }
        }
    }
}
