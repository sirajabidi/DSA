/*
Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
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
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }

        ListNode last = head;
        int count = 1;
        while(last.next != null) {
            last = last.next;
            count++;
        }

        int totalIterations = 0;
        if (k <= count) {
            totalIterations = count - k;
        } else {
           int remainder = k % count;
           totalIterations = count - remainder;
        }

        int counter = 0;
        while(counter < totalIterations) {
            ListNode tmp = head.next;
            last.next = head;
            head.next = null;
            last = head;
            head = tmp;
            tmp = null;
            counter++;
        }
        return head;
    }
}