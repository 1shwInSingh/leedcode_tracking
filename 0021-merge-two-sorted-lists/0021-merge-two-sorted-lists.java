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
     * Merges two sorted linked lists into one new sorted list iteratively.
     * Time Complexity: O(N + M), where N and M are the lengths of list1 and list2, as we visit each node once.
     * Space Complexity: O(1) extra space (not counting the space for the new list nodes, 
     * which is O(N + M) if new nodes were created, but here we splice existing nodes).
     * * @param list1 The head of the first sorted list.
     * @param list2 The head of the second sorted list.
     * @return The head of the merged sorted linked list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. Create a dummy node. This simplifies edge cases and gives us a guaranteed starting point
        // for the resulting list. The actual merged list will be at dummy.next.
        ListNode dummy = new ListNode(0);
        
        // 'current' pointer will always point to the last node of the merged list.
        ListNode current = dummy;

        // Pointers for list1 and list2
        ListNode p1 = list1;
        ListNode p2 = list2;

        // 2. Loop while both lists still have nodes to process.
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                // p1's value is smaller (or equal). Append p1 to the merged list.
                current.next = p1;
                p1 = p1.next; // Advance p1
            } else {
                // p2's value is smaller. Append p2 to the merged list.
                current.next = p2;
                p2 = p2.next; // Advance p2
            }
            // Move the 'current' pointer to the newly appended node.
            current = current.next;
        }

        // 3. Attach the remaining nodes.
        // Once one list is exhausted, the other list (if not null) is already sorted, 
        // so we can append the rest of it directly.
        if (p1 != null) {
            current.next = p1;
        } else if (p2 != null) {
            current.next = p2;
        }

        // 4. The merged list starts at dummy.next.
        return dummy.next;
    }
}