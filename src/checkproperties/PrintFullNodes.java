package checkproperties;

import formation.TreeCommonUtill;
import formation.TreeCommonUtill.Node;

public class PrintFullNodes {

	static void printFullNodes(Node root) {

		if (root == null)
			return;

		if (root.getLeftNode() != null && root.getRightNode() != null) {
			System.out.print(root.getData() + " ");
		}

		printFullNodes(root.getLeftNode());
		printFullNodes(root.getRightNode());
	}

	public static void main(String[] args) {
		TreeCommonUtill.resetRoot();
		TreeCommonUtill.insert(10);
		TreeCommonUtill.insert(8);
		TreeCommonUtill.insert(2);
		TreeCommonUtill.insert(3);
		TreeCommonUtill.insert(5);
		TreeCommonUtill.insert(7);

		printFullNodes(TreeCommonUtill.getRootNode());

	}

}
