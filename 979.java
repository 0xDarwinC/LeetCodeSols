/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int distributeCoins(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = distributeCoins(root.left);
        int r = distributeCoins(root.right);
        int moves = l+r;

        if(root.val == 0 && root.left != null && root.right != null){
            if(root.left.val > root.right.val){
                root.val++;
                root.right.val++;
                moves+=3;
            }
            else{
                root.val++;
                root.left.val++;
                moves+=3;
            }
        }
        else if (root.val == 0){
            if(!(root.left == null && root.right == null)){
                root.val++;
                if(root.left == null){
                    root.right.val--;
                }
                else{
                    root.left.val--;
                }
            moves++;
            }
        }
        while(root.val > 1 && root.left != null && root.right != null){
            if(root.left.val == 0){
                root.left.val++;
                moves++;
                root.val--;
            }
            else if(root.right.val == 0){
                root.right.val++;
                moves++;
                root.val--;
            }
        }
        return moves;
    }
}
