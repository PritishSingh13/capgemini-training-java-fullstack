import java.util.*;
public class ifCondition {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a % 2 == 0) {
            System.out.println("Number is even");
        }
        if(a % 2 != 0){
            System.out.println("Number is odd");
        }
    }
}
