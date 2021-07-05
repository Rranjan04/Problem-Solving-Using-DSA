package Graphs.Graph;

import java.util.Stack;

//BFS : Sibling
// DFS: Child
public class IterativeDFS {
	public static void main(String[] args) {

	}
	// Linear graph with large number of vx;
	// Recursion will throw Stack Memory Error(Call Stack has less space)
	// This Stack is created in heap, hence can handle large numbe of edges
		static void DFS(int[][] graph, int src) {
		boolean[] visited = new boolean[graph.length];
		Stack<Integer> st = new Stack<>();
		// reverse Euler
		// Similar to BFS but with stack
		st.add(src);
		while (!st.isEmpty()) {
			int rem = st.pop();
			if (visited[rem]) {
				continue;
			}
			visited[rem] = true;
			for (int v : graph[rem]) {
				if (graph[rem][v] != 0 && !visited[v]) {
					st.push(v);
				}
			}
		}
	}
}
