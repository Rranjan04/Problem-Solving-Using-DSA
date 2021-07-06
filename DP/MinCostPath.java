package DP;

public class MinCostPath {
	public static void main(String[] args) {
		
	}
	static int minCost(int[][] mat){
		int[][] dp = new int[mat.length+1][mat[0].length+1];
		
		dp[mat.length][mat[0].length] = 0;
		for(int i=mat.length-1;i>=0;i--){
			for(int j=mat[0].length;j>=0;j--){
				int min = Integer.MAX_VALUE;
				if(i+1<=mat.length){
					min = Math.min(min,dp[i+1][j]+mat[i][j]);
				}
				if(j+1<=mat[0].length){
					min = Math.min(min, dp[i][j+1]+mat[i][j]);
				}
				dp[i][j] = min;
			}
		}
		return dp[0][0];

	}
}
