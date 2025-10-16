//
//  GraphNode.swift
//  Swift-DSA
//
//  Created by SirajAbidi on 9/21/25.
//

import Foundation

public class Node : Hashable, Equatable {
	
	public static func == (lhs: Node, rhs: Node) -> Bool {
		return lhs.val == rhs.val
	}
	
	public func hash(into hasher: inout Hasher) {
		hasher.combine(val)
	}
	
	public var val: Int
	public var neighbors: [Node?]
	public init(_ val: Int) {
		self.val = val
		self.neighbors = []
	}
}



