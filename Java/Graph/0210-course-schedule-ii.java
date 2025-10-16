/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must 
take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, 
return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. 
So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]

*/
class Solution {
    private boolean _dfs(HashMap<Integer, List<Integer>> adjList, int course, List<Integer> explored, List<Integer> currentPath,
                         List<Integer> result) {
        currentPath.add(course);
        List<Integer> dependencies = adjList.get(course);

        for(int dependency : dependencies) {
            if (explored.contains(dependency)) {
                continue;
            }
            if (currentPath.contains(dependency)) {
                return true; // cycle-found
            }

            boolean cycleFound = _dfs(adjList, dependency, explored, currentPath, result);
            if (cycleFound) {
                return true; // if lower level has found cycle just termninate , don't continue, save power:
            }
        }
        currentPath.removeLast(); // Adjust current as all dependencies of current has been satisfied
        explored.add(course); // "course" the node received has explored all it's childrens. Add it to explored:
        result.add(course); // Since all the children of this "node" has been explored - add it to the result
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int course = 0; course <= numCourses-1; course++) {
            adjList.put(course, new ArrayList<>());
        }

        // populate Adjacency-List (Map of course to it's dependencies):
        for(int[] dependency : prerequisites) {
            List<Integer> list = adjList.get(dependency[0]);
            list.add(dependency[1]);
        }

        List<Integer> explored = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int course = 0; course <= numCourses-1; course++) {
            if (explored.contains(course)   ) {
                continue;
            }
            
            boolean cycleFound = _dfs(adjList, course, explored, currentPath, result);
            if (cycleFound) {
                int[] tmp = new int[0];
                return tmp;
            }
        }

        int[] resultArray = result.stream().mapToInt(Integer::intValue).toArray();
        return resultArray;
    }
}