import java.util.*;
public class Program0 {
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
