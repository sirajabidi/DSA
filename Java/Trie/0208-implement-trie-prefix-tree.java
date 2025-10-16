class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    public TrieNode() {
        for(int i=0; i<26; i++) {
            this.children[i] = null;
        }
        this.isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root = null;

    public Trie() {
      this.root = new TrieNode();  
    }
    
    public void insert(String word) {
        if (word == null) {
            return;
        }

        if (word.length() < 1) {
            return;
        }
    
        TrieNode lookupNode = this.root;

        int iterLimit = word.length()-1;
        for(int inputWordIndex=0; inputWordIndex<=iterLimit; inputWordIndex++) {
            int charIndex = word.charAt(inputWordIndex) - 'a';
            TrieNode nodeForChar = lookupNode.children[charIndex];
            if (nodeForChar == null) {
                lookupNode.children[charIndex] = new TrieNode();
            }
            lookupNode = lookupNode.children[charIndex];
        }
        lookupNode.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        if (word == null) {
            return false;
        }

        if (word.length() < 1) {
            return false;
        }
        
        TrieNode lookupNode = this.root;
        int iterLimit = word.length()-1;

        for(int inputWordIndex=0; inputWordIndex<=iterLimit; inputWordIndex++) {
            int charIndex = word.charAt(inputWordIndex) - 'a';
            TrieNode nodeForChar = lookupNode.children[charIndex];

            if (nodeForChar == null) {
                return false;
            } else {
                lookupNode = lookupNode.children[charIndex];
            }
        }

        if (lookupNode.isEndOfWord) {
            return true;
        }

        return false;

    }
    
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }

        if (prefix.length() < 1) {
            return false;
        }

        if (this.root == null) {
            return false;
        }

        TrieNode lookupNode = this.root;
        boolean isEmpty = Arrays.stream(lookupNode.children).allMatch(Objects::isNull);
        if (isEmpty) {
            return false;
        }

        int iterLimit = prefix.length()-1;
        for(int inputWordIndex=0; inputWordIndex<=iterLimit; inputWordIndex++) {
            int charIndex = prefix.charAt(inputWordIndex) - 'a';
            TrieNode nodeForChar = lookupNode.children[charIndex];

            if (nodeForChar == null) {
                return false;
            } else {
                lookupNode = lookupNode.children[charIndex];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */