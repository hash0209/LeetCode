class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
           List<List<Integer>> list = new  ArrayList<>();
           for(int i = 0; i < numCourses ; i++){
                    list.add(new ArrayList<>());
           }

           build(prerequisites , list);

           boolean[] visited = new boolean[numCourses];
           boolean[] pathVisited =new boolean[numCourses];

           for(int i =0; i < list.size() ; i++){

                 if(!visited[i]){

                     if (hasCycle(list,i,visited,pathVisited)){
                        return false;
                     }

                 }

           }
           return true;




          


    }

    public boolean hasCycle(List<List<Integer>> list, int course , boolean[] visited , boolean[] pathVisited ){

        visited[course] =true;
        pathVisited[course] =true;

        for(int next : list.get(course)){
              if(!visited[next]){
                  if(hasCycle(list,next , visited , pathVisited)){
                    return true;
                  }
              }
              else{
                if(pathVisited[next]){
                    return true;
                }
              }
        }

        pathVisited[course] =false;
        return false;






             

             

    }

    public void build(int[][] pre, List<List<Integer>> list) {
        for (int i = 0; i < pre.length; i++) {
            list.get(pre[i][0]).add(pre[i][1]);
        }
    }
}