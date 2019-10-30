import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HW7Test {

	BinaryTree<Integer> t1, t2, t3, t4, t5, t6, t7, tt1, tt2;
	BinaryTreeNode<Integer> n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, nn1, nn2;
	
	@Before
	public void setUp(){
		t1 = new BinaryTree<Integer>();
		t1.setRoot(new BinaryTreeNode<Integer>(10));
		t1.getRoot().setLeft(new BinaryTreeNode<Integer>(20));
		t1.getRoot().setRight(new BinaryTreeNode<Integer>(30));
		t1.getRoot().getLeft().setRight(new BinaryTreeNode<Integer>(40));
		t1.getRoot().getLeft().setLeft(new BinaryTreeNode<Integer>(50));
		t1.getRoot().getRight().setLeft(new BinaryTreeNode<Integer>(60));
		t1.getRoot().getLeft().getLeft().setLeft(new BinaryTreeNode<Integer>(80));
		t1.getRoot().getRight().setRight(new BinaryTreeNode<Integer>(70));
		t1.getRoot().getLeft().getLeft().setRight(new BinaryTreeNode<Integer>(90));
		t1.getRoot().getLeft().getRight().setLeft(new BinaryTreeNode<Integer>(80));
		t1.getRoot().getLeft().getRight().setRight(new BinaryTreeNode<Integer>(90));
		t1.getRoot().getRight().getLeft().setLeft(new BinaryTreeNode<Integer>(80));
		t1.getRoot().getRight().getLeft().setRight(new BinaryTreeNode<Integer>(90));
		t1.getRoot().getRight().getRight().setLeft(new BinaryTreeNode<Integer>(80));
		t1.getRoot().getRight().getRight().setRight(new BinaryTreeNode<Integer>(90));
		
		t2 = new BinaryTree<Integer>();
		t2.setRoot(new BinaryTreeNode<Integer>(10));
		t2.getRoot().setLeft(new BinaryTreeNode<Integer>(20));
		t2.getRoot().setRight(new BinaryTreeNode<Integer>(30));
		t2.getRoot().getLeft().setRight(new BinaryTreeNode<Integer>(40));
		t2.getRoot().getLeft().setLeft(new BinaryTreeNode<Integer>(50));
		t2.getRoot().getRight().setLeft(new BinaryTreeNode<Integer>(60));
		t2.getRoot().getLeft().getLeft().setLeft(new BinaryTreeNode<Integer>(80));
		t2.getRoot().getRight().setRight(new BinaryTreeNode<Integer>(70));
		t2.getRoot().getLeft().getLeft().setRight(new BinaryTreeNode<Integer>(90));
		t2.getRoot().getLeft().getRight().setLeft(new BinaryTreeNode<Integer>(80));
		t2.getRoot().getLeft().getRight().setRight(new BinaryTreeNode<Integer>(90));
		t2.getRoot().getRight().getLeft().setLeft(new BinaryTreeNode<Integer>(80));
		t2.getRoot().getRight().getLeft().setRight(new BinaryTreeNode<Integer>(90));
		t2.getRoot().getRight().getRight().setLeft(new BinaryTreeNode<Integer>(80));
		t2.getRoot().getRight().getRight().setRight(new BinaryTreeNode<Integer>(90));
		
		t3 = new BinaryTree<Integer>();
		t3.setRoot(new BinaryTreeNode<Integer>(10));
		t3.getRoot().setLeft(new BinaryTreeNode<Integer>(20));
		t3.getRoot().setRight(new BinaryTreeNode<Integer>(30));
		t3.getRoot().getLeft().setRight(new BinaryTreeNode<Integer>(40));
		t3.getRoot().getLeft().setLeft(new BinaryTreeNode<Integer>(50));
		t3.getRoot().getRight().setLeft(new BinaryTreeNode<Integer>(60));
		t3.getRoot().getLeft().getLeft().setLeft(new BinaryTreeNode<Integer>(80));
		t3.getRoot().getRight().setRight(new BinaryTreeNode<Integer>(70));
		t3.getRoot().getLeft().getLeft().setRight(new BinaryTreeNode<Integer>(90));
		t3.getRoot().getLeft().getRight().setLeft(new BinaryTreeNode<Integer>(80));
		t3.getRoot().getLeft().getRight().setRight(new BinaryTreeNode<Integer>(90));
		t3.getRoot().getRight().getLeft().setLeft(new BinaryTreeNode<Integer>(80));
		t3.getRoot().getRight().getLeft().setRight(new BinaryTreeNode<Integer>(90));
		
		t4 = t1;
		t5 = t3;
		
		n1 = new BinaryTreeNode<Integer>(1);
		n2 = new BinaryTreeNode<Integer>(1);
		n3 = new BinaryTreeNode<Integer>(3);
		n4 = new BinaryTreeNode<Integer>(4);
		n5 = new BinaryTreeNode<Integer>(5);
		n6 = new BinaryTreeNode<Integer>(6);
		
		n3.setLeft(n4);
		n3.setRight(n5);
		
		n7 = new BinaryTreeNode<Integer>(1);
		n8 = new BinaryTreeNode<Integer>(2);
		n9 = new BinaryTreeNode<Integer>(3,n7,n8);
		t6 = new BinaryTree<Integer>(n9);
		
		n10 = new BinaryTreeNode<Integer>(5);
		n11 = new BinaryTreeNode<Integer>(6);
		n12 = new BinaryTreeNode<Integer>(7,n10,n11);
		t7 = new BinaryTree<Integer>(n12);
		
		nn1 = new BinaryTreeNode<Integer>(8,n9,n12);
		nn2 = new BinaryTreeNode<Integer>(8,n12,n9);
		
		tt1 = new BinaryTree<Integer>(nn1);
		tt2 = new BinaryTree<Integer>(nn2);
	}
	/*
	 * Tests equals method of binary tree node 
	 */
	@Test
	public void EqualsNode1Test() {
		assertTrue(n1.equals(n2));
	}
	
	@Test
	public void EqualsNode2Test() {
		assertFalse(n2.equals(n3));
	}
	/*
	 * Tests equals method of binary tree
	 */
	@Test
	public void EqualsTree1Test() {
		assertTrue(t2.equals(t1));
	}
	
	@Test
	public void EqualsTree2Test() {
		assertFalse(t2.equals(t3));
	}
	/*
	 * tests deep copy method of binary tree node
	 */
	@Test
	public void DeepCopyNode1Test() {
		assertTrue(n1.equals(n1.deepCopy()));
	}

	@Test
	public void DeepCopyNode2Test() {
		assertFalse(n3.deepCopy().equals(n2));
	}
	/*
	 * tests deep copy method of binary tree 
	 */

	@Test
	public void DeepCopyTree1Test() {
		assertTrue(t1.deepCopy().inOrder().equals("(80)(50)(90)(20)(80)(40)(90)(10)(80)(60)(90)(30)(80)(70)(90)"));
	}
	@Test
	public void DeepCopyTree2Test() {
		assertFalse(t3.deepCopy().inOrder().equals("(30)(70)(80)(20)(90)(40)(90)(10)(80)(60)(90)(80)(50)"));
	}

	/*
	 * tests combine method of binary tree
	 */
	@Test
	public void CombineTest1() {
		assertTrue(tt1.equals(t6.combine(nn1,t7,false)));
	}

	@Test
	public void CombineTest2() {
		assertFalse(tt2.equals(t6.combine(nn1,t7,true)));
	}
	
	/*
	 * tests size method of binary tree node
	 */
	@Test
	public void SizeNode1Test() {
		assertEquals(n1.size(), 1);
	}
	@Test
	public void SizeNode2Test() {
		assertNotSame(n2.size(), 2);
	}
	
	/*
	 * tests size method of binary tree
	 */
	@Test
	public void SizeTree1Test() {
		assertEquals(t1.size(), 15);
	}	@Test
	public void SizeTree2Test() {
		assertNotSame(t3.size(), 7);
	}
	
	/*
	 * tests height method of binary tree node
	 */
	@Test
	public void HeightNode1Test() {
		assertEquals(n1.height(), 1);
	}	
	@Test
	public void HeightNode2Test() {
		assertNotSame(n3.height(), 5);
	}
	/*
	 * tests height method of binary tree
	 */
	@Test
	public void HeightTree1Test() {
		assertEquals(t1.height(), 4);
	}	
	@Test
	public void HeightTree2Test() {
		assertNotSame(t3.height(), 2);
	}
	/*
	 * tests mirror method of binary tree node
	 */
	@Test
	public void MirrorNode1Test() {
		n4.mirror();
		assertTrue(n4.inOrder().equals("(4)"));
	}
	@Test
	public void MirrorNode2Test() {
		n5.mirror();
		assertFalse(n5.inOrder().equals("(7)"));

	}
	/*
	 * tests mirror method of binary tree
	 */
	@Test
	public void MirrorTree1Test() {
		t4.mirror();
		assertTrue(t4.inOrder().equals("(90)(70)(80)(30)(90)(60)(80)(10)(90)(40)(80)(20)(90)(50)(80)"));

	}
	@Test
	public void MirrorTree2Test() {
		t5.mirror();
		assertFalse(t5.inOrder().equals("(80)(60)(90)(30)(80)(90)(10)(40)(70)(20)(90)(50)(80)"));
	}
	/*
	 * tests full method of binary tree node
	 */
	@Test
	public void FullNode1Test() {
		assertTrue(n5.full());
	}
	@Test
	public void FullNode2Test() {
		assertTrue(n3.full());
		
	}
	/*
	 * tests full method of binary tree
	 */
	@Test
	public void FullTree1Test() {
		assertTrue(t1.full());
	}
	@Test
	public void FullTree2Test() {
		assertFalse(t3.full());
	}
	/*
	 * tests inorder method of binary tree
	 */
	@Test
	public void InorderTree1Test() {
		assertTrue(t1.inOrder().equals("(80)(50)(90)(20)(80)(40)(90)(10)(80)(60)(90)(30)(80)(70)(90)"));
	}
	@Test
	public void InorderTree2Test() {
		assertFalse(t3.inOrder().equals("(30)(50)(10)(80)(20)(40)(90)(90)(80)(60)(90)(80)(70)"));
	}
	/*
	 * tests inorder method of binary tree node
	 */
	@Test
	public void InorderNode1Test() {
		assertTrue(n1.inOrder().equals("(1)"));
	}
	@Test
	public void InorderNode2Test() {
		assertFalse(n3.inOrder().equals("(7)"));
	}
}
