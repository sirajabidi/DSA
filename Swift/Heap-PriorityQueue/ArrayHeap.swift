//
//  HeapBackedByArray.swift
//  Swift-DSA
//
//  Created by SirajAbidi on 9/27/25.
//

import Foundation

class ArrayHeap<T: Comparable> {
	private var items: [T?]
	private let queue = DispatchQueue(label: "arrayheap.queue", qos: .userInitiated, attributes: .concurrent)
	
	init() {
		self.items = []
	}
	
	// Write operations use barrier for exclusive access
	public func insert(_ item: T) {
		queue.async(flags: .barrier) {
			self.items.append(item)
		}
	}
	
	// Write operations use barrier for exclusive access
	public func popMin() -> T? {
		return queue.sync(flags: .barrier) {
			guard let first = self.items.first else {
				return nil
			}
			
			var min = first!
			var minIndex = 0

			for i in 1...self.items.count-1 {
				if (self.items[i]! < min) {
					min = self.items[i]!
					minIndex = i
				}
			}
			self.items.remove(at: minIndex)
			return min
		}
	}
	
	// Write operations use barrier for exclusive access
	public func popMax() -> T? {
		return queue.sync(flags: .barrier) {
			guard let first = self.items.first else {
				return nil
			}
			
			var max = first!
			var maxIndex = 0

			for i in 1...self.items.count-1 {
				if (self.items[i]! > max) {
					max = self.items[i]!
					maxIndex = i
				}
			}
			self.items.remove(at: maxIndex)
			return max
		}
	}
	
	// Read operations allow concurrent access (no barrier)
	public func peek() -> T? {
		return queue.sync {
			guard let first = self.items.first else {
				return nil
			}
			return first
		}
	}
}
