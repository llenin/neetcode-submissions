class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode curr){
        if(index == word.length() && curr.endOfWord){
            return true;
        }
        if(index >= word.length() || curr.children.isEmpty()){
            return false;
        }
        char c = word.charAt(index);
        if(c != '.'){
            if(curr.children.containsKey(c)){
                curr = curr.children.get(c);
                if(index == word.length() - 1 && curr.endOfWord){
                    return true;
                }
                return search(word, index + 1, curr);
            }
            return false;
        }
        for(char k : curr.children.keySet()){
            if(search(word, index + 1, curr.children.get(k))){
                return true;
            }
        }
        return false;
    }
}
