package leetcode;

/**
 * Created by bpudream on 15-09-14.
 */
public class Solution027 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int counter = 0;
        int end = n - 1;
        int i = 0;
        while(end >= 0 && nums[end] == val) {
            end--;
            counter++;
        }
        while(i < end) {
            if(nums[i] == val) {
                counter++;
                int temp = nums[i];
                nums[i] = nums[end];
                nums[end--] = temp;
                while(i < end && nums[end] == val) {
                    end--;
                    counter++;
                }
            }
            i++;
        }

        return n - counter;
    }
}

// Given an array and a value, remove all instances of that value in place and return the new length.
//The order of elements can be changed. It doesn't matter what you leave beyond the new length.
