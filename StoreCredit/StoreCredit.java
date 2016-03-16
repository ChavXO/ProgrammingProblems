import java.util.HashSet;
import java.util.Scanner;
import java.io.File;

public class StoreCredit {
  /*
   * Strategy: pass into a hash set and then check if the 
   * value you need to add to get C is in the set
   */

    static class Pair {
      int first;
      int second;
      public Pair(int f, int s) {
          first = f;
          second = s;    
      }

      public String toString() {
          return String.valueOf(first) + " " + String.valueOf(second);
      }
    }

    public static void main(String [] args) {
        if (args.length == 0) {
            System.out.println("Please spcify and input file.");
            return;
        }
        
        String filename = args[0];
        File inputFile = null;
        Scanner scan = null;
        try {
            inputFile = new File(filename);
            scan = new Scanner(inputFile);   
        } catch (Exception e) {
            System.out.println("An error occured");
            return;
        }

        

        int testCases = scan.nextInt();

        for (int i = 0; i < testCases; i++) {
            Pair result = solve(scan);
            System.out.println("Case #" + String.valueOf(i + 1) + ": " + result.toString());
        }
    }

    private static Pair solve(Scanner scan) {
        int credit = scan.nextInt();

        int arrayLength = scan.nextInt();
        HashSet<Integer> hash = new HashSet<Integer>(arrayLength);
        int [] arr = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int curr = scan.nextInt();
            arr[i] = curr;
            hash.add(curr);
        }

        int first_index = -1;
        int second_index = -1;
        for (int i = 0; i < arrayLength; i++) {
            if (hash.contains(credit - arr[i])) {
                first_index = i + 1;

                // is there a more efficient way to do this?
                int second = credit - arr[i];
                for (int j = 0; j < arrayLength; j++) {
                    if (arr[j] == second && j != i) {
                        second_index = j + 1;
                        break;
                    }
                }
                if (second_index != -1) break; // had to add check for first index
            }
        }
        int smaller = Math.min(first_index, second_index);
        int larger = Math.max(first_index, second_index);
        Pair ret = new Pair(smaller, larger);
        return ret;
    }   
}