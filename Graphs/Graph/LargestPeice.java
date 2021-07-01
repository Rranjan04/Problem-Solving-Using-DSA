package Graphs.Graph;

public class LargestPeice {
	public static void main(String[] args) {
		
	}
	static int[] x ={-1,1,0,0};
	static int[] y = {0,0,-1,1};
	static int count =0;
	static void solve(int[][] am,int n){
		boolean[][] visited = new boolean[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(!visited[i][j] && am[i][j]!=0){
					int temp = help(am,visited, i,j,n);
					count = Math.max(temp, count);
				}
			}
		}
	}
	static int help(int[][] am, boolean[][] visited,int i, int j, int n){
		if(i<0||i>=n||j<0||j>=n||visited[i][j]||am[i][j]==0) return 0;
		visited[i][j] = true;
		int temp = 0;
		for(int k=0;k<4;k++){
			int nx = i+x[i];
			int ny = j+y[i];
			if(!visited[nx][ny]){
				temp = Math.max(temp, help(am, visited, nx, ny, n)+1);
			}
		}
		visited[i][j] = false;
		return temp;
	}
}
