package ss12.s6;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Thêm các nút vào cây như trong hình minh họa
        tree.insert(27);
        tree.insert(14);
        tree.insert(35);
        tree.insert(10);
        tree.insert(19);
        tree.insert(31);
        tree.insert(42);

        System.out.println("Post Order Traversal của cây BST:");
        tree.postOrder(); // Gọi duyệt Post Order
    }
}
