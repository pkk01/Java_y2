package endSemQuestions;

import java.util.*;
public class Test {
    public static void main (String[] args) {
        List <Integer> arr = new ArrayList <>();
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter elements");
        for (int i =  0; i < 5; i++)
        {
            arr.add(sc.nextInt());
        }
        int sum = 0;
        for (int number: arr)
        {
            sum+= number;
        }
        System.out.println("Sum: "+sum);
    }
}
