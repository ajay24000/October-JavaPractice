package Week1;

import java.util.Scanner;

public class FourthCode {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String str = sc.nextLine();

        System.out.println("The length of the String is :"+stringLength(str));
    }
    static int stringLength(String str){
        int length = 0;
        for(char c : str.toCharArray()){
            if(c == '0') {
                break;
            }
            else{
                length++;
            }
        }
        return length;
    }
}
