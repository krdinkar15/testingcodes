package com.coding.linkedList;

import java.util.*;
public class LRUCache {
    int capacity=0;
    LinkedHashMap<Integer,Integer> lhm=new LinkedHashMap<Integer,Integer>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        int ans;
        if(lhm.containsKey(key))
        {
            ans=lhm.get(key);
            lhm.remove(key);
            lhm.put(key,ans);
        }
        else
        {
            ans=-1;
        }
        System.out.println(ans);
        return ans;
    }

    public void put(int key, int value) {

        if(lhm.containsKey(key))
        {
            int val=lhm.get(key);
            lhm.remove(key);
            lhm.put(key,value);
        }
        else if(lhm.size()<capacity)
        {
            lhm.put(key,value);
        }
        else
        {

            for(Map.Entry<Integer,Integer> entries:lhm.entrySet())
            {
                lhm.remove(entries.getKey());
                break;
            }
            lhm.put(key,value);
        }
    }

    public static void main(String[] args) {

        // ["LRUCache","put","put","get","put","get","put","get","get","get"]
        // [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.get(2);
        lRUCache.put(2,6);
        lRUCache.get(1);
        lRUCache.put(1,5);
        lRUCache.put(1,2);
        lRUCache.get(1);
        lRUCache.get(2);

    }
}