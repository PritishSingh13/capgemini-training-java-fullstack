/*WAP to check the given character is
uppercase vowel uppercase consonant
Lowercase vowel
Lowercase consonant
If the given character is uppercase vowel, print numbers from the range 10 to 20 using do while
If the given character is lowercase vowel, print numbers from the range -10 to -20 usng while
if the given character is uppercase consonant, print numbers from the range 25 to 15 using for
 If the given character is lowercase consonant, print numbers from the range -25 to -15 using for loop
*/
import java.util.*;
class Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        int n = 0;
        if(ch == 'A' | ch == 'E' | ch == 'I' || ch == 'O' || ch== 'U'){
            n=10;
            do{
                System.out.println(n);
                n++;

            }
            while(n <=20);
        }
        else if(ch == 'a' | ch == 'e' | ch == 'i' || ch == 'o' || ch== 'u'){
            n= -10;
            while(n >= -20){
                System.out.println(n);
                n--;
            }
        }
        else if(ch >= 'A' && ch <= 'Z'){
            for( n= 25;n>= 15;n--){
                System.out.println(n);
            }
        }
        else if(ch >= 'a' && ch <= 'z'){
            for(n = -25 ;n <= -15;n++){
                System.out.println(n);
            }
        }
        else{
            System.out.println("GG");
        }

    }

}
