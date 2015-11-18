import java.util.HashSet;

/**
 * Created by David on 2015/11/18.
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}

/*
* Given an array of integers, find if the array contains any duplicates.
* Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
* */