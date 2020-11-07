public class LowestCommonAncestor{

	public static Node lca(Node root, String v1, String v2) {     
		if(root == null){
			return root;
		}
		if(root.val.compareTo(v1) <0 && root.val.compareTo(v2) < 0){
			return lca(root.right, v1, v2);
		}else if(root.val.compareTo(v1) >0 && root.val.compareTo(v2)>0){
			return lca(root.left, v1, v2);
		}
		return root;
	}
	public static void main(String[] args){
		String elements = "5,3,8,2,,4,6,7";
		String v1 = "7", v2 = "3";
		Node node = TreeBuilder.buildBST(elements);
		Node lcaNode = lca(node,v1,v2);
		if(lcaNode != null){
			System.out.println("Lowest Common Ancesstor of V1 " + v1 + " and V2 " + v2 + " is " + lcaNode.val);
		}
	}
}