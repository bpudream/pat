package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpudream on 15-11-04.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
