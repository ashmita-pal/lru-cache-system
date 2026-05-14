package com.example.demo;

public class CacheStats {
    private int hits;
    private int misses;
    private int evictions;
    public CacheStats(int hits, int misses, int evictions){
        this.hits=hits;
        this.misses=misses;
        this.evictions=evictions;
    }
    public int getHits(){
        return hits;
    }
    public int getMisses(){
        return misses;
    }
    public int getEvictions(){
        return evictions;
    }
}
