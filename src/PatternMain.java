import java.io.File;
import java.util.Scanner;

public class PatternMain {

    public static void main(String[] args) {
        File file1 = new File("pattern.txt");
        File file2 = new File("text.txt");
        try {
            Scanner input1 = new Scanner(file1);
            Scanner input2 = new Scanner(file2);
            String pattern = input1.nextLine();
            String text = input2.nextLine();
            PatternMatching patternMatching = new PatternMatching();
            System.out.println("First index:  " + patternMatching.KMP(text, pattern));
            System.out.println("First index:  " + patternMatching.Boyer_Moore(text, pattern));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
