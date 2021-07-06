package DP;

import java.util.Arrays;

public class ClimbStairsWithMinMoves {
	public static void main(String[] args) {
		System.out.println(jumps(new int[]{1,1,1,4,9,8,1,1,10,1},10));
	}
	static int jumps(int[] arr,int n){
		int[] dp = new int[n+1];
		//1) storage and meaning
		//2) Direction 
		//3) Travel and Solve
		Arrays.fill(dp,n+10);
		dp[n] =0; // no of moves 
		for(int i =n-1;i>=0;i--){
			int steps = arr[i];
			for(int j=1;j<=steps;j++){
				if(j+i<=n){
					dp[i] = Math.min(dp[i],dp[j+i]+1);
				}
			}
		}
		for(int i:dp){
			System.out.print(i+" ");
		}System.out.println();
		if(dp[0]==n+10) return 0;
		return  dp[0];
	}
}
