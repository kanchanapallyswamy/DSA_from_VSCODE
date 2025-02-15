// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    // ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}



public class subtractTwoNumbers {
    // Helper function to create a linked list from an array of values
    public static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper function to print a linked list
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to act as a placeholder for the resulting linked list
        ListNode dummy = new ListNode(-999);
        ListNode tail = dummy;
        int borrow = 0;
    
        // Traverse through both linked lists
        while (l1 != null || l2 != null) {
            // Extract the values from the current nodes of l1 and l2, or set to 0 if null
            int d1 = (l1 != null) ? l1.val : 0;
            int d2 = (l2 != null) ? l2.val : 0;
    
            // Subtract along with any borrow from the previous iteration
            int diff = d1 - d2 - borrow;
    
            // If diff is negative, we need to borrow from the next digit
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
    
            // Create a new node for the current difference
            ListNode newNode = new ListNode(diff);
            tail.next = newNode;
            tail = newNode;
    
            // Move to the next nodes in both lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
    
        // Return the next of dummy node (the head of the resultant list)
        ListNode result = dummy.next;
        // Remove leading zeros
        while (result != null && result.val == 0) {
            result = result.next;
        }
        return result == null ? new ListNode(0) : result;
    }
    public static void main(String[] args) {
        // Create two linked lists from input arrays
        int[] num1 = {2, 4, 3}; // represents 342
        int[] num2 = {1, 3, 2}; // represents 231

        ListNode l1 = createLinkedList(num1);
        ListNode l2 = createLinkedList(num2);

        // Print the input linked lists
        System.out.print("Input List 1: ");
        printLinkedList(l1);
        System.out.print("Input List 2: ");
        printLinkedList(l2);

        // Subtract the two numbers
       
        ListNode result = subtractTwoNumbers(l1, l2);

        // Print the result linked list
        System.out.print("Result List: ");
        printLinkedList(result);
    }
}
