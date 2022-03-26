public class Question3 {
    int inLeft;
    int preLeft;

    public TreeNode constructBinaryTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        return  constructBinaryTree(root,preorder, inorder,1, 0);
    }

    public TreeNode constructBinaryTree(TreeNode root, int[] preorder, int[] inorder, int preLeft, int inLeft){
        inLeft = findIndex(preorder,preLeft,inorder);
        root.left = constructBinaryTree(root, preorder, inorder, preLeft++, inLeft);

        inLeft = findIndex(preorder,preLeft,inorder);
        root.right = constructBinaryTree(root, preorder, inorder, preLeft++, inLeft);

        return root;
    }

    public int findIndex(int[] preorder, int preLeft, int[] inorder){
        for(int i = 0; i<inorder.length; i++) {
            if (inorder[i] == preorder[preLeft]) {
                return i;
            }
        }
        return -1;
    }


}
