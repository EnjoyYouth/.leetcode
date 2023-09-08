/*
 * @lc app=leetcode.cn id=1268 lang=java
 *
 * [1268] 搜索推荐系统
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Queue<String> que = new PriorityQueue<>();

        for(int i=1; i<=searchWord.length(); i++){
            String s = searchWord.substring(0, i);

            for(String product : products){
                if(product.startsWith(s)){
                    que.offer(product);
                }
            }

            List<String> tmp = new ArrayList<>();
            for(int j=0; j<3 && !que.isEmpty() ; j++){
                tmp.add(que.poll());
            }
            res.add(tmp);
            que.clear();
        }

        return res;
    }
}
// @lc code=end

