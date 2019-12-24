
public class main {

	public static void main(String[] args) {
		String s = "senseses";
		suffixTrie t = new suffixTrie(s);
		
		t.printInOrder(t.root, "");
		System.out.println();
		
		suffixTree u = new suffixTree(t);
		
		System.out.println();
		 System.out.println(t.root.children[0].key);
		 System.out.println(t.root.children[0].children[0].key);
		 System.out.println(t.root.children[0].children[0].children[0].key);
		 System.out.println(t.root.children[0].children[0].children[0].children[0].key);
		 
		System.out.println();
		 System.out.println(u.root.children[0].key);
		 System.out.println(u.root.children[0].children[0].key);
		 System.out.println(u.root.children[0].children[0].children[0].key);
		
	}
}
