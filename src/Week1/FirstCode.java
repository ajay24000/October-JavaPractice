package Week1;

import java.util.Scanner;

public class FirstCode {
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

        printArray(arr);

        int result = findSum(arr,size);
        System.out.println("Sum is " +result);
    }
    static int findSum(int[] arr,int size){
        int sum = 0;
        for (int i = 0; i < size; i++){
            sum += arr[i];
        }
        return sum;
    }
    static void printArray(int[] arr){
        System.out.println("The printed array is:");
        for (int j : arr) {
            System.out.print(j +" ");
        }
        System.out.println();
    }
}
