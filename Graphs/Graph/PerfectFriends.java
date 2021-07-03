package Graphs.Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class PerfectFriends {
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
		/**
		 * 7 5
			0 1
			2 3
			4 5
			5 6
			4 6
		 */
		scn.close();
		boolean[] visited = new boolean[n];
		ArrayList<Integer> comp = new ArrayList<>();
		for(int i=0;i<n;i++){
			count = 0;
			if(!visited[i]){
				find(graph,visited,i);
				comp.add(count);
			}
		}
		System.out.println();
		System.out.println(comp);
		System.out.println(calculate(comp));
	}
	static int count = 0;
	static int calculate(ArrayList<Integer> comp){
		if(comp.size()==0) return 0;
		if(comp.size()==1) return comp.get(0);
		int i=0;
		int j=1;
		int ans = 0;
		while(j<comp.size()){
			ans+=comp.get(i)*comp.get(j);
			i++;
			j++;
		}
		ans+=comp.get(comp.size()-1)*comp.get(0);
		return ans;
	}
	static void find(ArrayList<Edge>[] graph,boolean[] visited, int src){
		visited[src] = true;
		count ++;
		for(int i=0;i<graph[src].size();i++){
			if(!visited[graph[src].get(i).n]){
				find(graph, visited, graph[src].get(i).n);
			}
		}
	}

}
