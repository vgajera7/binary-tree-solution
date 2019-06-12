package deletenode;

import formation.TreeCommonUtill;
import formation.TreeCommonUtill.Node;

public class DeleteLeaf {

	static void deleteLeaf(Node root, Node prev, int x) {

		if (root == null)
			return;

		if (root.getLeftNode() == null && root.getRightNode() == null && root.getData() == x) {
			if (prev.getLeftNode() == root) {
				prev.setLeft(null);
			} else if (prev.getRightNode() == root) {
				prev.setRight(null);
			}
			return;
		}

		deleteLeaf(root.getLeftNode(), root, x);
		deleteLeaf(root.getRightNode(), root, x);

	}

	public static void main(String[] args) {
		TreeCommonUtill.resetRoot();
		TreeCommonUtill.insert(10);
		TreeCommonUtill.insert(8);
		TreeCommonUtill.insert(2);
		TreeCommonUtill.insert(3);
		TreeCommonUtill.insert(5);
		TreeCommonUtill.insert(7);

		deleteLeaf(TreeCommonUtill.getRootNode(), null, 7);
		TreeCommonUtill.preorder(TreeCommonUtill.getRootNode());
		deleteLeaf(TreeCommonUtill.getRootNode(), null, 3);
		System.out.println();
		TreeCommonUtill.preorder(TreeCommonUtill.getRootNode());
	}

}
