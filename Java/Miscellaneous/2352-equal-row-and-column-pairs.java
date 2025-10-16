class TrieNode {
    Map<Integer, TrieNode> members = null;
    int rowCount = 0;

    public TrieNode() {
        this.members = new HashMap<Integer, TrieNode>();
    }

    public void increaseRowCount() {
        this.rowCount++;
    }
}

class Trie {
    private TrieNode root = null;

    Trie() {
        this.root = new TrieNode();
    }

    public void insert(int[] array) {
        TrieNode current = this.root;
        for(int i : array) {
            if (current.members.containsKey(i)) {
                current = current.members.get(i);
            } else {
                TrieNode tmp = new TrieNode();
                current.members.put(i, tmp);
                current = tmp;
            }
        }
        current.increaseRowCount();
    }

    public int search(int[] array) {
        TrieNode current = this.root;
        for (int i : array) {
            if (!current.members.containsKey(i)) {
                return current.rowCount;
            }
            current = current.members.get(i);   
        }
        return current.rowCount;
    }
}

class Solution {
    public int equalPairs(int[][] grid) {
        if ((grid.length == 1) && (grid[0].length == 1)) {
            return 1;
        }

        if (grid.length < 2) {
            return 0;
        }

        if (grid[0].length < 2) {
            return 0;
        }

        Trie trie = new Trie();
        int pairs = 0;

        for (int [] row: grid) {
            trie.insert(row);
        }

        for (int col=0; col<=(grid[0].length)-1; col++) {
            int [] tmpCol = new int[grid.length];

            for (int row=0; row<=(grid.length)-1; row++) {
                tmpCol[row] = grid[row][col];
            }

            int rowCount = trie.search(tmpCol);
            pairs = pairs + rowCount;
        }

        return pairs;
    }
}