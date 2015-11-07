import java.util.HashMap;

/**
 * Created by David on 2015/11/7.
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int bit[] = new int[32];
        for(int i : nums) {
            for(int k = 0; k < 32; k++) {
                bit[k] += i >> k & 1;
            }
        }
        int sum = 0;
        int half = nums.length / 2;
        for(int k = 0; k < 32; k++) {
            int b = 0;
            if(bit[k] > half) {
                b = 1;
            }
            sum += b << k;
        }
        return sum;
    }
    public int majorityElement0(int[] a) {
        int n = a.length / 2;
        int res = -1;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i : a) {
            if(hash.containsKey(i)) {
                int pre = hash.get(i);
                if(pre + 1 > n) {
                    return i;
                }
                hash.put(i, pre + 1);
            }
            else {
                hash.put(i, 1);
                res = i;
            }
        }
        return res;
    }
}

/*
* Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.

You may assume that the array is non-empty and the majority element always exist in the array.
* */