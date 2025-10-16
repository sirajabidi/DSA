//
//  PrefixTree.swift
//  Swift-DSA
//
//  Created by SirajAbidi on 9/21/25.
//

import Foundation

class PrefixNode {
	var items : [PrefixNode?]
	var endOfWord : Bool
	
	init() {
		self.items = Array(repeating: nil, count: 26)
		self.endOfWord = false
	}
}

class PrefixTree {
	var root: PrefixNode?
	
	init() {
		self.root = PrefixNode()
	}
	
	func insert(_ word: String) {
		var current = self.root
		
		for w in word {
			let index: Int = Int(w.asciiValue!) - 97
			if (current!.items[index] != nil) {
				current = current!.items[index]!
			} else {
				current!.items[index] = PrefixNode()
			}
		}
		current?.endOfWord = true
	}
	
	func search(_ word: String) -> Bool {
		return false
	}
}
