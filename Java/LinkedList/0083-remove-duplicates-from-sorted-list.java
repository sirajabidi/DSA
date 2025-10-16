/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,1,2]
Output: [1,2]
*/
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = p1.next;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                p1 = p2;
                p2 = p1.next;
            } else {
                p1.next = p2.next;
                // optional: clear reference for GC
                p2.next = null;
                p2 = p1.next;
            }
        }
        return head;
    }
}