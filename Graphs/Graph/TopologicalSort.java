package Graphs.Graph;

import java.util.Stack;

public class TopologicalSort {
	public static void main(String[] args) {
		
	}
	static void helper(int[][] graph){
		boolean[] visited = new boolean[graph.length];
		Stack<Integer> stack = new Stack<>();
		//FAITH: all dependent vx are already present in the stack
		for(int i=0;i<visited.length;i++){
			if(!visited[i]){
				topologicalSort(graph,i,visited,stack);
			}
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	static void topologicalSort(int[][] graph, int src, boolean[] visited, Stack<Integer> stack){
		visited[src] = true;
		for(int v:graph[src]){
			if(!visited[v]){
				topologicalSort(graph, v, visited, stack);
			}
		}
		stack.push(src);
	}
}
