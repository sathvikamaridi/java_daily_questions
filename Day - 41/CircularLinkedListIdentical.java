class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedListIdentical {

    // Function to check if two circular linked lists are identical
    public static boolean areIdentical(Node head1, Node head2) {
        if (head1 == null && head2 == null) return true;
        if (head1 == null || head2 == null) return false;

        // Convert both lists to string sequences
        String str1 = toCircularString(head1);
        String str2 = toCircularString(head2);

        // Length check
        if (str1.length() != str2.length()) return false;

        // Check rotation using concatenation trick
        return (str1 + str1).contains(str2);
    }

    // Convert circular linked list to string representation
    private static String toCircularString(Node head) {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        do {
            sb.append(temp.data).append(" ");
            temp = temp.next;
        } while (temp != head);
        return sb.toString().trim();
    }

    // Utility to create circular linked list from array
    public static Node createCircularList(String[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        temp.next = head; // Make circular
        return head;
    }

    public static void main(String[] args) {
        // Test Case 1
        Node list1 = createCircularList(new String[]{"1", "2", "3", "4"});
        Node list2 = createCircularList(new String[]{"3", "4", "1", "2"});
        System.out.println(areIdentical(list1, list2) ? "Identical" : "Not Identical");

        // Test Case 2
        Node list3 = createCircularList(new String[]{"A", "B", "C", "D"});
        Node list4 = createCircularList(new String[]{"B", "C", "A", "D"});
        System.out.println(areIdentical(list3, list4) ? "Identical" : "Not Identical");
    }
}
