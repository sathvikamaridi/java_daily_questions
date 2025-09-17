public class DoublyLinkedListPalindrome {
    Node head, tail;

    // Insert node at end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Check palindrome
    public boolean isPalindrome() {
        if (head == null) return true;

        Node left = head;
        Node right = tail;

        while (left != null && right != null && left != right && right.next != left) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.prev;
        }
        return true;
    }

    // Print DLL (for debugging)
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" ⇄ ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Test cases
    public static void main(String[] args) {
        // Test Case 1
        DoublyLinkedListPalindrome dll1 = new DoublyLinkedListPalindrome();
        dll1.insert(1);
        dll1.insert(2);
        dll1.insert(3);
        dll1.insert(2);
        dll1.insert(1);
        dll1.printList();
        System.out.println("Output: " + dll1.isPalindrome());

        // Test Case 2
        DoublyLinkedListPalindrome dll2 = new DoublyLinkedListPalindrome();
        dll2.insert(10);
        dll2.insert(20);
        dll2.insert(30);
        dll2.printList();
        System.out.println("Output: " + dll2.isPalindrome());

        // Test Case 3
        DoublyLinkedListPalindrome dll3 = new DoublyLinkedListPalindrome();
        dll3.insert(1);
        dll3.insert(2);
        dll3.insert(2);
        dll3.insert(1);
        dll3.printList();
        System.out.println("Output: " + dll3.isPalindrome());
    }
}
