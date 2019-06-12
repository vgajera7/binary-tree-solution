package checkproperties;

import formation.TreeCommonUtill;
import formation.TreeCommonUtill.Node;

public class CheckHightBalance {

	static class Height {
		int height = 0;
	}

	public static boolean checkHeightBalance(Node root, Height h) {

		if (root == null) {
			h.height = 0;
			return true;
		}

		Height lheight = new Height();
		Height rheight = new Height();

		boolean lh = checkHeightBalance(root.getLeftNode(), lheight);
		boolean rh = checkHeightBalance(root.getRightNode(), rheight);

		int l = lheight.height;
		int r = rheight.height;
		h.height = Math.max(lheight.height, rheight.height) + 1;

		if ((l - r) >= 2 || (r - l) >= 2)
			return false;

		return lh && rh;

	}

	public static void main(String[] args) {
		TreeCommonUtill.main(null);
		System.out.println(checkHeightBalance(TreeCommonUtill.getRootNode(), new Height()));
	}

}
