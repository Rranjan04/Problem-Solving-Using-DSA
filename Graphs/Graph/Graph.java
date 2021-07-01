package Graphs.Graph;

import java.util.Scanner;

public class Graph{
	
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
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				System.out.print(am[i][j]+" ");
			}
			System.out.println();
		}
	}
}