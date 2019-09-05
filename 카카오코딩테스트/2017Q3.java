
// https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
// 캐시

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        LRUCache lru = new LRUCache(cacheSize);

        for (String city : cities) {
            String lowerCaseCity = city.toLowerCase();
            if (lru.get(lowerCaseCity) == -1) {
                lru.put(lowerCaseCity, lowerCaseCity);
                answer += 5;
            } else {
                answer += 1;
            }
        }

        return answer;
    }
}

class LRUCache {
    CacheItem head;
    CacheItem tail;
    int capacity;
    Map<String, CacheItem> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(String key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            CacheItem cur = map.get(key);

            if (cur != head) {
                if (cur == tail) { // move tail one in front, map의 크기가 2 이상인 것을 뜻함
                    tail = tail.prev;
                }
                // move cur to head
                if (cur.prev != null) {
                    cur.prev.next = cur.next;
                }
                if (cur.next != null) {
                    cur.next.prev = cur.prev;
                }
                cur.next = head;
                head.prev = cur;
                cur.prev = null;
                head = cur;
            }
            return 1;
        }
    }

    public void put(String key, String value) {
        if (!map.containsKey(key)) {
            // insert to head
            CacheItem cur = new CacheItem(key, value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.prev = cur;
                head = cur;
            }
            map.put(key, cur);
            if (map.size() > capacity) {
                map.remove(tail.key);
                tail.prev.next = null;
                tail = tail.prev;
            }
        } else {
            // update
            map.get(key).value = value;
        }
    }
}

class CacheItem {
    String key;
    String value;
    CacheItem prev;
    CacheItem next;

    public CacheItem(String key, String value) {
        this.key = key;
        this.value = value;
    }
}