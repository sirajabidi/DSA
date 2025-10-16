class Solution {
    func _dfs(_ course: Int, _ adjList: inout [Int: [Int]], _ explored: inout [Bool], _ current: inout [Int], _ result: inout [Int]) -> Bool {

        if (explored[course]) {
            return false
        }

        explored[course] = true
        current.append(course)
        
        for dep in adjList[course]! {
            if (current.contains(dep)) {
                return true
            }
            
            let cycle = _dfs(dep, &adjList, &explored, &current, &result)
            if (cycle) {
                return true
            }
        }
        result.append(course)
        current.removeLast()
        return false
    }

    func findOrder(_ numCourses: Int, _ prerequisites: [[Int]]) -> [Int] {
        var adjList: [Int:[Int]] = Dictionary()
        
        for course in 0...numCourses-1 {
            adjList[course] = []
        }
        
        for item in prerequisites {
            let c = item[0]
            let d = item[1]
            adjList[c]!.append(d)
        }
        
        var result: [Int] = []
        var explored : [Bool] = Array(repeating: false, count: numCourses)
        var current: [Int] = []
        
        for course in 0...numCourses-1 {
            if (explored[course]) {
                continue
            }
            
            var cycle: Bool = _dfs(course, &adjList, &explored, &current, &result)
            if (cycle) {
                return []
            }
        }

        return result
    }
}