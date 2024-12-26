package ss10.s4;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // Thêm phần tử
        list.addFirst(10);
        list.addLast(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // In danh sách
        System.out.println("Danh sách sau khi thêm:");
        list.printList(); // Output: 10 -> 20 -> 30 -> 40 -> 50 -> null

        // Xóa phần tử tại vị trí
        list.remove(2);
        System.out.println("Danh sách sau khi xóa phần tử ở index 2:");
        list.printList(); // Output: 10 -> 20 -> 40 -> 50 -> null

        // Kiểm tra contains và indexOf
        System.out.println("Danh sách có chứa 40 không? " + list.contains(40)); // true
        System.out.println("Vị trí của phần tử 40: " + list.indexOf(40)); // 2

        // Sao chép danh sách
        MyLinkedList<Integer> clonedList = list.clone();
        System.out.println("Danh sách sao chép:");
        clonedList.printList();

        // Xóa toàn bộ danh sách
        list.clear();
        System.out.println("Danh sách sau khi xóa toàn bộ:");
        list.printList(); // Output: null
    }
}
