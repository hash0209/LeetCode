class Trie {

    TrieNode root ;
    public Trie() {

        root = new TrieNode();
        
    }
    
    public void insert(String word) {

        TrieNode node =root ;

        char[] ch = word.toCharArray();

        for(int i=0; i < ch.length ; i++){
            int idx = ch[i]-'a';
            if(node.children[idx] == null){
                node.children[idx] = new TrieNode();
            }
            node =node.children[idx];

        }
        node.isEnd = true;
        
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        char[] ch = word.toCharArray();

        for(int i=0; i < ch.length ; i++){
            int idx = ch[i]-'a';
            if(node.children[idx]==null){
                return false;
            }
            node=node.children[idx];
        }
        return node.isEnd ;

    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] ch = prefix.toCharArray();

        for(int i=0; i < ch.length ; i++){
            int idx = ch[i]-'a';
            if(node.children[idx]==null){
                return false;
            }
            node=node.children[idx];
        }
        return true; 
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    Boolean isEnd = false;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */