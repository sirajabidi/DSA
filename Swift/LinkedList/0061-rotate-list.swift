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
 *     public var val: Int
 *     public var next: ListNode?
 *     public init() { self.val = 0; self.next = nil; }
 *     public init(_ val: Int) { self.val = val; self.next = nil; }
 *     public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
 * }
 */
class Solution {
    func rotateRight(_ head: ListNode?, _ k: Int) -> ListNode? {
        guard let head = head else {
		return nil
        }
        
        if (k == 0) {
            return head
        }
        
        var p: ListNode? = head
        
        var nodes = 0
        while p != nil {
            nodes += 1
            p = p?.next
        }
        
        p = nil
        
        var trueK = (k % nodes)
        
        if (trueK == 0) {
            return head
        }
        
        var p1 : ListNode? = head
        var p2 : ListNode? = head
        
        for i in 1...trueK {
            p2 = p2?.next
        }
        
        while let c = p2?.next {
            p1 = p1?.next
            p2 = p2?.next
        }
        
        var newHead: ListNode = p1!.next!

        p1?.next = nil
        p1 = nil

        p2?.next = head
        p2 = nil

        return newHead
    }
}