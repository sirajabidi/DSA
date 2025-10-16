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
 *     public var val: Int
 *     public var next: ListNode?
 *     public init() { self.val = 0; self.next = nil; }
 *     public init(_ val: Int) { self.val = val; self.next = nil; }
 *     public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
 * }
 */
class Solution {
    func swapPairs(_ head: ListNode?) -> ListNode? {
        guard let head = head else {
            return head
        }
        
        if (head.next == nil) {
            return head
        }

        var resultHead: ListNode? = head.next
        
        var p1: ListNode? = head
        var p2: ListNode? = head.next
        
        while p1 != nil || p2 != nil {
            var tmp: ListNode? = p2?.next
            var originalP1 = p1
            p2?.next = p1
            p1?.next = nil
            
            p1 = tmp
            p2 = p1?.next

            originalP1?.next = (p2 != nil) ? p2 : p1
        }
        
        return resultHead
    }
}