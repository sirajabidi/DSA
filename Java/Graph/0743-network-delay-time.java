class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<List<Integer>>> adjList = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] item : times) {
            List<List<Integer>> neighbors = adjList.get(item[0]);
            List<Integer> edge = new ArrayList<>();
            edge.add(item[1]);
            edge.add(item[2]);
            neighbors.add(edge);
        }
        
        Boolean[] visited = new Boolean[n+1];
        Arrays.fill(visited, false);

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()) {
            Pair current = pq.poll();
            List<List<Integer>> neighbors = adjList.get(current.node);
            for(List<Integer> neighbor : neighbors) {
                int neighborNode = neighbor.get(0);
                int distanceToNeighbor = neighbor.get(1);
                if (visited[neighborNode]) {
                    continue;
                }
                if (distance[neighborNode] > distance[current.node] + distanceToNeighbor) {
                    distance[neighborNode] = distance[current.node] + distanceToNeighbor;
                    pq.add(new Pair(neighborNode, distance[current.node] + distanceToNeighbor));
                }
            }
            visited[current.node] = true;
        }

        int result = -1;
        for (int i = 1; i <= distance.length-1; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            if (distance[i] > result) {
                result = distance[i];
            }
        }
        return result;
    }
}