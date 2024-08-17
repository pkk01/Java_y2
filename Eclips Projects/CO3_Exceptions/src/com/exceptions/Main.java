package com.exceptions;
import java.util.*;
class MyException extends Exception {
    public String getMessage ()
    {
        // super (msg);
        return "Get message";
    }
}
public class Main {
    public static void main (String[] args) {
        /* code */
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        if (a < 10)
        	{
        	try {
        		throw new MyException();
        	}
        	catch (Exception e)
        	{
        		System.out.println(e.getMessage ());
        		System.out.println("Check msg"); 
        	}
        }
        else {
        	System.out.println("Exited");
        }
    }   
}
