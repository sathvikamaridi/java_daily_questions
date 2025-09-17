import java.util.*;

public class InterleaveQueue {
    public static void interleaveQueue(Queue<Integer> queue) {
        if (queue.size() % 2 != 0) {
            System.out.println("Queue must have even number of elements!");
            return;
        }

        int halfSize = queue.size() / 2;
        Stack<Integer> stack = new Stack<>();

        // Push first half into stack
        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.remove());
        }

        // Enqueue back elements of stack (reversed first half)
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        interleaveQueue(q1);
        System.out.println("Output: " + q1);
    }
}