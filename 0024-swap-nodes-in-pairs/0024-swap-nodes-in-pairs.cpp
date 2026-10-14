/**
 * Definition for singly-linked list.
 * struct ListNode {
 * int val;
 * ListNode *next;
 * ListNode() : val(0), next(nullptr) {}
 * ListNode(int x) : val(x), next(nullptr) {}
 * ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    /**
     * Swaps every two adjacent nodes in a linked list iteratively.
     * Time Complexity: O(N), where N is the number of nodes, as we visit each node once.
     * Space Complexity: O(1), as we only use a constant number of extra pointers.
     */
    ListNode* swapPairs(ListNode* head) {
        // 1. Create a dummy node. This simplifies the code by always providing a preceding node, 
        // especially when the original head needs to be swapped.
        ListNode dummy(0);
        dummy.next = head;
        
        // 'prev' pointer tracks the node *before* the current pair being swapped.
        ListNode* prev = &dummy;

        // The loop continues as long as there is at least a pair to swap (node1 and node2).
        while (prev->next != nullptr && prev->next->next != nullptr) {
            
            // Define the two nodes to be swapped
            ListNode* node1 = prev->next;
            ListNode* node2 = prev->next->next;
            
            // --- Perform the Swap ---
            
            // 2. Link the node before the pair (prev) to the second node (node2).
            // This makes node2 the new head of the pair.
            prev->next = node2;
            
            // 3. Link the second node (node2) to the first node (node1).
            node1->next = node2->next;
            
            // 4. Link the first node (node1) to the rest of the list 
            // (which is now correctly linked from node1's original next).
            node2->next = node1;
            
            // --- Move to the next pair ---
            
            // 5. Update 'prev' to the second node of the swapped pair (which is now node1).
            // This is the new node preceding the *next* potential pair.
            prev = node1; 
        }

        // The new head is dummy.next
        return dummy.next;
    }
};