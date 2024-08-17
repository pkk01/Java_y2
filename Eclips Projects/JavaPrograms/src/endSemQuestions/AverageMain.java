package endSemQuestions;

//WAP to find average of an array of integers
import java.util.*;
public class AverageMain {
 public static double average (int arr[])
 {
     int len = arr.length;
     int sum = 0;
     for (int i = 0; i < len; i++)
     {
         sum += arr[i];
     }
     return sum/len;
 }
 public static void main (String[] args) {
     Scanner sc = new Scanner (System.in);
     System.out.print("Enter number of elements in array:  ");
     int n = sc.nextInt();
     int [] arr = new int [n];
     System.out.println("Enter the array");
     for (int i = 0; i<n; i++)
     {
         arr[i] = sc.nextInt();
     }
     double avg = average (arr);
     System.out.println("Average: "+avg);
 }
}