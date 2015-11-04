package leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

/**
 * Created by bpudream on 15-11-04.
 */
public class Solution133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        queue.add(node);
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        map.put(node, res);

        while(!queue.isEmpty()) {
            UndirectedGraphNode old = queue.remove();
            UndirectedGraphNode current = map.get(old);
            for(UndirectedGraphNode n : old.neighbors) {
                UndirectedGraphNode newNeighbor;
                if(!map.containsKey(n)) {
                    queue.add(n);
                    newNeighbor = new UndirectedGraphNode(n.label);
                    map.put(n, newNeighbor);
                }
                else {
                    newNeighbor = map.get(n);
                }
                current.neighbors.add(newNeighbor);
            }
        }

        return res;
    }
}


/*
* Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
* */