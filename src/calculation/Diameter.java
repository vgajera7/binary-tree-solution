package calculation;

import formation.TreeCommonUtill;
import formation.TreeCommonUtill.Node;

public class Diameter {

	static class Height {
		int height = 0;
	}

	public static int getDiameter(Node root, Height h) {

		if (root == null) {
			h.height = 0;
			return 0;
		}

		Height lh = new Height();
		Height rh = new Height();

		int ld = getDiameter(root.getLeftNode(), lh);
		int rd = getDiameter(root.getRightNode(), rh);

		int lheight = lh.height;
		int rheight = rh.height;

		h.height = Math.max(lheight, rheight) + 1;

		return Math.max(Math.max(ld, rd), lheight + rheight + 1);

	}

	public static void main(String[] args) {
		TreeCommonUtill.main(null);
		System.out.println(getDiameter(TreeCommonUtill.getRootNode(), new Height()));
	}

}
