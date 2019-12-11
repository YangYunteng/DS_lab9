import java.io.File;
import java.util.Scanner;

public class PatternMatching {

    public int Boyer_Moore(String text, String pattern) {
        System.out.println("Boyer-Moore");
        int[] charJump = getCharacterJump(pattern);
        System.out.print("Character:  ");
        for (int number : charJump) {
            System.out.print(number + "\t");
        }
        System.out.println();
        int i = pattern.length() - 1;
        int j = pattern.length() - 1;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == 0)
                    return i;
                else {
                    i--;
                    j--;
                }
            } else {
                i = i + pattern.length() - Math.min(j, 1 + charJump[text.charAt(i) - 'a']);
                j = pattern.length() - 1;
            }
        }
        return -1;
    }

    public int[] getCharacterJump(String pattern) {
        int[] charJump = new int[26];
        for (int i = 0; i < charJump.length; i++) {
            charJump[i] = -1;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (charJump[pattern.charAt(i) - 'a'] < i) {
                charJump[pattern.charAt(i) - 'a'] = i;
            }

        }
        return charJump;
    }

    public int KMP(String text, String pattern) {
        System.out.println("KMP:");
        int[] next = getNext(pattern);
        System.out.print("NEXT:       ");
        for (int number : next) {
            System.out.print(number + "\t");
        }
        System.out.println();
        int i = 0;
        int j = 0;
        while (i < text.length()) {
            if (j == pattern.length()) {
                return i - j;
            } else {
                if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
        }
        return -1;
    }

    public int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        next[1] = 0;
        for (int i = 2; i < pattern.length(); i++) {
            int temp = next[i - 1];
            while (temp != -1) {
                if (pattern.charAt(i - 1) == pattern.charAt(temp)) {
                    next[i] = temp + 1;
                    break;
                } else {
                    temp = next[temp];
                }
            }
        }
        return next;
    }
}
