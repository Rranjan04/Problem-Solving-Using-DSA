package DP;

public class ClimbStairsWithVariableJump {
	public static void main(String[] args) {
		
	}
	public int jumps(int[] arr,int n){
		int[] dp = new int[n+1];
		//1) storage and meaning
		//2) Direction 
		//3) Travel and Solve
		dp[n] =1; 
		for(int i =n-1;i>=0;i--){
			int steps = dp[i];
			for(int j=1;j<steps;j++){
				if(j+i<=n){
					dp[i]+=dp[i+j];
				}
			}
		}
		return  dp[0];
	}

}
