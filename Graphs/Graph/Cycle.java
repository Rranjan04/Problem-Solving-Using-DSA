package Graphs.Graph;

import java.util.Arrays;

public class Cycle {
	public static void main(String[] args) {
		
	}
	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,1,-1};
	boolean[][] visited;
	boolean cycle=false;
	void dfs(String[] board,int x, int y, int fromX, int fromY, int color, int n, int m){
		if(x<0||x>=n||y<0||y>=m) return;
		if(board[x].charAt(y)!=color) return;
		if(visited[x][y]){
			cycle =true;
		}
		visited[x][y] = true;
		for(int i=0;i<4;i++){
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(nextX==fromX && nextY==fromY) continue;
			dfs(board, nextX, nextY, x, y, color, n, m);
		}
	}
	boolean solve(String[] board, int n, int m){
		visited = new boolean[n][m];
		for(int i=0;i<n;i++){
			Arrays.fill(visited[i], false);
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(!visited[i][j]){
					dfs(board, i, j, -1, -1, board[i].charAt(j), n, m);
				}
			}
		}
		return cycle;

	}
}
