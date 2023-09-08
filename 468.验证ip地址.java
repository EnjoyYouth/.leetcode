/*
 * @lc app=leetcode.cn id=468 lang=java
 *
 * [468] 验证IP地址
 */

// @lc code=start
class Solution {
    public String validIPAddress(String queryIP) {
        if(v4(queryIP)){
            return "IPv4";
        }
        if(v6(queryIP)){
            return "IPv6";
        }

        return "Neither";
    }

    boolean v4(String ip){
        String[] nums = ip.split("\\.", -1);

        if(nums.length != 4){
            return false;
        }

        for(String num : nums){
            int tmp = 0;
            if(num.length()>3 || num.length()<1){
                return false;
            }

            for(int i=0; i<num.length(); i++){
                char ch = num.charAt(i);
                if(i==0 && ch=='0' && num.length()!=1){
                    return false;
                }
                if(ch <'0' || ch > '9'){
                    return false;
                }
                tmp = tmp*10 + (int)(ch-'0');
            }
            
            if(tmp > 255){
                return false;
            }
        }

        return true;
    }

    boolean v6(String ip){
        String[] ips = ip.split(":", -1);

        if(ips.length != 8){
            return false;
        }

        for(String s : ips){
            if(s.length()<1 || s.length()>4){
                return false;
            }

            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                if(ch >='0' && ch<='9'){
                    continue;
                }
                if(ch >='a' && ch<='f'){
                    continue;
                }
                if(ch>='A' && ch<='F'){
                    continue;
                }

                return false;
            }
        }

        return true;
    }
}
// @lc code=end

