import java.util.Arrays;
import java.util.HashMap;

public class ArraysAndStrings {
    /*
     * returns true if a string has unique caharcters
     */
    public static boolean unique(String s) {
        // assume ASCII-extended or Unicode
        boolean[] characters = new boolean[256];
        for (char c: s.toCharArray()) {
            int pos = (int) c;
            if (characters[pos]) return false;
            characters[pos] = true;
        } 
        return true;
    }

    public static boolean isPermutation(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        String s1Sorted = new String(s1Chars); 
        String s2Sorted = new String(s2Chars);
        return s1Sorted.equals(s2Sorted);
    }

    public static String urlify(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }

    public static boolean palindromePermutation(String s) {
        boolean singleOdd = false; // flag to keep track of whether or not the odd character has been found
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (c == ' ') continue; //ignore spaces
            if (!count.containsKey(c)) {
                count.put(c, 1);
            } else {
                int prevCount = count.get(c);
                count.put(c, prevCount + 1);
            }
        }

        for (char c: count.keySet()) {
            int cCount = count.get(c);
            if (cCount % 2 == 1) {
                if (singleOdd) {
                    return false;
                }
                singleOdd = true;
            }
        }
        return true;
    }

    private static int diff(String s1, String s2) {
      int numDiff = 0;
      char[] s1Chars = s1.toCharArray();
      char[] s2Chars = s2.toCharArray();
      Arrays.sort(s1Chars);
      Arrays.sort(s2Chars);
      String s1Sorted = new String(s1Chars); 
      String s2Sorted = new String(s2Chars);
      int lim = Math.min(s1.length(), s2.length());
      for(int i = 0; i < lim; i++) {
        if (s1.charAt(i) != s2.charAt(i)) numDiff++;
      }
      return numDiff;
    }

    private static int removed(String s1, String s2) {
        String shorter = s1;
        String longer = s2;
        if (s1.length() > s2.length()) {
            shorter = s2;
            longer = s1;
        }
        int diff = 0;
        int j = 0;
        for (int i = 0; i < longer.length(); i++) {
            if (i > shorter.length() - 1 || shorter.charAt(j) != longer.charAt(i)) {
                diff++;
            } else {
                j++;
            }
        }

        return diff;
    }

    public static boolean oneAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) >= 2) {
            return false;
        } 
        int i = 0;
        int j = 0;

        if ( s1.length() == s2.length()) {
            return diff(s1, s2) == 1;
        }
        return removed(s1, s2) == 1;
    }

    public static String stringCompression(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        StringBuilder unique = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1); 
            } else {
                unique.append(c);
                charMap.put(c, 1);
            }
        }
        StringBuilder sb = new StringBuilder();

        for(char c: unique.toString().toCharArray()) {
            sb.append(c);
            sb.append(String.valueOf(charMap.get(c)));
        }

        return sb.toString();
    }

    public byte[][] rotateInPlace(byte[][] matrix) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(stringCompression(args[0]));
    }
}