package Graphs.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class isGraphCyclic {
		static class Edge{
			int v;
			int n;
			Edge(int v, int n){
				this.v = v;
				this.n = n;
			}
		}
		public static void main(String[] args) {
			Scanner scn = new Scanner(System.in);
			int n = scn.nextInt();
			int k = scn.nextInt();
			ArrayList<Edge>[] graph = new ArrayList[n];
			for(int v=0;v< n;v++){
				graph[v] = new ArrayList<>();
			}
			for(int e=0;e<k;e++){
				int v1 = scn.nextInt();
				int v2 = scn.nextInt();
				graph[v1].add(new Edge(v1, v2));
				graph[v2].add(new Edge(v2, v1));
			}
			boolean ans = false;
			boolean[] visited = new boolean[n];
			for(int v=0;v<n;v++){
				if(!visited[v]){
					//traversal
					ans = isCyclic(graph, v, visited);
					if(ans) break;
				}
			}
			System.out.println(ans);
		}
	static class Pair{
		int v;
		String psf;
		Pair(int v, String psf){
			this.v = v;
			this.psf = psf;
		}
	}	
	public static boolean isCyclic(ArrayList<Edge>[] graph,int src, boolean[] visited){
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(src,src+" "));
		while(!q.isEmpty()){
			Pair rem = q.remove();
			if(visited[rem.v]){
				return true;
			}
			visited[rem.v] = true;
			for(Edge e:graph[rem.v]){
				if(!visited[e.n]){
					q.add(new Pair(e.n,rem.psf+e.n+" "));
				}
			}
		}
		return false;
	}

	
}
