package Graphs.Graph;

import java.util.Scanner;

public class HasPath {
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
		System.out.println(hasPath(am, 1, 3));
	}
	static boolean hasPath(int[][] am,int src, int dest){
		boolean[] visited = new boolean[am.length];
		return hasPathHelp(am, src, dest,visited);
	}
	static boolean hasPathHelp(int[][] am, int src, int dest , boolean[] visited){
		if(src>am.length||visited[src]) return false;
		if(src==dest) return true;
		visited[src] = true;
		for(int i=0;i<am.length;i++){
			if(!visited[i] && am[src][i]!=0){
				boolean ans = hasPathHelp(am, i, dest, visited);
				if(ans) return true;
			}
		}
		visited[src] = false;
		return false;
	}
}
