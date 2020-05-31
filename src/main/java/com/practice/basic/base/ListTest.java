package com.practice.basic.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kai.dai
 * @date : 2020-05-31 12:59
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();
        soutListObj(objList);
        soutListStr(stringList);

        soutListObjQuery(stringList);
        soutListObjQuery(objList);

        // soutListObjAdd(stringList);
        soutListObjAdd(objList);
    }

    public static void soutListStr(List<String> list){
        System.out.println(list);
    }

    public static void soutListObj(List<Object> list){
        System.out.println(list);
    }

    public static void soutListObjQuery(List<? extends Object> list){
        System.out.println(list);
    }

    public static void soutListObjAdd(List<? super Object> list){
        list.add("");
        System.out.println(list);
    }
}
