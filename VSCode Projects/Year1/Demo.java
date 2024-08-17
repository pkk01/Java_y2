import java.io.*;

public class Demo {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("Hello.txt");
            int data;
            int count = 0;
            while ((data = fr.read()) != -1) {
                char ch = (char) data;
                if (ch == 'a' || ch == 'e' || ch == 'o' || ch == 'i' || ch == 'u')
                    count++;
            }
            System.out.println("Number of vowels:  " + count);
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}