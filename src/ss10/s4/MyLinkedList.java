package ss10.s4;

public class MyLinkedList<E> {
    private Node<E> head;
    private int numNodes;

    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    // Thêm phần tử vào cuối danh sách
    public void add(E element) {
        if (head == null) {
            head = new Node<>(element);
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(element);
        }
        numNodes++;
    }

    // Thêm phần tử vào đầu danh sách
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    // Thêm phần tử vào cuối danh sách
    public void addLast(E element) {
        add(element);
    }

    // Xóa phần tử tại vị trí index
    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }

        Node<E> current = head;
        if (index == 0) {
            head = head.next;
        } else {
            Node<E> previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
        }
        numNodes--;
        return current.getData();
    }

    // Xóa phần tử cụ thể
    public boolean remove(Object o) {
        Node<E> current = head;
        Node<E> previous = null;

        while (current != null) {
            if (current.getData().equals(o)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                numNodes--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    // Lấy phần tử tại vị trí index
    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.getData();
    }

    // Trả về kích thước danh sách
    public int size() {
        return numNodes;
    }

    // Kiểm tra danh sách có chứa phần tử không
    public boolean contains(E o) {
        Node<E> current = head;
        while (current != null) {
            if (current.getData().equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Trả về vị trí của phần tử trong danh sách
    public int indexOf(E o) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.getData().equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // Sao chép danh sách
    public MyLinkedList<E> clone() {
        MyLinkedList<E> cloneList = new MyLinkedList<>();
        Node<E> current = head;
        while (current != null) {
            cloneList.add(current.getData());
            current = current.next;
        }
        return cloneList;
    }

    // Xóa toàn bộ danh sách
    public void clear() {
        head = null;
        numNodes = 0;
    }

    // In danh sách liên kết
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
