package Graphs.Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MultiSolver {
	static String sPath;
	static Integer sPathwt = Integer.MAX_VALUE;
	static String lPath;
	static Integer lPathwt = Integer.MIN_VALUE;
	static String cPath;
	static Integer cPathwt = Integer.MAX_VALUE;
	static String fPath;
	static Integer fPathwt = Integer.MIN_VALUE;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();
	static class Pair implements Comparator<Pair>{
		String path;
		int weight;
		Pair(int weight, String path){
			this.weight = weight;
			this.path = path;
		}
		@Override
		public int compare(Pair o1, Pair o2) {
			return o1.weight-o2.weight;
		}
	}
	public static void multiSolver(int[][] graph, int src, int dest, boolean[] visited,int k, int criteria, String psf, int w){
		if(src==dest){
			if(w<sPathwt){
				sPathwt = w;
				sPath = psf;
			}
			if(w>lPathwt){
				lPathwt = w;
				lPath = psf;
			}
			if(w<criteria && w>fPathwt){
				fPath = psf;
				fPathwt = w;
			}
			if(w>criteria && w<cPathwt){
				cPathwt = w;
				cPath = psf;
			}
			if(pq.size()<k){
				pq.add(new Pair(w,psf));
			}else {
				if(w>pq.peek().weight){
					pq.remove();
					pq.add(new Pair(w, psf));
				}
			}
			return;
		}
		visited[src]=true;
		for(int i=0;i<graph.length;i++){
			if(!visited[i] && graph[src][i]!=0){
				multiSolver(graph, i, dest, visited, k-1, criteria, psf+" -> "+src, w=graph[src][i]);

			}
		}
		visited[src] = false;
	}
	
}
