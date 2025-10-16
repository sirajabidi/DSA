/**
 * Definition for a Node.
 * public class Node {
 *     public var val: Int
 *     public var neighbors: [Node?]
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.neighbors = []
 *     }
 * }
 */

class Solution {
    func cloneGraph(_ node: Node?) -> Node? {
        if (node == nil) {
		return nil
        }
        
        var newRootNode: Node = Node(node!.val)
        
        var queue: [Node] = [node!]
        
        var nodeCache: [Node: Node] = Dictionary()
        nodeCache[node!] = newRootNode
        
        while(!queue.isEmpty) {
            var read: Node = queue.removeFirst()
            var write: Node = nodeCache[read]!
            
            for n in read.neighbors {
                guard let unwrappedNode = n else { continue }
                
                if let existingNode = nodeCache[unwrappedNode] {
                    write.neighbors.append(existingNode)
                } else {
                    var newNode = Node(unwrappedNode.val)
                    nodeCache[unwrappedNode] = newNode
                    write.neighbors.append(newNode)
                    queue.append(unwrappedNode)
                }
		}
	}
        return newRootNode
    }
}