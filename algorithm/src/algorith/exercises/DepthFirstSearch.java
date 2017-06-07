package algorith.exercises;

import utility.Tree;

public class DepthFirstSearch {

	public static void main(String[] args) {
		Tree binaryTree = Tree.getBinaryTree();
		
		System.out.println("Will search in all binary-tree.");
		depthSearch(binaryTree, null);
		
		System.out.println("Will search until the node 19.");
		depthSearch(binaryTree, 19);
	}

	private static boolean cont = true;
	private static void depthSearch(final Tree binaryTree, Integer target) {
		System.out.println(binaryTree);
		
		if(binaryTree.getId().equals(target)) {
			cont = false;
		}
		
		if(cont && binaryTree.getLeftNode() != null) {
			depthSearch(binaryTree.getLeftNode(), target);
		} 
		
		if(cont && binaryTree.getRightNode() != null) {
			depthSearch(binaryTree.getRightNode(), target);
		}
		
	}

}