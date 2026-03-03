// Write a java program to check whether the given no.is divisible by 7.

import java.util.*;
public class Program1{
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        if(b % 7 == 0){
            System.out.println("the number is divisible by 7");
        }
        else{
            System.out.println("the number is not divisible by 7");
        }
    }
}
