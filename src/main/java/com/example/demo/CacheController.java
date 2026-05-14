package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

// Rest Controller for cache operations
@RestController
@RequestMapping("/cache")
public class CacheController {

    private LRUCache cache = new LRUCache(3);

    // GET → fetch value by key 
    @GetMapping("/{key}")
    public String getValue(@PathVariable String key) {
        String value = cache.get(key);
        return value == null ? "Not Found" : value;
    }

    // POST → store key-value pair with TTL
    @PostMapping
    public String putValue(@RequestParam String key, @RequestParam String value, @RequestParam long ttl) {
        cache.put(key, value, ttl);
        return "Stored successfully";
    }

    // Delete cache entry
    @DeleteMapping("/{key}")
    public String deleteValue(@PathVariable String key) {
        boolean removed = cache.remove(key);
        return removed ? "Deleted successfully" : "Key not found";
    }

    // Get cache statistics
    @GetMapping("/stats")
    public CacheStats stats() {
        return cache.getStats();
    }

    // Display all cache entries
    @GetMapping("/all")
    public List<String> getAllCache(){
        return cache.displayCache();
    }
}