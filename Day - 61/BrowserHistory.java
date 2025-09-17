public class BrowserHistory {
    private Node current;

    // Visit a new page
    public void visit(String url) {
        Node newNode = new Node(url);

        if (current != null) {
            // clear forward history
            current.next = null;
            newNode.prev = current;
            current.next = newNode;
        }

        current = newNode;
        System.out.println("Visited: " + url);
    }

    // Move back one step
    public void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Moved Back to: " + current.url);
        } else {
            System.out.println("No previous page to go back to.");
        }
    }

    // Move forward one step
    public void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Moved Forward to: " + current.url);
        } else {
            System.out.println("No forward page to go to.");
        }
    }

    // Show current page
    public void showCurrent() {
        if (current != null) {
            System.out.println("Current Page: " + current.url);
        } else {
            System.out.println("No page visited yet.");
        }
    }

    // Test cases
    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();

        browser.visit("google.com");
        browser.visit("youtube.com");
        browser.back();
        browser.showCurrent();
    }
}
