

public class LC1325DeleteLeavesWithAGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null){
            return root;
        }

        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);
        if(root.val == target && right == null && left == null){
            root = null;
            return root;
        }

        root.left = left;
        root.right = right;
        return root;

    }


}
