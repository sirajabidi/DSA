
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


/*
 Given the head of a linked list, remove the nth node from the end of the list and return its head.
*/


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // only one node:
        if (head.next == null) {
            if (n==1) {
                head = null;
            }
            return head;
        }

        ListNode f = head;
        ListNode s = head;
        // move f , n times :
        for(int i=0; i<=n-1; i++) {
            if (f.next != null) {
                f = f.next;
            } else {
                f = null;
            }
        }

        if (f == null) {
            // This means we are deleting the head
            ListNode tbd = head;
            head = tbd.next;
            tbd = null;
            return head;
        }

        // Now move both f and s - until f reaches the last node
        while(f.next != null) {
            f = f.next;
            s = s.next;
        };

        ListNode tbd = s.next;
        s.next = tbd.next;
        tbd = null;
        return head;


    }
}