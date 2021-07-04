package Graphs.Graph;

import java.util.PriorityQueue;

public class Djikstra {
	static class Pair implements Comparable<Pair>{
		int v;
		int wt;
		String path;
		Pair(int v, String path, int wt){
			this.v =v;
			this.wt = wt;
			this.path = path;
		}
		@Override
		public int compareTo(Pair p){
			return this.wt - p.wt;
		}
	}
	static void djikstra(int[][] graph, int src){
		boolean[] visited = new boolean[graph.length];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		// Same as BFS but using pq
		pq.add(new Pair(src, src+"", 0));
		while(!pq.isEmpty()){
			 Pair rem = pq.remove();
			 if(visited[rem.v]){
				continue;
			 }
			 visited[rem.v] = true;
			 System.out.println(rem.v+" via "+rem.path+" weight "+rem.wt);
			 for(int v:graph[rem.v]){
				 if(graph[rem.v][v]!=0 && !visited[v]){
					 pq.add(new Pair(v, rem.path+" "+v, rem.wt+graph[rem.v][v]));
				 }
			 }
		}
	}
}
