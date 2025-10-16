class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Construction of graph is amazing here :
        if (source == destination) {
            return true;
        }

        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for (int[] edge: edges) {
            List<Integer> vertexOneList = graph.get(edge[0]);
            List<Integer> vertexTwoList = graph.get(edge[1]);
            vertexOneList.add(edge[1]);
            vertexTwoList.add(edge[0]);
        }
        boolean [] visited = new boolean[n];
        Arrays.fill(visited, false);

        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            visited[vertex] = true;
            List<Integer> neighbors = graph.get(vertex);
            for(int neighbor: neighbors.reversed()) {
                if (neighbor == destination) {
                    return true;
                }
                if (visited[neighbor]) {
                    continue;
                }
                stack.push(neighbor);
            }
        }

        return false;
    }
}