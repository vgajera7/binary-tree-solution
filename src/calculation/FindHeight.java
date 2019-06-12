package calculation;

import formation.TreeCommonUtill;
import formation.TreeCommonUtill.Node;

public class FindHeight {

	public static int getHeight(Node root) {

		if (root == null)
			return 0;

		int l = getHeight(root.getLeftNode());
		int r = getHeight(root.getRightNode());

		return Math.max(l, r) + 1;
	}

	public static void main(String[] args) {
		TreeCommonUtill.main(null);
		System.out.println(getHeight(TreeCommonUtill.getRootNode()));
	}

}
