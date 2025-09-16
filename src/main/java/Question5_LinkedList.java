public class Question5_LinkedList {

    static class ListNode {
        String value;
        ListNode next;

        ListNode(String value) {
            this.value = value;
        }
    }


    public static ListNode rotateRight(ListNode head, int n) {

        // Validation
        if (head == null || head.next == null || n == 0) {
            return head;
        }


        // Length and tail
        ListNode tail = head;
        int length = 1;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make the linkedlist circular
        tail.next = head;

        // Find new tail
        ListNode newTail = head;
        for (int i = 0; i < length - n % length - 1; i++) {
            newTail = newTail.next;
        }
        // Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    // public function to print the linkedlist
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode("ID_A01");
        head.next = new ListNode("ID_A02");
        head.next.next = new ListNode("ID_A03");
        head.next.next.next = new ListNode("ID_A04");
        head.next.next.next.next = new ListNode("ID_A05");
        head.next.next.next.next.next = new ListNode("ID_A06");

        System.out.println("Original list:");
        printLinkedList(head);

        ListNode rotated = rotateRight(head, 2);
        System.out.println("Rotated by 2:");
        printLinkedList(rotated);
    }
}
