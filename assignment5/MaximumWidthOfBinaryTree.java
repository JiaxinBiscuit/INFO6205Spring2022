import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

public class MaximumWidthOfBinaryTree {
    private class TreeNode {
        int val;
        FindLargestValueInEachTreeRow515.TreeNode left;
        FindLargestValueInEachTreeRow515.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, FindLargestValueInEachTreeRow515.TreeNode left, FindLargestValueInEachTreeRow515.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return -1;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList();
        queue.offer(new Pair<>(root,0));
        int maxWidth = 0;

        while(! queue.isEmpty()){
            int size = queue.size();
            Pair<TreeNode, Integer> element = null;
            int head = 0;
            int end = 0;
            for(int i=0; i<size;i++){
                element = queue.poll();
                TreeNode cur = element.getKey();
                if(i == 0){
                    head = element.getValue();
                }
                if(i == size-1){
                    end = element.getValue();
                }

                if(cur.left != null){
                    queue.offer(new Pair(cur.left,element.getValue()*2));
                }

                if(cur.right != null){
                    queue.offer(new Pair(cur.right,element.getValue()*2+1));
                }
            }

            maxWidth = Math.max(end-head+1,maxWidth);
        }

        return maxWidth;
    }
}
