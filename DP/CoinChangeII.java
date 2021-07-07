package DP;

public class CoinChangeII {
	public static void main(String[] args) {
		find(new int[]{2,3,5}, 7);
	}
	static int find(int[] coins, int target){
		int[] dp = new int[target+1];
		//traversing the coins array first creates combination
		/*
		traversing 2,3,5 first ensures that 3 will always come after 2 which will ensure 3 will never come before 2
		hence combination
		*/
		for(int i=0;i<coins.length;i++){
			for(int j=coins[i];j<target+1;j++){
				if(j==0){
					dp[j] = 1;
				}
				else{
					if(j-coins[i]>=0){
						dp[j]+= dp[j-coins[i]];
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
