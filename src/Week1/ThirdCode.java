package Week1;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class ThirdCode {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of arrays:");
        int size =sc.nextInt();
        int[] arrA = new int[size];
        int[] arrB = new int[size];

        System.out.println("Enter the elements of first array:");
        for(int i=0;i<size;i++){
            arrA[i] = sc.nextInt();
        }
        System.out.println("Enter the elements of second array:");
        for(int i=0;i<size;i++){
            arrB[i] = sc.nextInt();
        }
        int[] maxArray = maxValue(arrA,arrB);
        double[] c = findC(maxArray,arrA, arrB);

        System.out.println("Array c: " + Arrays.toString(c));
    }
    static double[] findC(int[] maxArray,int[] arrA,int[] arrB){
        double[] c = new double[Math.min(arrA.length, arrB.length)];

        for(int i = 0; i < c.length; i++){
            c[i] = (double)maxArray[i] + (double)arrA[i] / arrB[i];
        }

        return c;
    }
    static int[] maxValue(int[] arrA, int[] arrB){

        int[] maxElements = new int[Math.min(arrA.length, arrB.length)];

        for (int i = 0; i < maxElements.length; i++) {
            if(arrA[i] > arrB[i]){
                maxElements[i] = arrA[i];
            }
            else{
                maxElements[i] = arrB[i];
            }
        }
        return maxElements;
    }
}
