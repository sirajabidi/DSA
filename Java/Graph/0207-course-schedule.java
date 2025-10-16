/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are 
given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if 
you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have 
finished course 1. So it is impossible.
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int course = 0; course <= numCourses-1; course++) {
            adjList.put(course, new ArrayList<>());
        }

        for(int[] dependency : prerequisites) {
            List<Integer> list = adjList.get(dependency[0]);
            list.add(dependency[1]);
        }

        Boolean[] visited = new Boolean[numCourses];
        Arrays.fill(visited, false);


        Boolean[] visiting = new Boolean[numCourses];
        Arrays.fill(visiting, false);

        for(int course = 0; course <= numCourses-1; course++) {
            if (visited[course]) {
                continue;
            }
            boolean status = courseDfs(adjList, course, visited, visiting);
            if (!status) {
                return false;
            }
        }
        return true;
    }

    private boolean courseDfs(HashMap<Integer, List<Integer>> adjList, int course, Boolean[] visited, Boolean[] visiting) {
        if (visiting[course]) {
            return false;
        }
        visiting[course] = true;
        
        List<Integer> courses = adjList.get(course);
        for(int dependency : courses) {
            if (visited[dependency]) {
                continue;
            }
            boolean status = courseDfs(adjList, dependency, visited, visiting);
            if (!status) {
                return false;
            }
        }
        visiting[course] = false;
        visited[course] = true;
        return true;
    }
}