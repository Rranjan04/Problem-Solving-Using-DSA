package Graphs.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class SpreadInfection {
	static class Pair {
		int v;
		int time;

		Pair(int v, int time) {
			this.v = v;
			this.time = time;
		}
	}

	public static void main(String[] args) {

	}

	static int find(int[][] graph, int src, int time) {
		int[] visited = new int[graph.length];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(src, 1));
		int count = 0;
		while (!q.isEmpty()) {
			Pair rem = q.remove();
			if (visited[rem.v] > 0) {
				continue;// do nothing
			}
			visited[rem.v] = rem.time;
			if (rem.time > time) {
				break;
			}
			count++;
			for (int v : graph[src]) {
				if (v != 0 && visited[v] == 0) {
					q.add(new Pair(v, rem.time + 1));
				}
			}

		}
		return count;
	}
}