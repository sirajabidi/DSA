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
 *     public var val: Int
 *     public var next: ListNode?
 *     public init() { self.val = 0; self.next = nil; }
 *     public init(_ val: Int) { self.val = val; self.next = nil; }
 *     public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next; }
 * }
 */
class Solution {
    func addTwoNumbers(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        guard let l1 = l1 else {
		return l2
        }
        
        guard let l2 = l2 else {
            return l1
        }
        
        

        var ptr1: ListNode? = l1
        var ptr2 : ListNode? = l2
        
        
        var resultHead : ListNode? = nil
        var ptr3 : ListNode? = nil
        
        var carry = 0
        while ptr1 != nil || ptr2 != nil {
            var sum = (ptr1?.val ?? 0) + (ptr2?.val ?? 0) + carry
            
            var q = 0
            var r = 0

            if (sum >= 10) {
                q = sum / 10
                r = sum % 10
                
            } else {
                r = sum
            }
            
            var newNode: ListNode = ListNode(r)
            carry = q
            
            
            if (ptr3 != nil) {
                ptr3!.next = newNode
                ptr3 = newNode
            } else {
                ptr3 = newNode
                resultHead = ptr3
            }

            ptr1 = ptr1?.next
            ptr2 = ptr2?.next
        }

        if (carry > 0) {
            var newNode: ListNode = ListNode(carry)
            ptr3?.next = newNode
        }
        
        return resultHead
    }
}