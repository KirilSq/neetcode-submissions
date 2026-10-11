class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int preCourse = prerequisite[1];
            int otherCourse = prerequisite[0];
            adjList.get(preCourse).add(otherCourse);
            indegree[otherCourse]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                q.offer(course);
            }
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            numCourses--;
            for (int postCourse : adjList.get(course)) {
                indegree[postCourse]--;
                if (indegree[postCourse] == 0) {
                    q.offer(postCourse);
                }
            }
        }

        return numCourses == 0;
    }
}
