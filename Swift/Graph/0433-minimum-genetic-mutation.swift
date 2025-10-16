/*
A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one 
mutation is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to 
mutate from startGene to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.
*/

class Solution {
    func getNeighbors(gene: String, bank: [String]) -> [String] {
        let items: [Character] = ["A", "C", "G", "T"]
        
        var result: [String] = []
        
        for i in 0..<gene.count {
            
            let geneIndex = gene.index(gene.startIndex, offsetBy: i)
            let currentGeneChar = gene[geneIndex]
            
            for character in items {
                if (currentGeneChar == character) {
                    continue
                }
                
                var mutatedGene = gene
                mutatedGene.replaceSubrange(geneIndex...geneIndex, with: String(character))
                
                if bank.contains(mutatedGene) {
                    result.append(mutatedGene)
                }
            }
        }
        
        return result
    }


    func minMutation(_ startGene: String, _ endGene: String, _ bank: [String]) -> Int {
        if (startGene == endGene) {
		    return 0
        }

        if (bank.isEmpty) {
		    return -1
	    }

        var levels = 0	
        var queue: [[String]] = []
        queue.append([startGene])
        
        var explored: [String] = []
        
        while (!queue.isEmpty) {
            var current: [String] = queue.removeFirst()

            levels += 1
        
            var allNeighbors: [String] = []
            for i in current {
                var tmpNeighbors: [String] = getNeighbors(gene: i, bank: bank)
        
                allNeighbors.append(contentsOf: tmpNeighbors)
                explored.append(i)
            }

            print("allNeighbors: ", allNeighbors)
            
            var neighborsToQueue : [String] = []
            for n in allNeighbors {
                if (n == endGene) {
                    return levels
                }
                if (explored.contains(n)) {
                    continue
                }
                neighborsToQueue.append(n)
            }

            if (!neighborsToQueue.isEmpty) {
                queue.append(neighborsToQueue)
            }
        }
        
        return -1
    }
}