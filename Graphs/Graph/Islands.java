package Graphs.Graph;

import java.util.Scanner;

public class Islands {
	//0 Land 1 Water 
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
		boolean[][] visited = new boolean[v][v];
		int count =0 ;
		for(int i=0;i<am.length;i++){
			for(int j=0;j<am[i].length;j++){
				if(am[i][j]==0 && !visited[i][j]){
					draw(am, i, j, visited);
					count++;
				}
			}
		}
		System.out.println(count);
	}
	static void draw(int[][] arr, int i, int j, boolean[][] visited){
		if(i>=arr.length||j>=arr[0].length||i<0||j<0||visited[i][j]||arr[i][j]==1) return;
		visited[i][j] = true;
		draw(arr, i-1, j, visited);
		draw(arr, i, j+1, visited);
		draw(arr, i, j-1, visited);
		draw(arr, i+1, j, visited);
	}
}
