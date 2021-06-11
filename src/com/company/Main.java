package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String[] manyWords={"cat","dog","gun","table","ant","dog","cat","gun","cat","dog","dog"};
        HashMap<String,Integer> map=new HashMap<>();
        for (String word: manyWords){
            if (!map.containsKey(word))
                map.put(word,1);
            else
                map.put(word,map.get(word)+1);
        }
        System.out.println(map);
    }
}
