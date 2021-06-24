package Trees.BinaryTree;


public class BinaryTree {
	TreeNode root;
	public TreeNode insert(int[] arr,TreeNode root, int i){
		// level-wise
		if(i<arr.length){
			TreeNode node = new TreeNode(arr[i]);
			root = node;
			node.left = insert(arr, root.left, 2*i+1);
			node.right = insert(arr, root.right, 2*i+2);
		}
		return root;
	}
	public static void display(TreeNode node){
		if(node==null) return;
		String str = node.val+"";
		str+= node.left==null?"":" L: "+node.left.val;
		str+= node.right==null?"":" R: "+node.right.val;
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
}
