import java.util.HashMap;

/**
 * Created by David on 2015/11/18.
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hash.containsKey(nums[i])) {
                if(i - hash.get(nums[i]) <= k) {
                    return true;
                }
            }
            hash.put(nums[i], i);
        }
        return false;
    }
}

/*
* Given an array of integers and an integer k,
* find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
* */