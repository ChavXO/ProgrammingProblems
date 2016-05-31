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

    private static boolean removed(String s1, String s2) {

        //
        String shorter = s1;
        String longer = s2;
        if (s1.length() > s2.length()) {
            shorter = s2;
            longer = s1;
        }
        int i = 0;
        int j = 0;
        int diff = 0;
        while (i < shorter.length()  && j < longer.length()) {
            if (i > shorter.length() - 1 || shorter.charAt(i) != longer.charAt(j)) {
                diff++;
                j++;
            } else {
                j++;
                i++;
            }
        }

        return diff == 1;
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
        return removed(s1, s2);
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

    public static byte[][] rotateInPlace(byte[][] matrix) {

        int n = matrix[0].length;
        int start_i = 0;
        int start_j = 0;
        int i = 0;
        int j = 0;
        while (i < n - start_j - 1) {
            while (j < n - start_j - 1) {
                byte p1 = matrix[i][j]; 
                byte p2 = matrix[n - 1 - j][i];
                byte p3 = matrix[n - 1 - i][n - 1 - j];
                byte p4 = matrix[j][n - 1 - i];
                matrix[n - 1 - j][i] = p1;
                matrix[n - 1 - i][n - 1 - j] = p2;
                matrix[j][n - 1 - i] = p3;
                matrix[i][j] = p4;
                j++;
                
            }

            start_j++;
            start_i++;
            i = start_i;
            j = start_j; 
        }
        return matrix;
    }

    public static double[][] zeroMatrix(double[][] matrix) {
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        matrix[i][k] = Double.NEGATIVE_INFINITY;
                        matrix[k][j] = Double.NEGATIVE_INFINITY;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Double.NEGATIVE_INFINITY) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static boolean stringRotation(String s1, String s2) {
        StringBuilder s = new StringBuilder(s2);
        s.append(s2);
        return s.toString().contains(s1);
    }

    public static void main(String[] args) {
        String s1 = args[0];
        String s2 = args[1];
        System.out.println(stringRotation(s1, s2));
    }
}