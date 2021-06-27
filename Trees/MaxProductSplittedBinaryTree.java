package Trees;

import Trees.BinaryTree.*;
public class MaxProductSplittedBinaryTree {
	long max;
    public int maxProduct(TreeNode root) {
        max = Integer.MIN_VALUE;
        long sum = sum(root);
        traverseAndFind(root,sum);
        // System.out.println(sum);
        return (int) max;
        
    }
    public void traverseAndFind(TreeNode root,long sum){
        if(root==null) return;
        //including in left subtree
        if(root.left!=null){
            traverseAndFind(root.left,sum);
        }if(root.right!=null){
            traverseAndFind(root.right,sum);
        }
        
        long s2 =  (sum(root))%((int)Math.pow(10,9)+7);
        long s1 = (sum-s2)%((int)Math.pow(10,9)+7);
         // System.out.println(s2);
        max = Math.max(max,s2*(s1));
       
    }
    public long sum(TreeNode root){
        if(root==null) return 0;
        return root.val+sum(root.left)+sum(root.right);
    }
}
