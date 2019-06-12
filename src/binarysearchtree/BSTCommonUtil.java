package binarysearchtree;

public class BSTCommonUtil {

	public static class Node {

		int key;
		Node left;
		Node right;

		public Node(int key) {
			this.key = key;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

	static Node root;

	static int c = 0;

	private static void kthLargest(Node root, int k) {
		if (root == null || c > k)
			return;

		kthLargest(root.right, k);

		c++;

		if (c == k) {
			System.out.println("Kth Largest is: " + root.key);
			return;
		}

		kthLargest(root.left, k);
	}

	private static void insertRec(int key) {
		root = insert(root, key);
	}

	public static Node insert(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key) {
			root.left = insert(root.left, key);
		}

		else if (key > root.key) {
			root.right = insert(root.right, key);
		}

		return root;
	}

	public static void inOrderBST(Node root) {
		if (root != null) {
			inOrderBST(root.left);
			System.out.print(root.key + " ");
			inOrderBST(root.right);
		}
	}

	public static boolean search(Node root, int key) {

		if (root == null)
			return false;

		if (key == root.key)
			return true;
		else if (key < root.key)
			return search(root.left, key);
		else
			return search(root.right, key);
	}

	public static Node delete(Node root, int key) {

		if (root == null)
			return root;

		if (root.key == key) {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
		}

		if (root.key == key) {
			Node minNode = findRightmostMin(root);

			root.key = minNode.key;
			root.right = delete(root.right, minNode.key);
		}

		if (root.key < key) {
			root.right = delete(root.right, key);
		} else {
			root.left = delete(root.left, key);
		}

		return root;

	}

	private static Node findRightmostMin(Node root) {

		Node temp = root.right;
		while (temp != null && temp.left != null) {
			temp = temp.left;
		}

		return temp;
	}

	public static void main(String[] args) {
		insertRec(50);
		insertRec(30);
		insertRec(20);
		insertRec(40);
		insertRec(70);
		insertRec(60);
		insertRec(80);

		inOrderBST(root);
		System.out.println();
		System.out.println(search(root, 100));
		System.out.println(search(root, 70));
		System.out.println(search(root, -1));

		/*
		 * delete(root, 40); System.out.println(); inOrderBST(root); delete(root, 80);
		 * System.out.println(); inOrderBST(root); System.out.println(); delete(root,
		 * 50); inOrderBST(root);
		 */

		kthLargest(root, 1);

	}

}
