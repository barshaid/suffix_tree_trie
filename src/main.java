
public class main {

	public static void main(String[] args) {
		String s = "senseses";
		suffixTrie t = new suffixTrie(s);
		// System.out.println(t.root.children[1].children[1].key);
		t.printInOrder(t.root, "");

	}
}
