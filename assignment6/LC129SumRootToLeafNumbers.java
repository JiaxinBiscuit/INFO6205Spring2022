public class LC129SumRootToLeafNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }

        dfs(root,root.val);
        return sum;
    }

    private void dfs(TreeNode root,int curNum){

        if(root.left == null && root.right == null){
            sum += curNum;
            return;
        }
        if (root.left != null) {
            dfs(root.left, curNum*10+root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, curNum*10+root.right.val);
        }



    }

}
