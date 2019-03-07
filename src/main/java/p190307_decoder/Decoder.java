package p190307_decoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Decoder {
    private static final int first = 1072;
    private static final int lastPlusOne = 1106;
    public static void main(String[] args) throws IOException {
        String s = Files.readAllLines(Paths.get("src/main/java/p190307_decoder/string.txt")).get(0);
        char[] chars = s.toCharArray();
        String[] words = s.split(" ");
        System.out.println(s);
        for (int i = -9; i < -7; i++) {
            for (char aChar : chars) {
                System.out.print(convertChar(aChar, i));
            }
            System.out.println();
        }
//        for (char letter = 1040; letter <= 1110; letter++)  {
//            System.out.println(letter + " " + (int) letter);// + " shifted: " + convertChar(letter, 10));
//        }
    }

    private static char convertChar(char aChar, int shift) {
        switch (aChar) {
            case 32: break;
            case 44: break;
            case 45: break;
            case 46: break;
            default: aChar = (char) shiftChar(aChar, shift);
        }
        return aChar;
    }

    private static int shiftChar(char aChar, int shift) {
        return first + (aChar - first + shift) % (lastPlusOne - first);
    }
}
