package com.practice.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树
 *
 * @author : kai.dai
 * @date : 2020-05-23 20:05
 */
public class PreTreeTest {

    public class PreTree {
        boolean end;
        Map<Character, PreTree> childrens = new HashMap<>();
        // 途经本站次数
    }

    PreTree head = new PreTree();

    public void addString(String queryStr) {
        PreTree currentTree = head;
        // currentTree.count++;
        for (char c : queryStr.toCharArray()) {
            if (currentTree.childrens.containsKey(c)) {
                PreTree tempTree = currentTree.childrens.get(c);
                // tempTree.count++;
                currentTree = tempTree;
            } else {
                PreTree tempTree = new PreTree();
                // tempTree.count++;
                currentTree.childrens.put(c, tempTree);
                currentTree = tempTree;
            }
        }
        currentTree.end = true;
    }

    public boolean search(String str) {
        PreTree currentTree = head;
        for (char c : str.toCharArray()) {
            if (currentTree.childrens.containsKey(c)) {
                currentTree = currentTree.childrens.get(c);
            } else {
                return false;
            }
        }
        return currentTree.end;
    }

    public boolean startsWith(String str) {
        PreTree currentTree = head;
        for (char c : str.toCharArray()) {
            if (currentTree.childrens.containsKey(c)) {
                currentTree = currentTree.childrens.get(c);
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        PreTreeTest preTreeTest = new PreTreeTest();
        preTreeTest.addString("ad");
        preTreeTest.addString("ads");
        preTreeTest.addString("adc");
        preTreeTest.addString("adff");
        preTreeTest.addString("adfdf");
        preTreeTest.addString("adfss");

        System.out.println(preTreeTest.search("ad"));
        System.out.println(preTreeTest.search("adf"));
        System.out.println(preTreeTest.startsWith("adf"));
        System.out.println(preTreeTest.startsWith("adc"));
    }
}
