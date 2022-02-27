import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class FindLeavesOfBinaryTree366 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null) return new ArrayList();

        HashMap<Integer, List<Integer>> output = new HashMap();
        inputHashmap(root, output);
        List<List<Integer>> res = new ArrayList();
        for(int i = 1; i<= output.size(); i++){
            res.add(output.get(i));
        }

        return res;

    }

    private HashMap inputHashmap(TreeNode root, HashMap<Integer, List<Integer>> output){
        if(root == null){
            return null;
        }


        if(output.containsKey(getHeight(root))){
            output.get(getHeight(root)).add(root.val);
        }else{
            ArrayList<Integer> levelNodes = new ArrayList();
            levelNodes.add(root.val);
            output.put(getHeight(root),levelNodes);
        }
        inputHashmap(root.left,output);
        root.left = null;
        inputHashmap(root.right,output);
        root.right = null;

        return output;

    }

    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }

}
