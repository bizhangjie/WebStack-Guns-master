package com.jsnjfz.manage.modular.api;

import io.swagger.models.auth.In;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {

//        Map<String, String> map = new HashMap<String, String>();
//        map.put("key1","value1");
//        map.put("key2","value2");
//
//        // keySet() 遍历
//        for (String key : map.keySet()){
//            System.out.println(key + " : " + map.get(key));
//        }
//
//        // entrySet() 遍历
//        for (Map.Entry<String, String> entry : map.entrySet()){
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
//
//        // keySet() 遍历
//        Iterator<String> iterator = map.keySet().iterator();
//        while (iterator.hasNext()){
//            String key = iterator.next();
//            System.out.println(key + " : " + map.get(key));
//        }
//
//        // entrySet() 遍历
//        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();
//        while (iterator1.hasNext()){
//            Map.Entry<String, String> entry = iterator1.next();
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }




        //  初始化, 10W次赋值
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0;i < 1000000; i++)
//            map.put(i,i);
//
//        /** 增强for循环，keySet迭代 */
//        long start = System.currentTimeMillis();
//        for (Integer key : map.keySet()) {
//            map.get(key);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("增强for循环, keySet迭代 -> " + (end - start) + "ms");
//
//        /** 增强for循环，entrySet迭代 */
//        start = System.currentTimeMillis();
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
//            entry.getKey();
//            entry.getValue();
//        }
//        end = System.currentTimeMillis();
//        System.out.println("增强for循环, entrySet迭代 -> " + (end - start) + "ms");
//
//        /** 迭代器，keySet迭代 */
//        start = System.currentTimeMillis();
//        Iterator<Integer> iterator = map.keySet().iterator();
//        Integer key;
//        while (iterator.hasNext()){
//            key = iterator.next();
//            map.get(key);
//        }
//        end = System.currentTimeMillis();
//        System.out.println("迭代器, keySet迭代 -> " + (end - start) + "ms");
//
//        /** 迭代器，entrySet迭代 */
//        start = System.currentTimeMillis();
//        Iterator<Map.Entry<Integer,Integer>> iterator1 = map.entrySet().iterator();
//        Map.Entry<Integer, Integer> entry;
//        while (iterator1.hasNext()){
//            entry = iterator1.next();
//            entry.getKey();
//            entry.getValue();
//        }
//        end = System.currentTimeMillis();
//        System.out.println("迭代器, entrySet迭代 -> " + (end - start) + "ms");

//        Map<String, String> map = new HashMap<String, String>();
//        map.put("a","c");
//        map.put("b","b");
//        map.put("c","a");
//
//        // 通过ArrayList构造函数把map.entrySet()转换成list
//        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
//        // 通过比较器实现比较排序
//        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
//            @Override
//            public int compare(Map.Entry<String, String> stringStringEntry, Map.Entry<String, String> t1) {
//                return stringStringEntry.getKey().compareTo(t1.getKey());
//            }
//        });
//        for (Map.Entry<String, String> mapping : list){
//            System.out.println(mapping.getKey() + " : " + mapping.getValue());
//        }



    }
}
