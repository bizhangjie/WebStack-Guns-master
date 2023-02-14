package com.jsnjfz.manage.modular.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Passwd {

    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        // 添加数据
        hashMap.put("一号选手",100);
        hashMap.put("二号选手",90);
        hashMap.put("三号选手",80);
        hashMap.put("四号选手",70);
        hashMap.put("五号选手",60);

        // 修改数据 put 即可添加也可以修改
        hashMap.put("一号选手",99);

        // 第一种元素遍历
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            String key = (String)iterator.next();
            System.out.println(key + " = " + hashMap.get(key));
        }

        System.out.println(hashMap.get("一号选手"));

        // 第二种遍历
        Iterator iterator1 = hashMap.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry entry = (Map.Entry) iterator1.next();
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println(key + " = " + value);
        }

        // 替换元素值
        hashMap.replace("一号选手",100);
        System.out.println(hashMap.get("一号选手"));
    }

}
