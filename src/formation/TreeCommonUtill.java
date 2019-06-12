package formation;

import java.util.LinkedList;
import java.util.Queue;

public class TreeCommonUtill {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int key) {
			data = key;
		}

		public int getData() {
			return data;
		}

		public Node getLeftNode() {
			return left;
		}

		public Node getRightNode() {
			return right;
		}

		public void setData(int data) {
			this.data = data;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	private static Node root = null;

	public static Node getRootNode() {
		return root;
	}

	public static void resetRoot() {
		root = null;
	}

	public static void insert(int key) {

		Queue<Node> q = new LinkedList<>();

		Node node = new Node(key);
		node.left = null;
		node.right = null;
		if (root == null) {
			root = node;
		} else {
			Node temp = root;
			q.add(temp);

			while (!q.isEmpty()) {

				Node t = q.poll();
				if (t.left == null) {
					t.left = node;
					break;
				} else {
					q.add(t.left);
				}
				if (t.right == null) {
					t.right = node;
					break;
				} else {
					q.add(t.right);
				}
			}
		}
	}

	public static void inorder(Node root) {

		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void preorder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void main(String[] args) {

		insert(1);
		insert(2);
		insert(3);
		insert(7);
		insert(6);
		insert(5);
		insert(4);
		// inorder(root);
		System.out.println();
		// preorder(root);
		System.out.println();
		// postorder(root);

	}

}
