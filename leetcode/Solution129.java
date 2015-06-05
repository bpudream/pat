/**
 * Created by David on 2015/6/5.
 */
import java.util.ArrayList;
import java.util.List;
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        int sum = 0;
        List<TreeNode> list = new ArrayList<>();
        List<Boolean> flags = new ArrayList<>();

        list.add(root);
        flags.add(false);
        while(root.left != null) {
            root = root.left;
            list.add(root);
            flags.add(false);
        }

        while(!list.isEmpty()) {
            int lastindex = list.size() - 1;
            if(flags.get(lastindex)) {
                list.remove(lastindex);
                flags.remove(lastindex);
            }
            else if(list.get(lastindex).right == null) {
                if(list.get(lastindex).left == null) {
                    int number = 0;
                    int mult = 1;
                    for (int i = lastindex; i >= 0; i--) {
                        number += list.get(i).val * mult;
                        mult *= 10;
                    }
                    sum += number;
                }
                list.remove(lastindex);
                flags.remove(lastindex);
            }
            else {
                flags.set(lastindex, true);
                root = list.get(lastindex).right;
                list.add(root);
                flags.add(false);
                while(root.left != null) {
                    root = root.left;
                    list.add(root);
                    flags.add(false);
                }
            }
        }
        return sum;
    }
}

/**
 * Sum root to leaf numbers
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */