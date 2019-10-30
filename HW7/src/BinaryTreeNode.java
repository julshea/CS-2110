


public class BinaryTreeNode<T> {
	
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;
	
	public BinaryTreeNode(){
		this(null,null,null);
	}
	
	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}
	
	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}
	
	public int size(){
		int size = 0; //the size of the tree
		
		
		if(left != null){
			size = size + left.size();
		}
		if(right != null){
			size = size + right.size();
		}
		return size + 1; //+1 accounts for the current node
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	public BinaryTreeNode<T> deepCopy(){
		//To do
		BinaryTreeNode<T> b = new BinaryTreeNode<T>();
		if((this.getData() != null));{

			b.setData(this.getData());
		}
		if(this.getLeft() != null && this.getRight() == null) {
			b.setLeft(this.getLeft().deepCopy()); 
		}

		if(this.getLeft() == null&& this.getRight() != null) {
			b.setRight(this.getRight().deepCopy());
		}

		if(this.getLeft()!= null && this.getRight() != null)	{
			b.setLeft(this.getLeft().deepCopy());
			b.setRight(this.getRight().deepCopy());
		}

		return b;

	}
	/**
	 * two binary tree nodes are equal if their data are equal and their subtrees are equal
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object o){
		//To do
		
		if (o instanceof BinaryTreeNode) {
			BinaryTreeNode x = (BinaryTreeNode) o;
			if ((left == null) && (right != null)) {
				return this.getRight().equals(x.getRight()) && this.getData().equals(x.getData());
			}
			
			else if ((left != null) && (right == null)) {
				return this.getLeft().equals(x.getLeft()) && this.getData().equals(x.getData());
			}
			
			else if ((left == null) && (right == null)) {
				return this.getData().equals(x.getData());
			}
			
			else {
				return 	this.getLeft().equals(x.getLeft()) && 
						this.getRight().equals(x.getRight()) &&
						this.getData().equals(x.getData());
			}
		}
		
		return false;
	}
	
	/**
	 *  The method will return an int that represents the height of the total tree.  
	 *  In the case of the node class, this should return the height of the subtree with this current node as the "root"
	 * @return
	 */
	public int height(){
		//To do
		
		int leftHeight = 0;			
		int rightHeight = 0;
		
		if (this.left == null && this.right == null) {		
			return 1;
		}
		
		if (this.left != null) {							
			leftHeight = left.height();
		}
		
		if (this.right != null) {							
			rightHeight = right.height();
		}
		
		return 1 + Math.max(leftHeight, rightHeight);	
	}

	public boolean full(){
		//To do
		
		if(data!=null) {
			
			if(left == null && right == null) {
				return true;
			}
			
			if(left != null && right!=null) {
				return right.full() && left.full() && right.height()==left.height();
			}
		}
		
		return false;
	}
	/**
	 * takes the binary tree and changes the tree to its mirror
	 */
	public void mirror(){
		
		
		BinaryTreeNode<T> newTree = new BinaryTreeNode<T>();
		if(this.left == null && this.right != null) {
			newTree = this.getRight().deepCopy();
			this.setLeft(newTree);
			this.setRight(null);
			this.left.mirror();
		}
		else if(this.left != null && this.right == null) {
			newTree = this.getLeft().deepCopy();
			this.setLeft(null);
			this.setRight(newTree);
			this.right.mirror();
		}
		else if(this.left != null && this.right != null) {
			newTree = this.getLeft().deepCopy();
			this.setLeft(this.getRight().deepCopy());
			this.setRight(newTree);
			this.right.mirror();
			this.left.mirror();
		}
	}
	/**
	 * returns a string that represents the data held at each node starting with all the nodes of the left child 
	 * followed by the root then finally all the nodes of the right child
	 * @return
	 */
	public String inOrder(){
		
		
		String x = "";

		if (this.left != null) {
			x = x + this.getLeft().inOrder();
		}

		x = x + "(" + this.getData() + ")";

		if (this.right != null) {
			x = x + this.getRight().inOrder();
		}

		return x;
	}
}