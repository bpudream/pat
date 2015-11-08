import java.util.ArrayList;

/**
 * Created by David on 2015/11/8.
 */
public class Solution179 {
    public String largestNumber(int[] a) {
        StringBuffer sb = new StringBuffer("");

        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        for(int val : a) {
            if(val > max) {
                max = val;
            }
            list.add(val);
        }
        int length = ("" + max).length();
        bucketSortX(list, 0, length);

        for(int val : list) {
            sb.append(val);
        }

        if(sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }

    private void bucketSortX(ArrayList<Integer> list, int round, int maxLength) {
        if(round >= maxLength) {
            return;
        }
        int n = list.size();
        int[] max = new int[10];
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for(int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }
        ArrayList<Integer> selfLarge = new ArrayList<>();
        ArrayList<Integer> selfSmall = new ArrayList<>();
        for(int val : list) {
            String s = ("" + val);
            int index = 0;
            if(round >= s.length()) {
                int last = s.charAt(s.length() - 1) - '0';
                int myself = s.charAt(0) - '0';
                if(last > myself) {
                    selfLarge.add(val);
                }
                else {
                    selfSmall.add(val);
                }
            }
            else {
                index = s.charAt(round) - '0';
                buckets[index].add(val);
                if(s.length() > max[index]) {
                    max[index] = s.length();
                }
            }
        }

        int selfIndex = ("" + list.get(0)).charAt(0) - '0';
        for(int i = 0; i < buckets[selfIndex].size(); i++) {
            selfLarge.add(buckets[selfIndex].get(i));
        }
        for(int val : selfSmall) {
            selfLarge.add(val);
        }
        buckets[selfIndex] = selfLarge;

        for(int i = 0; i < 10; i++) {
            if(buckets[i].size() > 1) {
                bucketSortX(buckets[i], round + 1, max[i]);
            }
        }

        list.removeAll(list);
        for(int i = 9; i >= 0; i--) {
            for(int val : buckets[i]) {
                list.add(val);
            }
        }
    }
}

/*
* Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
* */