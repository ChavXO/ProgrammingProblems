import java.util.Arrays;
import java.util.ArrayList;

public class Intersection {
    public static int[] intersect(int[] nums1, int[] nums2) {
       Arrays.sort(nums1);
       Arrays.sort(nums2);
       // maitain two counters
       ArrayList<Integer> intersection = new ArrayList<Integer>();
       int i = 0;
       int j = 0;
       while (i < nums1.length && j < nums2.length) {
           if (nums1[i] == nums2[j]) {
               intersection.add(nums1[i]);
               i++;
               j++;
           } else if (nums1[i] < nums2[j]) {
               i++;
           } else {
               j++;
           }
       }
       
       int[] ret = new int[intersection.size()];
       for (i = 0; i < ret.length; i++) {
           ret[i] = intersection.get(i);
       }
       
       return ret;
    }

    public static void main(String[] args) {
       int [] nums1 = {1, 2, 2, 3, 4, 5};
       int [] nums2 = {2, 2};
       int [] answer = intersect(nums1, nums2);
       System.out.println(Arrays.toString(answer));
    }
}