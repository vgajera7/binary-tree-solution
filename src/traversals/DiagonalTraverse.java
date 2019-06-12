package traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import formation.TreeCommonUtill;
import formation.TreeCommonUtill.Node;

public class DiagonalTraverse {

	static void fillMap(Node root, Map<Integer, ArrayList<Node>> map, int d) {

		if (root == null)
			return;

		if (map.containsKey(d)) {
			map.get(d).add(root);
		} else {
			ArrayList<Node> list = new ArrayList<>();
			list.add(root);
			map.put(d, list);
		}

		fillMap(root.getLeftNode(), map, d - 1);
		fillMap(root.getRightNode(), map, d);

	}

	static void printFromMap(Map<Integer, ArrayList<Node>> map) {

		for (Map.Entry<Integer, ArrayList<Node>> m : map.entrySet()) {

			int key = m.getKey();
			ArrayList<Node> list = m.getValue();
			System.out.print(key + "--->");
			for (Node n : list) {

				System.out.print(n.getData() + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Map<Integer, ArrayList<Node>> map = new HashMap<>();
		TreeCommonUtill.main(null);
		fillMap(TreeCommonUtill.getRootNode(), map, 0);
		printFromMap(map);

	}

}
