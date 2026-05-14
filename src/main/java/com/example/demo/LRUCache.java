package com.example.demo;

import java.util.*;
// Node for doubly linked list
class Node {
    String key;
    String value;
    Node prev, next;
    long expiryTime;

    Node(String key, String value, long expiryTime) {
        this.key = key;
        this.value = value;
        this.expiryTime = expiryTime;
    }
}

public class LRUCache {
    private int capacity;  // Maximum cache capacity
    // Stores cache statistics
    private int hits = 0;
    private int misses = 0;
    private int evictions = 0;
    private Map<String, Node> map;  
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node("0", "0", Long.MAX_VALUE);
        tail = new Node("0", "0", Long.MAX_VALUE);

        head.next = tail;
        tail.prev = head;
    }

    // Add node right after head(Most Recently Used position)
    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Remove node from doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Move accessed node to front(MRU position)
    private void moveToFront(Node node) {
        removeNode(node);
        addNode(node);
    }

    // Fetch value from cache
    public String get(String key) {
        if (!map.containsKey(key)) {
            misses++;
            return null;
        }

        Node node = map.get(key);
        if (System.currentTimeMillis() > node.expiryTime) {

            removeNode(node);
            map.remove(key);
            misses++;

        return null;
        }
        hits++;
        moveToFront(node);
        return node.value;
    }

    // Insert or update cache entry with TTL
    public void put(String key, String value, long ttlSeconds) {
        long expiryTime = System.currentTimeMillis()+(ttlSeconds* 1000);
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.expiryTime = expiryTime;
            node.value = value;
            moveToFront(node);
        } 
        else {
            if (map.size() == capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
                evictions++;
            }
            
            Node newNode = new Node(key, value, expiryTime);
            addNode(newNode);
            map.put(key, newNode);
        }
    }

    // Delete cache entry manually
    public boolean remove(String key) {
    if (!map.containsKey(key)) {
        return false;
    }
    Node node = map.get(key);
    removeNode(node);
    map.remove(key);
    return true;
    }

    // Return cache performance statistics
    public CacheStats getStats() {
    return new CacheStats(hits, misses, evictions);
    }

    // Display all valid cache entries in LRU order
    public List<String> displayCache(){
        List<String> result= new ArrayList<>();
        Node current = head.next;
        while(current !=tail){
            Node nextNode = current.next;
            if(System.currentTimeMillis() > current.expiryTime){
                removeNode(current);
                map.remove(current.key);
            }
            else{
                result.add(current.key + " -> " + current.value);
            }
            current = nextNode;
        }
        return result;
    }
}
