package Graphs.Graph;

import java.util.Scanner;

public class DFS {
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
		dfs(am);
	}
	static void dfs(int[][] am){
		boolean[] visited = new boolean[am.length];
		for(int i=0;i<visited.length;i++){
			if(!visited[i]){
				printDFS(am, visited, i);
			}
		}
		
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
