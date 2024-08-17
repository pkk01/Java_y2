import java.io.*;

public class ReadWords {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("Hello.txt");
            int wordCount = 0;
            int lineCount = 0;
            int data;
            while ((data = fis.read()) != -1) {
                char ch = (char) data;
                if (ch == '\n')
                    lineCount++;
                else if (ch == ' ') {
                    wordCount++;
                }
            }
            System.out.println("Word Count: " + wordCount);
            System.out.println("Line Count: " + lineCount);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
