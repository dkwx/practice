package com.practice.leetcode;

import com.practice.leetcode.assist.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00138 {


    class Solution {
        public Node copyRandomList(Node head) {
            if (null == head) {
                return null;
            }
            Map<Node, Node> oldNewNodeMap = new HashMap<>();
            Node copy = new Node(head.val);
            copyNode(head, copy, oldNewNodeMap);
            return copy;

        }

        private void copyNode(Node source, Node copy, Map<Node, Node> oldNewNodeMap) {
            if (null == source) {
                return;
            }
            oldNewNodeMap.put(source, copy);
            Node sourceNext = source.next, sourceRandom = source.random;
            if (null != sourceNext) {
                Node copyNext = oldNewNodeMap.get(sourceNext);
                if (null == copyNext) {
                    copyNext = new Node(sourceNext.val);
                    copy.next = copyNext;
                    copyNode(sourceNext, copyNext, oldNewNodeMap);
                } else {
                    copy.next = copyNext;
                }
            }
            if (null != sourceRandom) {
                Node copyRandom = oldNewNodeMap.get(sourceRandom);
                if (null == copyRandom) {
                    copyRandom = new Node(sourceRandom.val);
                    copy.random = copyRandom;
                    copyNode(sourceRandom, copyRandom, oldNewNodeMap);
                } else {
                    copy.random = copyRandom;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00138().new Solution();
        System.out.println(solution.copyRandomList(null));
    }
}
