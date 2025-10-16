/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the 
problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:

Input: head = [1,2,3,4]

Output: [2,1,4,3]

Explanation:



Example 2:

Input: head = []

Output: []

Example 3:

Input: head = [1]

Output: [1]

Example 4:

Input: head = [1,2,3]

Output: [2,1,3]
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        // Collect nodes into an array (preserves your original approach)
        List<ListNode> arr = new ArrayList<>();
        ListNode t = head;
        while (t != null) {
            arr.add(t);
            t = t.next;
        }

        int index = 1;
        ListNode newHead = null;
        ListNode endOfPreviousPair = null;

        while (index <= arr.size() - 1) {
            ListNode atIndex = arr.get(index);
            ListNode atIndexMinusOne = arr.get(index - 1);

            if (newHead == null) newHead = atIndex;

            // swap the pair
            atIndex.next = atIndexMinusOne;
            atIndexMinusOne.next = null;

            // connect previous pair to this swapped pair
            if (endOfPreviousPair != null) {
                endOfPreviousPair.next = atIndex;
            }

            // the end of this pair (after swap) is the former first node
            endOfPreviousPair = atIndexMinusOne;

            index += 2;
        }

        // If odd number of nodes, attach the last leftover node
        if (arr.size() % 2 != 0) {
            endOfPreviousPair.next = arr.get(arr.size() - 1);
        }

        return newHead;
        
    }
}