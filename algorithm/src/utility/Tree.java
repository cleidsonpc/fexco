package utility;

public class Tree {

	public Tree(Integer id) {
		this.id = id;
	}

	private Integer id;
	private Tree leftNode;
	private Tree rightNode;

	public Integer getId() {
		return id;
	}

	public Tree getLeftNode() {
		return leftNode;
	}

	public Tree getRightNode() {
		return rightNode;
	}

	public void setNodes(Tree leftNode, Tree rightNode) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.id);
	}
	
	public static Tree getBinaryTree() {

		Tree n1 = new Tree(1);
		Tree n2 = new Tree(2);
		Tree n3 = new Tree(3);
		Tree n4 = new Tree(4);
		Tree n5 = new Tree(5);
		Tree n6 = new Tree(6);
		Tree n7 = new Tree(7);
		Tree n8 = new Tree(8);
		Tree n9 = new Tree(9);
		Tree n10 = new Tree(10);
		Tree n11 = new Tree(11);
		Tree n12 = new Tree(12);
		Tree n13 = new Tree(13);
		Tree n14 = new Tree(14);
		Tree n15 = new Tree(15);
		Tree n16 = new Tree(16);
		Tree n17 = new Tree(17);
		Tree n18 = new Tree(18);
		Tree n19 = new Tree(19);
		Tree n20 = new Tree(20);

		n1.setNodes(n2, n3);
		n2.setNodes(n8, n9);
		n3.setNodes(n4, n5);
		n8.setNodes(n11, n12);
		n9.setNodes(n13, null);
		n4.setNodes(n6, null);
		n5.setNodes(n7, n10);
		n11.setNodes(n14, null);
		n12.setNodes(n19, null);
		n13.setNodes(n20, null);
		n6.setNodes(n15, null);
		n7.setNodes(n17, n18);
		n10.setNodes(n16, null);
		
		return n1;
	}
}