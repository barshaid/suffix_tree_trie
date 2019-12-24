
public class suffixTree {
	static final int d = 4;

	static class TreeNode {
		TreeNode[] children = new TreeNode[d];
		String key;

		TreeNode() {
			for (int i = 0; i < d; i++)
				children[i] = null;
		}

	};

	TreeNode root;

	suffixTree(suffixTrie t) {
		root = new TreeNode();

		toTree(t.root, root);
		consolidate(root);
	}

	void toTree(suffixTrie.TrieNode currTrie, TreeNode currTree) {
		for (int i = 0; i < d; i++) {
			if (currTrie.children[i] != null) {
				currTree.children[i] = new TreeNode();
				currTree.children[i].key = String.valueOf(currTrie.children[i].key);
				toTree(currTrie.children[i], currTree.children[i]);
			}
		}
	}

	void consolidate(TreeNode curr) {
		TreeNode temp = curr, parent;

		for (int i = 0; i < d - 1; i++) {
			if(temp.children[i].children[1]==null) {
				
				temp.children[i]=conNode(temp);
				consolidate(temp.children[i]);
			}else {
				temp=temp.children[0];
				i--;
			}
			if(temp.children[0].key.charAt(0)=='$') {
				return;
			}

		}
	}
	
	TreeNode conNode(TreeNode curr) {
		TreeNode temp = curr;
		String s="";
		while (temp.children[1] == null) {
			if(temp.children[0].key.charAt(0)=='$') {
				temp.key=s;
				return temp;
			}
			s+=temp.children[0].key;
			temp=temp.children[0];
		
		}
		temp.key=s;
		return temp;
	}
}
