package ss12.s6;

// Lớp Node đại diện cho một nút trong cây
class Node {
    int data; // Giá trị của nút
    Node left, right; // Cây con trái và cây con phải

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

// Lớp Binary Search Tree
class BinarySearchTree {
    Node root;

    // Constructor khởi tạo cây rỗng
    BinarySearchTree() {
        root = null;
    }

    // Phương thức gọi duyệt Post Order
    void postOrder() {
        postOrderTraversal(root);
    }

    // Hàm đệ quy để duyệt Post Order
    void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // Bước 1: Duyệt cây con bên trái
        postOrderTraversal(node.left);

        // Bước 2: Duyệt cây con bên phải
        postOrderTraversal(node.right);

        // Bước 3: Truy cập nút gốc
        System.out.print(node.data + " ");
    }

    // Thêm các nút vào BST (giả sử không có giá trị trùng lặp)
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* Hàm đệ quy để thêm nút vào BST */
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }
}
