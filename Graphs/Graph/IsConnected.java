package Graphs.Graph;

public class IsConnected {
	public static void main(String[] args) {
		
	}
	static boolean isConnected(int[][] am){
		boolean[] visited = new boolean[am.length];
		for(int i=0;i<visited.length;i++){
			if(!visited[i]){
				return false;//if  all nodes are not visited in one traversal
			}
		}
		return true;
		
	}
	static void printDFS(int[][] am, boolean[] visited, int i){
		if(i>=am.length ||i<0||visited[i]) return;
		visited[i] = true;
		System.out.print(i+" ");
		for(int v=0;v<am[i].length;v++){
			if(!visited[v] && am[i][v]==1){
				printDFS(am, visited, v);
			}
		}
		// visited[i] = false;
		
	}
}
