package com.practice.basic.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kai.dai
 * @date : 2020-05-31 01:41
 */
public class ForeachTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String >(){{add("a");}};
        list.add("a");
        list.add("b");
        list.add("c");
        for(String str : list){
            if(str.equals("a")){
                list.remove("a");
            }
        }
    }
}
