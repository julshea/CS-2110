


public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	@Override
	public boolean equals(Object o) {
		//To do
		
		if (o instanceof BinaryTree) {
			BinaryTree<?>t = (BinaryTree<?>)o;
			return this.root.equals(t.root);
		}
		
		return false;
	}

	public BinaryTree<T> deepCopy() {
	
		BinaryTree<T> BT = new BinaryTree<T>(root.deepCopy());
		
		return BT;

	}
	/**
	 * returns a new tree combining the calling tree (the "this" tree when writing the method) and 
	 * the parameter t as subtrees of a new BinaryTree with the parameter root as the root of the new tree.  
	 * The last parameter determines the order in which to attach the subtrees. 
	 *  If the parameter left is true, make "this" tree the new left subtree and BinaryTree t the new right subtree.
	 * @param newRoot
	 * @param t
	 * @param left
	 * @return
	 */
	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t, boolean left) {
		//To do
		
		BinaryTree<T> x = new BinaryTree<T>();
		
		if (left == true) {
			x.setRoot(newRoot.deepCopy());
			newRoot.setLeft(t.getRoot().deepCopy());
			newRoot.setRight(this.getRoot().deepCopy());

		} 
		
		else if(left != true){
			x.setRoot(newRoot.deepCopy());
			newRoot.setRight(t.getRoot().deepCopy());
			newRoot.setLeft(this.getRoot().deepCopy());
		}

		return x;
	}
	/**
	 *  returns (an int) the number of nodes in the tree
	 * @return
	 */
	public int size(){
		//To do
		
		if (this.getRoot() == null) {
			return 0;
		}
		
		else {
			return this.getRoot().size();
		}
	}
	/**
	 * The method will return an int that represents the height of the total tree.
	 * 
	 * @return
	 */
	public int height(){
		//To do
		
		if(root == null) {
			return 0;
		}
		
		int heightLeft = 0;
		
		if(root.getLeft()!=null) {
			heightLeft = this.root.getLeft().height();
		}
		
		int heightRight = 0;
		
		if(root.getRight()!=null) {
			heightRight = this.root.getRight().height();
		}
		
		if(heightLeft>=heightRight) {
			return heightLeft+1;
		}
		
		else {
			return heightRight+1;
		}
	}
	
	/**
	 *  returns true if the binary tree is full and complete and false otherwise.  
	 *  A full and complete tree is one in which all nodes other than leafs have two children and all leafs have the same height.
	 * @return
	 */
	public boolean full(){
		//To do
		
		if(root != null) {
			return root.full(); 	
		}
		
		return false;
	}
	/**
	 * takes the binary tree and changes the tree to its mirror
	 */
	public void mirror(){
		//To do
		
		if (this.getRoot() != null) {
			this.root.mirror();
		}
	}
	
	/**
	 * returns a string that represents the data held at each node starting with all the nodes of the left child 
	 * followed by the root then finally all the nodes of the right child
	 * @return
	 */
	public String inOrder(){
		//To do
		
		if (this.getRoot() != null) {
			return this.getRoot().inOrder();
		} 
		else {
			return null;
		}
	}

}