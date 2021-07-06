package DP;

public class GoldMine {
	public static void main(String[] args) {
		
	}
	public static int findMax(int[][] mine){
		int[][] dp = new int[mine.length][mine[0].length];
		for(int j=dp[0].length;j>=0;j--){
			for(int i=dp.length;i>=0;i--){
				if(j==dp[0].length){
					dp[i][j] = mine[i][j];
				}
				else{
					int max = dp[i][j+1];
					if(i-1>=0){
						 max = Math.max(dp[i-1][j+1], max);
					}
					if(i+1<=dp.length){
						max = Math.max(dp[i+1][j+1], max);
					}
					dp[i][j] = max+mine[i][j];
				}
			}
		}
		int max = 0;
		for(int i:dp[0]){
			max = Math.max(max, i);
		}
		return max;
	}
}
