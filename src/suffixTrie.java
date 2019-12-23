public class suffixTrie {
	static final int d = 4;
	int a = 0;

	static class TrieNode {
		TrieNode[] children = new TrieNode[d];
		char key;
		int level;

		TrieNode() {
			for (int i = 0; i < d; i++)
				children[i] = null;
		}

		void insertSuffix(String s) {

			int i = 0;
			if (s.length() > 0 && i < d) {
				if (children[i] == null) {
					children[i] = new TrieNode();
					children[i].key = s.charAt(0);
					if (s.charAt(0) != '$')
						children[i].insertSuffix(s.substring(1));

				} else if (children[i] != null && children[i].key == s.charAt(0) && s.charAt(0) != '$') {
					children[i].insertSuffix(s.substring(1));
				} else {

					while (children[i] != null && i < d - 1) {
						if (children[i].key == s.charAt(0)) {
							children[i].insertSuffix(s.substring(1));
							return;
						}
						i++;

					}

					children[i] = new TrieNode();
					children[i].key = s.charAt(0);
					if (s.charAt(0) != '$')
						children[i].insertSuffix(s.substring(1));

				}

			}
		}
	};

	TrieNode root;

	suffixTrie(String s) {
		s += "$";
		root = new TrieNode();
		for (int i = 0; i < s.length(); i++) {

			root.insertSuffix(s.substring(i));
		}
	}

	void printInOrder(TrieNode curr, String s) {
		if (s.length() != 0 && s.charAt(s.length() - 1) == '$') {
			System.out.println(s);
			return;
		}
		for (int i = 0; i < d; i++) {
			if (curr.children[i] != null) {
				printInOrder(curr.children[i], s + curr.children[i].key);
			} else
				return;
		}

	}

}
