class Solution {
    func minimumSemesters(_ n: Int, _ relations: [[Int]]) -> Int {
        // convert prerequisites to AdjacenccyList:
        var adjList: [[Int]] = Array(repeating: Array(), count: n+1)

        var indegrees: [Int] = Array(repeating: 0, count: n+1)

        for item in relations {
            var courseTag = item.first;
            var dependency = item.last;
            if (courseTag == dependency) {
                return -1
            }

            adjList[courseTag!].append(dependency!)
            indegrees[dependency!] = indegrees[dependency!] + 1
        }
        
        print("adjList:", adjList)
        print("indegrees:", indegrees)

        var queue: [[Int]] = Array()
        
        var tmp: [Int] = Array()
        for course in 1...n {
            if (indegrees[course] == 0) {
                tmp.append(course)
            }
        }
        queue.append(tmp)

        
        print("queue:", queue)
        
        var result: [[Int]] = Array()

        while (!queue.isEmpty) {
            var semesterCourses = queue.removeFirst()
            print("semesterCourses:", semesterCourses)
            result.append(semesterCourses)
            
            var samesterContainer: [Int] = Array()
            
            for semesterCourse in semesterCourses {
                print("semesterCourse:", semesterCourse)
                
                var courseDependencyList = adjList[semesterCourse]
                print("courseDependencyList:", courseDependencyList)
                
                for dependentCourse in courseDependencyList {
                    print("dependentCourse:", dependentCourse)
                    indegrees[dependentCourse] = indegrees[dependentCourse] - 1
                    if (indegrees[dependentCourse] == 0) {
                        samesterContainer.append(dependentCourse)
                    }
                }
            }
            if (samesterContainer.count > 0) {
               queue.append(samesterContainer) 
            }
            
        }
        
        var totalCount = 0
        for semesterContainer in result {
            totalCount = totalCount + semesterContainer.count
        }
        
        if (totalCount != n) {
            return -1
        }
        return result.count
        
    }
}