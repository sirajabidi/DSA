//
//  Compression.swift
//  Swift-DSA
//
//  Created by SirajAbidi on 9/19/25.
//

import Foundation

/*
 Given an array of characters chars, compress it using the following algorithm:

 Begin with an empty string s. For each group of consecutive repeating characters in chars:

 If the group's length is 1, append the character to s.
 Otherwise, append the character followed by the group's length.
 The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

 After you are done modifying the input array, return the new length of the array.

 You must write an algorithm that uses only constant extra space.

 Note: The characters in the array beyond the returned length do not matter and should be ignored.

  

 Example 1:

 Input: chars = ["a","a","b","b","c","c","c"]
 Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 Example 2:

 Input: chars = ["a"]
 Output: Return 1, and the first character of the input array should be: ["a"]
 Explanation: The only group is "a", which remains uncompressed since it's a single character.
 Example 3:

 Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 */




/* INSIGHT:
   we are solving this problem by 2 pointers. Read pointer and write pointer.
   Read Ptr basically increment and count the characters in the group and when a
   new group starts writePtr just write where it is at and increments itself by 1
 
 */
func compress(_ chars: inout [Character]) -> Int {
	if (chars.isEmpty) {
		return 0
	}
	
	if (chars.count == 1) {
		return 1
	}
	
	var r = 0
	var w = 0
	var currentCharFreq = 1
	
	while r <= chars.count - 1 {
		var currentChar: Character = chars[r]
		var nextToCurrentChar: Character? = (r+1 > chars.count-1) ? nil : chars[r+1]

		if (currentChar == nextToCurrentChar) {
			currentCharFreq += 1
			r = r + 1
		} else {
			chars[w] = currentChar
			w += 1
			
			if (currentCharFreq == 1) {
				// Don't do anything
			} else {
				var freqStr = String(currentCharFreq)
				for i in 0...freqStr.count-1 {
					let index = freqStr.index(freqStr.startIndex, offsetBy: i)
					var f = freqStr[index]
					chars[w] = f
					w += 1
				}
			}

			// Point "r" to new group and reset currentCharFreq to 1 reflecting that we are starting a new group
			r += 1
			currentCharFreq = 1
		}
	}
	return w
}
