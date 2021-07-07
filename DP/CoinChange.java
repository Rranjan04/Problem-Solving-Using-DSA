package DP;

public class CoinChange {
	public static void main(String[] args) {
		find(new int[]{2,3,5}, 7);
	}
	static int find(int[] coins, int target){
		int[] dp = new int[target+1];
		for(int i=0;i<target+1;i++){
			if(i==0){
				dp[i] = 1;
			}
			else{
				for(int j=0;j<coins.length;j++){
					if(i-coins[j]>=0){
						dp[i] += dp[i-coins[j]];
					}
				}
			}
		}
		for(int x:dp){
			System.out.print(x+" ");
		}
		return dp[target];
	}
}
