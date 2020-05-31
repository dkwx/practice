package com.practice.basic.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author : kai.dai
 * @date : 2020-05-31 14:08
 */
public class TryWithResouceTest {

    // 原来写法

    // public static void main(String[] args) {
    //     BufferedReader br = null;
    //     try {
    //         String line;
    //         br = new BufferedReader(new FileReader("d:\\hollischuang.xml"));
    //         while ((line = br.readLine()) != null) {
    //             System.out.println(line);
    //         }
    //     } catch (IOException e) {
    //         // handle exception
    //     } finally {
    //         try {
    //             if (br != null) {
    //                 br.close();
    //             }
    //         } catch (IOException ex) {
    //             // handle exception
    //         }
    //     }
    // }
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("d:\\ hollischuang.xml"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
            // handle exception
        }
    }
}
