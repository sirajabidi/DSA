/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, 
and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly 
connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
*/

class Solution {
    private void cityDfs(int city, Boolean[] visited, int[][] isConnected) {
        visited[city] = true;
        for(int col=0; col <= isConnected[0].length-1; col++) {
            if (visited[col]) {
                continue;
            }
            if (city == col) {
                continue;
            }
            if (isConnected[city][col] == 0) {
                continue;
            }
            cityDfs(col, visited, isConnected);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 1 && isConnected[0].length == 1) {
            return 1;
        }

        int totalCities = isConnected.length;
        Boolean[] visited = new Boolean[totalCities];
        Arrays.fill(visited, false);

        int provinces = 0;

        for (int i = 0; i <= totalCities-1; i++) {
            if (visited[i]) {
                continue;
            }
            provinces++;
            cityDfs(i, visited, isConnected);
        }
        return provinces;
    }
}