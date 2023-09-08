/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start

import java.util.Arrays;

class Trie {
    static int N = 100000;
    static int[][] trie = new int[N][26];
    static int[] count = new int[N];
    static int index = 0;

    public Trie() {
        for(int i=0; i<=index; i++){
            Arrays.fill(trie[i], 0);
        }

        index = 0;
        Arrays.fill(count, 0);
    }
    
    public void insert(String word) {
        int loc = 0;
        for(int i=0; i<word.length(); i++){
            int a = word.charAt(i) - 'a';
            if(trie[loc][a] == 0) trie[loc][a] = ++index;
            loc = trie[loc][a];
        }

        count[loc]++;
    }
    
    public boolean search(String word) {
        int loc = 0;
        for(int i=0; i<word.length(); i++){
            int a = word.charAt(i) - 'a';
            if(trie[loc][a] == 0) return false;
            loc = trie[loc][a];
        }

        return count[loc]>0;
    }
    
    public boolean startsWith(String prefix) {
        int loc = 0;
        for(int i=0; i<prefix.length(); i++){
            int a = prefix.charAt(i) - 'a';
            if(trie[loc][a] == 0) return false;
            loc = trie[loc][a];
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
// @lc code=end

class MTrie {
    static int N = 100000;
    static int[][] trie = new int[N][26];
    static int[] count = new int[N];
    static int index = 0;

    public MTrie() {
        for(int i=0; i<=index; i++){
            Arrays.fill(trie[i], 0);
        }
        index = 0;
        Arrays.fill(count, 0);
    }
    
    public void insert(String word) {
        int loc = 0;
        for(int i=0; i<word.length(); i++){
            int a = word.charAt(i) - 'a';
            if(trie[loc][a] == 0) trie[loc][a] = ++index;
            loc = trie[loc][a];
        }

        count[loc]++;
    }
    
    public boolean search(String word) {
        int loc = 0;
        for(int i=0; i<word.length(); i++){
            int a = word.charAt(i) - 'a';
            if(trie[loc][a] == 0) return false;
            loc = trie[loc][a];
        }

        return count[loc] != 0;
    }
    
    public boolean startsWith(String prefix) {
        int loc = 0;
        for(int i=0; i<prefix.length(); i++){
            int a = prefix.charAt(i) - 'a';
            if(trie[loc][a] == 0) return false;
            loc = trie[loc][a];
        }

        return true;
    }
}