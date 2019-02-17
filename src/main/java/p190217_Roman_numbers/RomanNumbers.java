package p190217_Roman_numbers;

/**
 * Convert Roman numbers into Arabic numbers using Character.getNumericValue
 */
public class RomanNumbers {
    public static void main(String[] args) {
        System.out.println('\u216c' + " = " + Character.getNumericValue(0x216c));
        printRomanNumbers();
    }

    private static void printRomanNumbers() {
        for (int i = 216; i < 219; i++) {
            for (int j = 0; j < 15; j++) {
                char s = (char) Integer.parseInt(i + Integer.toHexString(j), 16);
                System.out.println(s + " = " + Character.getNumericValue(s));
            }
        }
    }
}
