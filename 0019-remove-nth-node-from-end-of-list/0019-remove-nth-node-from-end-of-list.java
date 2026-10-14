/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * Removes the nth node from the end of the list.
     * Time Complexity: O(L), where L is the length of the list. We only traverse the list once.
     * Space Complexity: O(1). We use a constant number of extra pointers.
     * @param head The head of the linked list.
     * @param n The position from the end to remove (1-indexed).
     * @return The head of the modified list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. Create a dummy node to simplify edge cases (especially removing the head).
        // The dummy node's next points to the actual head.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize two pointers: 'fast' and 'slow'
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 2. Advance the 'fast' pointer 'n' steps ahead.
        // This creates the required gap of 'n' nodes.
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 3. Move both pointers until 'fast' reaches the last node (fast.next == null).
        // By the time 'fast' reaches the end, 'slow' will be positioned right before
        // the node to be removed (which is the nth node from the end).
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 4. Perform the removal operation.
        // The node to remove is 'slow.next'. We bypass it.
        slow.next = slow.next.next;

        // 5. Return the new head, which is dummy.next.
        // If the original head was removed, dummy.next will point to the new head.
        return dummy.next;
    }
}