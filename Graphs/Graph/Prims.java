package Graphs.Graph;

import java.util.PriorityQueue;

public class Prims {
	public static void main(String[] args) {
		
	}
	static class Pair implements Comparable<Pair>{
		int v;
		int pv;
		int wt;
		Pair(int v, int pv, int wt){
			this.v = v;
			this.pv = pv;
			this.wt = wt;
		}
		public int compareTo(Pair p){
			return this.wt-p.wt;
		}
	}
	static void prims(int[][] graph){
		PriorityQueue<Pair> pq = new PriorityQueue<>();  
		pq.add(new Pair(0, -1, 0));
		boolean[] visited = new boolean[graph.length];
		System.out.println("Path");
		while(pq.size()>0){
			Pair rem = pq.remove();
			if(visited[rem.v]){
				continue;
			}
			visited[rem.v] = true;
			if(rem.pv!=-1){
				System.out.print(" "+rem.v);
			}
			for(int v:graph[rem.v]){
				if(graph[rem.v][v]!=-1 && !visited[v]){
					pq.add(new Pair(v, rem.v, graph[rem.v][v]));
				}
			}
		}
	}
}
