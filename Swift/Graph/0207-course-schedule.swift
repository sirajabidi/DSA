class Solution {
    func canFinish(_ numCourses: Int, _ prerequisites: [[Int]]) -> Bool {
        // convert prerequisites to AdjacenccyList:
        var adjList: [[Int]] = Array(repeating: Array(), count: numCourses)

        var indegrees: [Int] = Array(repeating: 0, count: numCourses)

        for item in prerequisites {
            var courseTag = item.first;
            var dependency = item.last;
            if (courseTag == dependency) {
                return false
            }

            adjList[courseTag!].append(dependency!)
            indegrees[dependency!] = indegrees[dependency!] + 1
        }

        var queue: [Int] = Array()
        for course in 0...numCourses-1 {
            if (indegrees[course] == 0) {
                queue.append(course)
            }
        }

        var result: [Int] = Array()

        while (!queue.isEmpty) {
            var course = queue.removeFirst()
            result.append(course)

            var courseDependencyList = adjList[course]

            for dependentCourse in courseDependencyList {
                indegrees[dependentCourse] = indegrees[dependentCourse] - 1
                if (indegrees[dependentCourse] == 0) {
                    queue.append(dependentCourse)
                }
            }
        }

        if (result.count != numCourses) {
            return false
        }

        return true
    }
}