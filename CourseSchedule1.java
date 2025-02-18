import java.util.*;

//The idea here is to solve the problem using BFS.
//We created an indegrees array to keep track of the number of dependencies each course has, and to start the traversal with the independent courses
//For effiecient lookups for the dependencies of each course, we take a hashmap of adjacency lists to represent the graph
//Time Complexity: O(V+E) where V is the no. of courses and E is the length of the prerequisites array
//Space Complexity: O(V+E)

public class CourseSchedule1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses == 0) {
            return true;
        }

        int indegrees[] = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = prerequisites.length;

        for(int i = 0; i < prerequisites.length; i++){

            indegrees[prerequisites[i][1]]++; //

            if(!map.containsKey(prerequisites[i][0])){

                map.put(prerequisites[i][0], new ArrayList<>());

            }

            map.get(prerequisites[i][0]).add(prerequisites[i][1]);

        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }

        // everything is independent
        if(count == numCourses) {
            return true;
        }

        // eveything is dependet on each other
        if(q.isEmpty()) {
            return false;
        }

        while(!q.isEmpty()) {
            int curr = q.poll();

            // children
            List<Integer> children = map.get(curr);

            if(children == null) {
                continue;
            }

            for(Integer child : children) {
                indegrees[child]--;

                // child has becmome indepdent
                if(indegrees[child] == 0) {
                    q.add(child);
                    count++;

                    if(count == numCourses) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
