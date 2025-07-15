
class Node {
    String chocolate;
    Node next;

    public Node(String chocolate) {
        this.chocolate = chocolate;
        this.next = null;
    }
}

public class ConveyorBelt {
    private Node head;

    public void insertAtBeginning(String chocolate) {
        Node newNode = new Node(chocolate);
        newNode.next = head;
        head = newNode;
        System.out.println("Manual Add: " + chocolate + " added at beginning.");
    }

    public void insertAtEnd(String chocolate) {
        Node newNode = new Node(chocolate);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Machine Add: " + chocolate + " added at end.");
    }


    public void display() {
        if (head == null) {
            System.out.println("The conveyor belt is empty.");
            return;
        }

        System.out.println("\n🍫 Current Conveyor Belt Chocolates:");
        Node current = head;
        while (current != null) {
            System.out.print(current.chocolate);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println("\n");
    }


    public static void main(String[] args) {
        ConveyorBelt belt = new ConveyorBelt();

        belt.insertAtEnd("DairyMilk");       
        belt.insertAtBeginning("Perk");     
        belt.insertAtEnd("KitKat");          
        belt.insertAtBeginning("5Star");    

        belt.display();                      
    }
}
