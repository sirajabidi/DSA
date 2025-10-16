/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Only one node :
        if (head.next == null) {
            head = null;
            return null;
        }

        ListNode slow = null;
        ListNode fast = head;
        
        while(fast.next != null) {
            /* if fast can move by 2 then move fast by 2 and slow by 1.
               But fast can only move by 1 then move fast by 1 and slow will still move by 1
               So in case of even number of nodes it will reach exactly at the last node by hopping 2

            */
            if (fast.next.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }

            if (slow == null) {
                slow = head;
            } else {
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return head;
    }
}