package traversals;

import java.util.Stack;

import formation.TreeCommonUtill;
import formation.TreeCommonUtill.Node;

public class SpiralTraversal {

	static void traverse(Node root) {

		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		if (root != null)
			s1.push(root);

		while (!s1.empty() || !s2.empty()) {

			while (!s1.empty()) {
				Node temp = s1.peek();
				s1.pop();

				System.out.print(temp.getData() + " ");

				if (temp.getRightNode() != null)
					s2.push(temp.getRightNode());

				if (temp.getLeftNode() != null)
					s2.push(temp.getLeftNode());
			}

			while (!s2.empty()) {
				Node temp = s2.peek();
				s2.pop();

				System.out.print(temp.getData() + " ");

				if (temp.getLeftNode() != null)
					s1.push(temp.getLeftNode());

				if (temp.getRightNode() != null)
					s1.push(temp.getRightNode());
			}
		}

	}

	public static void main(String[] args) {
		TreeCommonUtill.main(null);
		traverse(TreeCommonUtill.getRootNode());
	}

}
