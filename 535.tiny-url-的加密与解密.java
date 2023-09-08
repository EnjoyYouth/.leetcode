/*
 * @lc app=leetcode.cn id=535 lang=java
 *
 * [535] TinyURL 的加密与解密
 */

// @lc code=start

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Codec {

    private final String PREFIX = "http://tinyurl.com/";

    private final Map<String, String> dp = new ConcurrentHashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String s = uuid.substring(uuid.length()-6, uuid.length());

        dp.put(s, longUrl);
        return PREFIX + s;
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String s = shortUrl.substring(PREFIX.length());
        return dp.get(s);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
// @lc code=end

