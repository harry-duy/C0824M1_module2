package ss11.s5;

class Solution {
    private Queue queue;

    public Solution() {
        queue = new Queue();
    }

    public void enQueue(int data) {
        Node newNode = new Node(data);

        if (queue.front == null) {
            queue.front = newNode;
            queue.rear = newNode;
            newNode.link = queue.front; // Make it circular
        } else {
            queue.rear.link = newNode;
            queue.rear = newNode;
            queue.rear.link = queue.front; // Maintain circularity
        }
    }

    public int deQueue() {
        if (queue.front == null) {
            System.out.println("Queue is empty");
            return -1; // Or throw an exception, depending on desired behavior
        }

        int value;
        if (queue.front == queue.rear) { // Only one element
            value = queue.front.data;
            queue.front = null;
            queue.rear = null;
        } else {
            Node temp = queue.front;
            value = temp.data;
            queue.front = queue.front.link;
            queue.rear.link = queue.front; // Maintain circularity after removal
        }
        return value;
    }

    public void displayQueue() {
        if (queue.front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = queue.front;
        System.out.print("Elements in Circular Queue are: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.link;
        } while (temp != queue.front);
        System.out.println();
    }


    public static void main(String[] args) {
        Solution q = new Solution();

        q.enQueue(14);
        q.enQueue(22);
        q.enQueue(6);

        q.displayQueue();

        System.out.println("Deleted value = " + q.deQueue());
        System.out.println("Deleted value = " + q.deQueue());

        q.displayQueue();

        q.enQueue(9);
        q.enQueue(20);
        q.displayQueue();
    }
}
