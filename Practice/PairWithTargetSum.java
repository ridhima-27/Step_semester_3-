 import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> complements = new HashSet<>();
        for (int num : nums) {
            if (complements.contains(num)) {
                return true;
            }
            complements.add(target - num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 4, 6};
        System.out.println(hasPairWithSum(nums1, 9));  // true
        System.out.println(hasPairWithSum(nums2, 20)); // false
    }
}