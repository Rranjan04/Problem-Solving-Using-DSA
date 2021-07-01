package Graphs.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPath {
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
		System.out.println(islands(am));
	}
	static int islands(int[][] am){
		int count = 0;
		boolean[] visited = new boolean[am.length];
		for(int i=0;i<visited.length;i++){
			if(!visited[i]){
				count++;
				bfsHelp(am, visited, i);
			}
		}
		return count;
	}
	static void bfsHelp(int[][] am, boolean[] visited,int v){
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] =true;
		while(!q.isEmpty()){
			int node = q.poll();
			for(int i=0;i<am.length;i++){
				if(!visited[i] && am[node][i]==1){
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
}
