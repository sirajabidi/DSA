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
    func mergeTwoLists(_ list1: ListNode?, _ list2: ListNode?) -> ListNode? {
        guard let list1 = list1 else {
		return list2
        }
        
        guard let list2 = list2 else {
            return list1
        }
        
        var resultHead : ListNode? = nil

        var current: ListNode? = nil
        
        
        var p1: ListNode? = list1 
        var p2: ListNode? = list2
        
        if (p1!.val <= p2!.val) {
            resultHead = list1
            current = p1
            p1 = p1?.next
        } else {
            resultHead = list2
            current = p2
            p2  = p2?.next
        }

        while p1 != nil && p2 != nil {
            if (p1!.val <= p2!.val) {
                current?.next = p1
                current = p1
                p1 = p1?.next
            } else {
                current?.next = p2
                current = p2
                p2  = p2?.next
            }
        }

        if (p1 == nil && p2 == nil) {
            return resultHead
        } else if (p1 == nil) {
            current?.next = p2
        } else {
            current?.next = p1
        }
        
        return resultHead
    }
}