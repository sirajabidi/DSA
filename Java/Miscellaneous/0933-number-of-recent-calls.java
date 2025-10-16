class RecentCounter {
    private Queue<Integer> cache = null;

    public RecentCounter() {
        this.cache = new LinkedList<Integer>(); 
    }
    
    public int ping(int t) {
     this.cache.add(t);
     if (t < 3000) {
        return cache.size();
     }
     while(cache.peek() < (t-3000)) {
        cache.remove();
     }
     return cache.size(); 
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */