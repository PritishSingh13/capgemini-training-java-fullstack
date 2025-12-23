//Given a number n, for each integer i in the range from 1 to n inclusive, print out one value

//
/*
if i is a multiple of both 3 and 5, print FizzBuzz
if i is a multiple of both 3(but not 5), print Fizz
if i is a multiple of both 5 (but not 3), print Buzz
if i is a multiple of both 3 and 5, print the value of i
*/


import java.util.*;
public class problem02 {
    public static void main(String[] args) {
        int n = 20;  // example value

        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            }
            else if (i % 3 == 0) {
                System.out.println("Fizz");
            }
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }
}
