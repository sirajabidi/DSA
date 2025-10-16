/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
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
    private void _helper(ListNode l1, ListNode l2, ListNode current, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return;    
            }
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
            return;
        }

        int l1Value = 0;
        if (l1 != null) {
            l1Value = l1.val;
        }

        int l2Value = 0;
        if (l2 != null) {
            l2Value = l2.val;
        }

        int sum = l1Value + l2Value + carry;

        ListNode newNnode = null;
        int modulus = sum % 10;
        if (current.val < 0) {
            current.val = modulus;
            newNnode = current;
        } else {
            newNnode = new ListNode(modulus);
            current.next = newNnode;
        }

        int quotient = sum / 10;

        ListNode newL1 = null;
        if (l1 != null) {
            newL1 = l1.next;
        }

        ListNode newL2 = null;
        if (l2 != null) {
            newL2 = l2.next;
        }
        _helper(newL1, newL2, newNnode, quotient);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(-1);
        _helper(l1, l2, result, 0);
        return result;
    }
}