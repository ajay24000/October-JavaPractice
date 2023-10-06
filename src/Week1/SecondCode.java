package Week1;

import java.util.Scanner;

public class SecondCode {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        // Array declaration
        int[] arr = new int[size];

        System.out.println("Enter the array elements: ");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        float result = averageSum(arr,size);
        System.out.println("Average Sum is "+result);
    }
    static int averageSum(int[] arr,int size){
        int avgSum = 0;
        for (int i = 0; i < size; i++) {
            avgSum += arr[i];
        }
        return avgSum/size;
    }
}
