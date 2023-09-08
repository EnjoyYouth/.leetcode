/*
 * @lc app=leetcode.cn id=636 lang=java
 *
 * [636] 函数的独占时间
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution {

    String START = "start";
    String END = "end";
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        Deque<String> que  = new ArrayDeque<>();
        for(int i=0; i<logs.size(); i++){
            if(i==0){
                que.addLast(logs.get(i));
                continue;
            }
            String l = logs.get(i);
            String p = logs.get(i-1);
            String[] now = l.split(":");
            String[] pre = p.split(":");
            if(now[1].equals(END)){
                res[Integer.valueOf(now[0])] += Integer.valueOf(now[2]) - Integer.valueOf(pre[2]) + (pre[1].equals(END) ? 0 : 1);
                que.pollLast();
            }else{
                if(pre[1].equals(START)){
                    res[Integer.valueOf(pre[0])] += Integer.valueOf(now[2]) - Integer.valueOf(pre[2]);
                }else{
                    if(!que.isEmpty()){
                        String[] top = que.peekLast().split(":");
                        res[Integer.valueOf(top[0])] += Integer.valueOf(now[2]) - Integer.valueOf(pre[2]) -1;
                    }
                }

                que.offerLast(l);
            }

            // System.out.println(Arrays.toString(res));
        }

        return res;
    }
}
// @lc code=end

