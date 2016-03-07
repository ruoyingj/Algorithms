import java.util.ArrayList;
import java.util.List;

/**
 * Print all nodes at distance k from a given node
 * Given a binary tree, a target node in the binary tree,
 * and an integer value k, print all the nodes that are at distance
 * k from the given target node. No parent pointers are available.
 * more detail on
 * http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 */
public class FindNdistanceNode {
    static node root = null;
    static List<Integer> res = new ArrayList<>();

    class node{
        int val;
        node left;
        node right;
        public node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }


    public void printTargetDown(node target, int k){
        if(target == null) return;
        if(k == 0){
            res.add(target.val);
        }
        printTargetDown(target.left,k-1);
        printTargetDown(target.right,k-1);
    }


    public int printTargetUp(node cur, node target, int k){
        if(cur == null){
            return -1;
        }
        if(cur == target){
            printTargetDown(cur,k);
            return 0;
        }
        int l = printTargetUp(cur.left,target,k);

        if(l != -1){
            if(l+1 == k){
                res.add(cur.val);
            }else{
                printTargetDown(cur.right,k-l-2);
            }
            return l + 1;
        }

        int r = printTargetUp(cur.right,target,k);

        if(r != -1){
            if(r + 1 == k){
                res.add(cur.val);
            }else{
                printTargetDown(cur.left,k-l-2);
            }
            return r + 1;
        }


        return -1;


    }

}
