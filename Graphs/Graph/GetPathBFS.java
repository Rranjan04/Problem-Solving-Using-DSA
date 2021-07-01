package Graphs.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetPathBFS {
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
		 HashMap<Integer,Integer> map = new HashMap<>();
		 Queue<Integer> q = new LinkedList<>();
		 q.add(src);
		 visited[src] = true;
		 map.put(src, -1);
		 while(!q.isEmpty()){
			int curr = q.poll();
			for(int i=0;i<visited.length;i++){
				if(!visited[i] && am[curr][i]!=0){
					map.put(i, curr);
					q.add(i);
					visited[i] = true;
				}
				if(i==dest && am[curr][i]!=0){
					ArrayList<Integer> ans = new ArrayList<>();	
					map.put(i, curr);
					visited[dest]=true;
					// System.out.println(map);
					System.out.println();
					ans.add(i);
					while(i!=src){
						ans.add(map.get(i));
						i = map.get(i);
					}
					Collections.reverse(ans);
					System.out.println(ans);
					break;
				}
			}
		 }
	}

}
