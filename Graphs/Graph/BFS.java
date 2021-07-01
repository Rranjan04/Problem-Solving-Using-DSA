package Graphs.Graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		int[][] am = new int[v][v];
		for(int i=0;i<e;i++){
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			am[v1][v2] = 1;
			am[v2][v1] = 1;
		}
		s.close();
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				System.out.print(am[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		bfs(am);
	}
	static void bfs(int[][] am){
		boolean[] visited = new boolean[am.length];
		for(int i=0;i<visited.length;i++){
			if(!visited[i]){
				bfsHelp(am, visited, i);
			}
		}
	}
	static void bfsHelp(int[][] am, boolean[] visited,int v){
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] =true;
		while(!q.isEmpty()){
			int node = q.poll();
			System.out.print(node+" ");
			for(int i=0;i<am.length;i++){
				if(!visited[i] && am[node][i]==1){
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

}
