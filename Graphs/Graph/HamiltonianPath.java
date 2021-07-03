package Graphs.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class HamiltonianPath {
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
			scn.close();
			int src = 0;
		 HashSet<Integer> visited = new HashSet<>();
		 hamiltonian(graph,src,visited,src+" ");
	 
	}
	 static void hamiltonian(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String path){
		 visited.add(src);
		if(visited.size()==graph.length){
			System.out.println(path);
		}
		for(Edge e:graph[src]){
			if(!visited.contains(e.n)){
				hamiltonian(graph, e.n, visited, path+" "+e.n);
			}
		}
		visited.remove(src);
	 }
}
