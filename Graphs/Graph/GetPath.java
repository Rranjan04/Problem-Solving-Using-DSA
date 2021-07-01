package Graphs.Graph;

import java.util.Scanner;

public class GetPath {
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
		// for(int i=0;i<v;i++){
		// 	for(int j=0;j<v;j++){
		// 		System.out.print(am[i][j]+" ");
		// 	}
		// 	System.out.println();
		// }
		// System.out.println();
		getPath(am, 1, 3);
	}
	static void getPath(int[][] am, int src, int dest){
		boolean[] visited = new boolean[am.length];
		help(am, src, dest, visited, "");
		
	}
	static void  help(int[][] am, int src, int dest, boolean[] visited, String path){
		if(src>am.length-1||visited[src]) return;
		if(src==dest){
			path+=" "+src;
			System.out.println(path);
			return;
		}
		visited[src] = true;
		for(int i=0;i<am.length;i++){
			if(!visited[i] && am[src][i]!=0){
				help(am, i, dest, visited, path+src+" -> ");
			}
		}
		visited[src] = false;
	}
}
