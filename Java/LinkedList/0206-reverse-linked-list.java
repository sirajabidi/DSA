/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

*/

import static java.lang.Math.negateExact;

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
    public ListNode reverseList(ListNode head) {
        // Zero node
        if (head == null) {
            return null;
        }

        // One node
        if (head.next == null) {
            return head;
        }

        // Two node
        if (head.next.next == null) {
            ListNode tmp = head.next;
            head.next.next = head;
            head.next = null;
            return tmp;
        }

        // More than 2 nodes:
        ListNode first = head;
        ListNode second = head.next;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = first;

            if (first == head) {
                first.next = null;
            }

            first = second;
            second = tmp;
        }

        return first;
    }
}