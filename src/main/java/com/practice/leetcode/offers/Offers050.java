package com.practice.leetcode.offers;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指offer
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers050 {
    class Solution {
        public char firstUniqChar(String s) {
            Map<Character, Boolean> linkedHashMap = new LinkedHashMap<>();
            for (char ch : s.toCharArray()) {
                if (linkedHashMap.containsKey(ch)) {
                    linkedHashMap.put(ch, false);
                } else {
                    linkedHashMap.put(ch, true);
                }
            }
            for (Map.Entry<Character, Boolean> entry : linkedHashMap.entrySet()) {
                if (entry.getValue()) {
                    return entry.getKey();
                }
            }
            return ' ';
        }
    }

    public static void main(String[] args) {
        System.out.println(new Offers050().new Solution().firstUniqChar(""));
    }
}
