package Graphs.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsBipartite {
	static class Edge {
		int v;
		int n;

		Edge(int v, int n) {
			this.v = v;
			this.n = n;
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<Edge>[] graph = new ArrayList[n];
		for (int v = 0; v < n; v++) {
			graph[v] = new ArrayList<>();
		}
		for (int e = 0; e < k; e++) {
			int v1 = scn.nextInt();
			int v2 = scn.nextInt();
			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
		}
		scn.close();
		int[] visited = new int[n];
		Arrays.fill(visited, -1);
		for (int vx = 0; vx < n; vx++) {
			boolean isIt = check(graph, vx, visited);
			if (!isIt) {
				System.out.println(false);
				return;
			}
		}
		System.out.println(true);
	}

	static class Pair {
		int v;
		int level;

		Pair(int v, int level) {
			this.v = v;
			this.level = level;
		}
	}

	static boolean check(ArrayList<Edge>[] graph, int src, int[] visited) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(src, 0));
		while (!q.isEmpty()) {
			Pair rem = q.remove();
			if (visited[rem.v] != -1) {
				// cycle
				if (rem.level != visited[rem.v]) {
					//not meeting at the same level-- ODD cycle
					return false;
				}
			} else {
				visited[rem.v] = rem.level;
			}
			for (Edge e : graph[rem.v]) {
				if (visited[e.n] == -1) {
					q.add(new Pair(e.n, rem.level + 1));
				}
			}
		}
		return true;
	}
}
