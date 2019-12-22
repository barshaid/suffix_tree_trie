public class suffixTrie {
	static final int d = 4;

	static class TrieNode {
		TrieNode[] children = new TrieNode[d];;
		char key;

		TrieNode() {
			

			for (int i = 0; i < d; i++)
				children[i] = null;
		}
	};

	TrieNode root;

	suffixTrie(String s) {
		s += "$";
		root = new TrieNode();
		insert(s, 0, root);

	}

	void insert(String s, int i, TrieNode node) {
			 String suffix[]=new String[s.length()];
			
		   }
	
	
	TrieNode followPath(String s, TrieNode curr) {
		if(s.charAt(0)!=curr.key) 
			return null;
		curr=curr
		return curr;
	}

	void print() {

	}
}
