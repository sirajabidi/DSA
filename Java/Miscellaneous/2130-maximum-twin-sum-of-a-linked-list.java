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
    public int pairSum(ListNode head) {
        ListNode itr = head;
        List<ListNode> cache = new ArrayList<ListNode>();

        while(itr != null) {
            cache.add(itr);
            itr = itr.next;
        }

        int f = 0;
        int b = cache.size()-1;
        int maxSum = 0;
        while(f<b) {
            int twinSum = cache.get(f).val + cache.get(b).val;
            maxSum = Math.max(twinSum, maxSum);
            f++;
            b--;
        }

        return maxSum;        
    }
}