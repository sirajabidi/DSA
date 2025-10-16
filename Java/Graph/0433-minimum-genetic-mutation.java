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
    private List<String> generateNeighbors(Set<String>geneBank , Set<String> visited, List<String> current) {

        String[] geneSet = {"A", "C", "G", "T"};

        List<String> result = new ArrayList<>();
        for (String gene : current) {
            for(int i = 0; i < gene.length(); i++) {
                String prev = gene.substring(0, i);
                String next = gene.substring(i+1, gene.length());
                for (String g : geneSet) {
                    String newGene = prev + g + next;
                    if (newGene.equals(gene)) {
                        continue;
                    }
                    if (visited.contains(newGene)) {
                        continue;
                    }
                    if (geneBank.contains(newGene)) {
                        result.add(newGene);
                    }
                    visited.add(newGene);
                }
            }
        }
        return result;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (bank.length == 0) {
            return -1;
        }
        if (startGene.equals(endGene)) {
            return 0;
        }

        HashSet<String> genesBank = new HashSet<>();
        for (String gene : bank) {
            genesBank.add(gene);
        }

        LinkedList<List<String>> queue = new LinkedList<>();
        List<String> tmp = new ArrayList<>();
        tmp.add(startGene);
        queue.add(tmp);

        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {
            List<String> current = queue.poll();

            if (current.contains(endGene)) {
                return mutations;
            }

            List<String> neighborsGene = generateNeighbors(genesBank, visited, current);
            if (!neighborsGene.isEmpty()) {
                mutations++;
                queue.add(neighborsGene);
            }
        }
        return -1;
    }
}