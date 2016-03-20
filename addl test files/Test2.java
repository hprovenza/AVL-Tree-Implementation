public class Test2 {
	public static void main(String[] args) throws Exception {
		//BinarySearchTree<DataElement<String>> root = new BinarySearchTree<DataElement<String>>(new DataElement<String>("u", 1782168893));
		BinarySearchTree<DataElement<String>> root = new BinarySearchTree<DataElement<String>>(null);
		root.addRoot(new DataElement<String>("u", 1782168893));
		System.out.println(root.postorder());
		root.delete(new DataElement<String>("oopsie", 1782168893));
		System.out.println(root.postorder());
		root = root.insert(new DataElement<String>("A", -2138157432));
		System.out.println(root.postorder());
	}
}
