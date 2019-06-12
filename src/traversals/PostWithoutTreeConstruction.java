package traversals;

public class PostWithoutTreeConstruction {

	static int preIndex = 0;

	static void postorder(int in[], int pre[], int i, int j) {

		if (i > j)
			return;

		int inIndex = search(in, i, j, pre[preIndex++]);

		postorder(in, pre, i, inIndex - 1);
		postorder(in, pre, inIndex + 1, j);

		System.out.print(in[inIndex] + " ");

	}

	static int search(int in[], int i, int j, int data) {
		int k = 0;
		for (k = i; k < j; k++) {
			if (in[k] == data)
				return k;
		}
		return k;
	}

	public static void main(String[] args) {

		int[] in = new int[] { 4, 2, 5, 1, 3 };
		int[] pre = new int[] { 1, 2, 4, 5, 3 };

		postorder(in, pre, 0, 4);
	}

}
