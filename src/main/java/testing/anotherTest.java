package testing;

import java.util.Scanner;

public class anotherTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter three no");
        int a,b,c;
        a=scan.nextInt();
        b= scan.nextInt();
        c=scan.nextInt();
        if(a>b && a>c){
            System.out.println("Max no "+a);
        }else if(b>a&&b>c){
            System.out.println("Max no "+b);
        }else System.out.println("Max no "+c);
    }
}
