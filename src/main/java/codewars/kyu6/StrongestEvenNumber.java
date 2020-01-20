package codewars.kyu6;

@SuppressWarnings("squid:S1118")
public class StrongestEvenNumber {
    public static int strongestEven(int n, int m) {
        int current = n;
        int maxStrength = getStrength(current);
        int maxStrengthNumber = current;
        current += twoPow(maxStrength);
        while (0 < current && current <= m) {
            int currentStrength = getStrength(current);
            if (currentStrength > maxStrength) {
                maxStrength = currentStrength;
                maxStrengthNumber = current;
            }
            current += twoPow(maxStrength);
        }
        return maxStrengthNumber;
    }

    static int getStrength(int n) {
        int strength = 0;
        while (((n >> strength) & 1) == 0) {
            strength++;
        }
        return strength;
    }

    static int twoPow(int currentStrength) {
        return 1 << currentStrength;
    }

    public static int strongestEvenAlt(int n, int m) {
        while (m >= n) {
            if ((m & (m - 1)) < n) {
                return m;
            }
            m &= m - 1;
        }
        return 0;
    }
}
