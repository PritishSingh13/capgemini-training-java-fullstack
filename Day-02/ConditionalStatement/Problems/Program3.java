//Write a java program to check whether the given character is vowel or consonant.

import java.util.*;
public class Program3{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        char a = sc.next().charAt(0);
        a = Character.toLowerCase(a);
        if(a == 'a' || a== 'e' || a=='i' || a=='o' || a== 'u'){
            System.out.println("vowel");
        }
        else{
            System.out.println("consonant");
        }
    }
}
