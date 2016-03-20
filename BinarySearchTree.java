// Hannah Provenza
// Data Structures
// 2 November 2015
// Programming Assignment #2
// This file implements an AVL tree.

import java.lang.Exception;
import java.lang.Math;

public class BinarySearchTree<E extends Comparable<E>> {

	private E data;
	private BinarySearchTree<E> l;
	private BinarySearchTree<E> r;
	private BinarySearchTree<E> parent;

	public BinarySearchTree(){
		this.data = null;
		this.l = null;
		this.r = null;
		this.parent = null;
	}

	public BinarySearchTree(E e){
		this.data = e;
		this.l = null;
		this.r = null;
		this.parent = null;
	}
	/**
	 * This algorithm checks if the node has a left child.
	 * O(1) This algorithm performs the same number of operations regardless of input.
	 * @return a boolean, true if the node has a left child and false otherwise.
	 */
	public boolean hasLeft() {
		if(this.l != null){
			return true;
		}
		return false;
	}
	/**
	 * This algorithm checks if the node has a right child.
	 * O(1) This algorithm performs the same number of operations regardless of input
	 * @return a boolean, true if the node has a left child and false otherwise.
	 */
	public boolean hasRight() {
		if(this.r != null){
			return true;
		}
		return false;
	}
	/**
	 * Checks if this is a leaf.
	 * O(1) This algorithm performs the same number of operations regardless of input.
	 * @return a boolean, true if this has no children and false otherwise.
	 */
	public boolean isLeaf() {
		if(this.hasRight() || this.hasLeft()){
			return false;
		}
		return true;
	}
	/**
	 * Checks if the tree this is empty.
	 * O(1) This algorithm performs the same number of operations regardless of input.
	 * @return a boolean, true if this is null and false otherwise.
	 */
	public boolean isEmpty() {
		if (this.data == null){
			return true;
		}
		return false;
	}
	/**
	 * Checks if the node this is the root of its tree.
	 * O(1) This algorithm performs the same number of operations regardless of input.
	 * @return a boolean, true if this has a parent node and false otherwise.
	 */
	public boolean isRoot() {
		if (!this.hasParent()){
			return true;
		}
		return false;
	}
	/**
	 * Checks if this is the left child of its parent node
	 * O(1) This algorithm performs the same number of operations regardless of input.
	 * @return a boolean, true if this is the left child of its parent node and false otherwise.
	 */
	public boolean isLeftChild() {
		if (this.hasParent()){
			if(this == this.parent.l){
				return true;
			}
		}

		return false;
	}
	/**
	 * Checks if this is the right child of its parent node
	 * O(1) This algorithm performs the same number of operations regardless of input.
	 * @return true if this is the right child of its parent node and false otherwise.
	 */
	public boolean isRightChild() {
		if (this.hasParent()){
			if(this == this.parent.r){
				return true;
			}		
		}
		return false;
	}
	/**
	 * Checks if the node this has a parent.
	 * O(1) This algorithm performs the same number of operations regardless of input.
	 * @return true if this has a parent node and false otherwise.
	 */
	public boolean hasParent() {
		if(this.parent != null){
			return true;
		}
		return false;
	}
	/**
	 * Finds a node containing the data e
	 * O(logn)  This algorithm traverses the height of the tree in the worst case; the height of the tree is logn where n is the number of nodes (because the tree is balanced)
	 * @param e the value of the data to be searched for
	 * @return the node containing e if it exists and throws an error otherwise
	 */
	public BinarySearchTree<E> findNode(E e) {
		if (this == null || this.data.compareTo(e) == 0){
			return this;
		}
		if (e.compareTo(this.data) < 0){
			return this.l.findNode(e);
		} else {
			return this.r.findNode(e);
		}
	}
	/**
	 * Finds the minimum node of the tree this.
	 * O(logn)  This algorithm traverses the height of the tree in the worst case; the height of the tree is logn where n is the number of nodes (because the tree is balanced)
	 * @return the BST node of the tree this with the minimum value.
	 */
	public BinarySearchTree<E> findMin() {
		BinarySearchTree<E> x = this;
		while (x.l != null){
			x = x.l;
		}
		return x;
	}
	/**
	 * Finds the successor of the node this in the tree containing this.
	 * O(logn)  This algorithm traverses the height of the tree twice in the worst case; the height of the tree is logn where n is the number of nodes (because the tree is balanced)
	 * @return the successor node
	 */
	public BinarySearchTree<E> findSuccessor() {
		if (this.r != null){
			return this.r.findMin();
		}
		else {
			BinarySearchTree<E> x = this;
			BinarySearchTree<E> w = this.parent;
			while (w != null && x == w.r){
				x = w;
				w = w.parent;
			}
			return w;
		}
	}
	/**
	 * Creates a tree containing the data e
	 * O(1) This algorithm performs the same number of operations regardless of input.
	 * @param e a data element to be contained in the node
	 * @return a node containing the data E
	 */
	public BinarySearchTree<E> addRoot(E e) {
		try{
			if(this.data == null){
				this.data = e;
				return this;
			} else {
				throw new Exception();
			}
		} catch(Exception ex){
			System.out.println("Tried to add root to a tree that isn't null!");
			return this;
		}
	}
	/**
	 * Creates a node containing the data e and inserts it into the tree this.
	 * O(logn) This algorithm traverses the height of the tree in the worst case to find the place where the node should be inserted.
	 * @param e data to be inserted to the tree
	 * @return the root of the tree.
	 */
	public BinarySearchTree<E> insert(E e) {
			BinarySearchTree<E> v = new BinarySearchTree<E>(null);
			try{
			if(this.isEmpty()){
				this.addRoot(e);
				return this;
			} else {

				BinarySearchTree<E> w = this;
				while (w != null){
					v = w;
					if (e.compareTo(w.data) < 0){
						w = w.l;
					} else if (e.compareTo(w.data)> 0){
						w = w.r;
					} else if (e.compareTo(w.data) == 0){
						throw new Exception();
					}
				}
			}
		} catch(Exception ex){
			System.out.println("The node containing" + e + " already exists in the tree!");
			return this;
		}
		BinarySearchTree<E> z = new BinarySearchTree<E>(e);
		z.parent = v;
		if (v == null){
			this.addRoot(e);
			return this;
		} else {
			if (e.compareTo(v.data) < 0){
				v.l = z;
			} else {
				v.r = z;
			}
		}
		while(!z.isRoot()){
			z.balance();
			z = z.parent;
		}	
		z.balance();
		BinarySearchTree<E> after = this;
		while (!after.isRoot()){
			after = after.parent;
		}
		return after;
	}
	/**
	 * Finds a node containing the data e
	 * O(logn)  This algorithm traverses the height of the tree in the worst case; the height of the tree is logn where n is the number of nodes (because the tree is balanced)
	 * @param e the value of the data to be searched for
	 * @return the node containing e if it exists and throws an error otherwise
	 */
	public BinarySearchTree<E> search(E e) {
		return this.findNode(e);
	}
	/**
	 * Deletes a node from the binary search tree
	 * O(logn)  This algorithm traverses the height of the tree in the worst case searching for the node to be deleted and the node's successor. The height of the tree is logn where n is the number of nodes (because the tree is balanced)
	 * @param e the value of the node to be deleted
	 * @return the root of the tree if the node was found and throws an exception otherwise.
	 */
	public BinarySearchTree<E> delete(E e) throws Exception {
		try{
			BinarySearchTree<E> z = this.findNode(e);
			// Case 1: node has no children.
			if (!z.hasLeft() && !z.hasRight()){
				if(z.isLeftChild()){
					z.parent.l = null;
				} else if(z.isRightChild()){
					z.parent.r = null;
				} else {
					z.data = null;
				}
				return this;
			// Case 2: node has exactly one child.
			} else if (z.hasLeft() ^ z.hasRight()){
				if (z.isLeftChild()){
					if (z.hasLeft()){
						z.parent.l = z.l;
						z.l.parent = z.parent;
					} else if(z.hasRight()){
						z.parent.l = z.r;
						z.r.parent = z.parent;
					}
				} else if(z.isRightChild()){
					if (z.hasLeft()){
						z.parent.r = z.l;
						z.l.parent = z.parent;
					} else if(z.hasRight()){
						z.parent.r = z.r;
						z.r.parent = z.parent;
					}			
				} else {
					if (z.hasLeft()){
						z.l.parent = null;
						z.l.balance();
						return z.l;
					} else {
						z.r.parent = null;
						z.r.balance();
						return z.r;
					}
				}
			} else {
				// Case 3:  Node has two children.
				BinarySearchTree<E> x = z.findSuccessor();
				BinarySearchTree<E> y = new BinarySearchTree<E>(x.data);
				y.parent = z.parent;
				y.l = z.l;
				if (y.l != null){
					y.l.parent = y;
				}
				y.r = z.r;
				if (y.r != null){
					y.r.parent = y;
				}
				if (x.isLeftChild()){
					y.parent.l = y;
				} else if (x.isRightChild()){
					y.parent.r = y;
				}
				delete(z.findSuccessor().data);
			}
			return z;
		} catch(NullPointerException npe){
			System.out.println("Node " + e.toString() + " not found.");
			return this;
		}
	}
	/**
	 * Finds the total number of nodes in the tree this.
	 * O(n)  This algorithm visits all n nodes of the tree in order to count them.
	 * @return the number of nodes in the tree this.
	 */
	public int size() {
		if (this.isLeaf()){
			return 1;
		}
		if (this.r == null){
			return 1 + this.l.size();
		}
		if (this.l == null){
			return 1 + this.r.size();
		}
		return 1 + this.r.size() + this.l.size();
	}
	/**
	 * Finds the balance factor of the node this.
	 * O(n) because it calls height, which is O(n)
	 * @return an integer that represents the balance factor
	 */
	public int balanceFactor() {
		int a, b;
		if (this.l == null){
			a = -1;
		} else {
			a = this.l.height();
		}
		if (this.r == null){
			b = -1;
		} else {
			b = this.r.height();
		}
		return a - b;
	}
	/**
	 * finds the height of the node this
	 * O(n) This algorithm must visit every node of the tree to determine the height of the node.
	 * @return an integer representing the height of the node this.
	 */
	public int height(){
		if(this.isLeaf()){
			return 0;
		}
		int a, b;
		if (this.l == null){
			a = 0;
		} else {
			a = this.l.height();
		}
		if (this.r == null){
			b = 0;
		} else {
			b = this.r.height();
		}
		int h = max(a, b);
		return 1 + h;
	}
	/**
	 * Finds the maximum of two integers a and b.
	 * O(1)  This algorithm takes fixed size inputs and executes the same number of operations each time it is called.
	 * @param a an integer
	 * @param b an integer
	 * @return the greater of a and b
	 */
	private int max(int a, int b){
		if (a >= b){
			return a;
		} else {
			return b;
		}
	}
	/**
	 * Finds the depth of the node this in the tree containing this.
	 * O(logn)  In the worst case this algorithm goes from a leaf node up to the root; the height of the tree is log n
	 * @return an integer representing the depth of the node this
	 */
	public int depth(){
		if (this.isRoot()){
			return 0;
		} else {
			return 1 + this.parent.depth();
		}
	}
	/**
	 * Determines which kind of balancing needs to be performed on the node this.
	 * O(n) in the worst case because this method calls balanceFactor() which is O(n)
	 */
	public void balance(){

		if (this.balanceFactor() == -2){
			if (this.r.balanceFactor() > 0){
				this.r.rightRotation();
				this.leftRotation();
			} else {
				this.leftRotation();
			}
		} else if (this.balanceFactor() == 2){
			if (this.l.balanceFactor() < 0){
				this.l.leftRotation();
				this.rightRotation();
			} else {
				this.rightRotation();
			}
		}
	}
	/**
	 * executes a right rotation around the node this
	 * O(1) This algorithm executes the same number of operations regardless of the size of the tree.
	 */
	public void rightRotation() {
		BinarySearchTree<E> u = this.parent;
		BinarySearchTree<E> w = this.l;
		BinarySearchTree<E> x = w.r;
		w.r = this;
		this.parent = w;
		this.l = x;
		if(x != null){
			x.parent = this;
		}
		if (u != null){
			if (u.l == this){
				u.l = w;
			} else {
				u.r = w;
			}
		}
		w.parent = u;
	}
	/**
	 * executes a left rotation around the node this
	 * O(1) This algorithm executes the same number of operations regardless of the size of the tree.
	 */
	public void leftRotation(){
		BinarySearchTree<E> u = this.parent;
		BinarySearchTree<E> v = this.r;
		BinarySearchTree<E> x = v.l;
		this.r = x;
		if (x != null){
			x.parent = this;
		}
		v.l = this;
		this.parent  = v;
		if (u != null){
			if (u.r == this){
				u.r = v;
			} else {
				u.l = v;
			}
		}
		v.parent = u;
	}
	/**
	 * returns a string containing all the nodes in this in postorder
	 * O(n) this algorithm must visit every node in order to report their values.
	 */
	public String postorder() {
		if(this.data == null){
			return null;
		} else {
			String output = "";
			if (this.l != null){
				output = output + this.l.postorder();
			}
			if (this.r != null){
				output = output + this.r.postorder();
			}
			output = output + this.data.toString();
			return output;
		}
	}
}
