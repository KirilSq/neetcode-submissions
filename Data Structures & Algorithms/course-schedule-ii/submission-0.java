class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            int preCourse = prerequisite[1];
            int other = prerequisite[0];
            adjList.get(preCourse).add(other);
            indegree[other]++;
        }

        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int[] result = new int[numCourses];
        int resultIndex = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            result[resultIndex++] = cur;
            for(int neighbor : adjList.get(cur)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }

        return resultIndex == numCourses ? result : new int[0];
    }
}
