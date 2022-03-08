public class LC687LongestUnivaluePath {
    int maxLen = 0;

    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }

        dfs(root);
        return maxLen;
    }

    private int dfs(TreeNode root){
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftLen = 0;
        int rightLen = 0;
        if(root.left != null && root.val == root.left.val){
            leftLen = left+1;
        }
        if(root.right != null && root.val == root.right.val){
            rightLen = right+1;
        }
        maxLen = Math.max(maxLen,leftLen+rightLen);
        return Math.max(leftLen,rightLen);
    }
}
