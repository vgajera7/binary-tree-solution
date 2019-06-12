package checkproperties;

import formation.TreeCommonUtill;
import formation.TreeCommonUtill.Node;

public class SumParentHavingX {

	static int c = 0;

	static void sum(Node root, int x) {

		if (root == null)
			return;

		if (root.getLeftNode() != null && root.getLeftNode().getData() == x)
			c = c + root.getData();
		if (root.getRightNode() != null && root.getRightNode().getData() == x)
			c = c + root.getData();

		sum(root.getLeftNode(), x);
		sum(root.getRightNode(), x);

	}

	public static void main(String[] args) {
		TreeCommonUtill.resetRoot();
		TreeCommonUtill.insert(4);
		TreeCommonUtill.insert(2);
		TreeCommonUtill.insert(5);
		TreeCommonUtill.insert(7);
		TreeCommonUtill.insert(2);
		TreeCommonUtill.insert(2);
		TreeCommonUtill.insert(3);
		sum(TreeCommonUtill.getRootNode(), 2);

		System.out.println(c);

	}

}
