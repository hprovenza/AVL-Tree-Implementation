public class DeleteTest {
	public static void main(String[] args) throws Exception {
		BinarySearchTree<DataElement<String>> root = new BinarySearchTree<DataElement<String>>(
				new DataElement<String>("c", 2));
		System.out.println(root.postorder());
		root = root.insert(new DataElement<String>("b", 1));
		System.out.println(root.postorder());
		root = root.insert(new DataElement<String>("a", 0));
		System.out.println(root.postorder());
		root.delete(new DataElement<String>("c", 2));
		System.out.println(root.postorder());


		root = new BinarySearchTree<DataElement<String>>(new DataElement<String>("c", 2));
		System.out.println(root.postorder());
		root = root.insert(new DataElement<String>("a", 0));
		System.out.println(root.postorder());
		root = root.insert(new DataElement<String>("b", 1));
		System.out.println(root.postorder());
		root = root.insert(new DataElement<String>("d", 3));
		System.out.println(root.postorder());
		root.delete(new DataElement<String>("a", 0));
		System.out.println(root.postorder());

		root = new BinarySearchTree<DataElement<String>>(new DataElement<String>("a", 0));
		root = root.insert(new DataElement<String>("b", 1));
		root = root.insert(new DataElement<String>("c", 2));
		System.out.println(root.postorder());

		root = new BinarySearchTree<DataElement<String>>(new DataElement<String>("a", 0));
		root = root.insert(new DataElement<String>("c", 2));
		root = root.insert(new DataElement<String>("b", 1));
		System.out.println(root.postorder());
	}
}