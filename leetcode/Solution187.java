import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by David on 2015/11/8.
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> list = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if(set.contains(sub)) {
                list.add(sub);
            }
            else {
                set.add(sub);
            }
        }

        List<String> res = new ArrayList(list);
        return res;
    }
}

/*
* All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
* When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
* */