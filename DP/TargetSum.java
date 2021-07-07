package DP;
public class TargetSum{
	public static void main(String[] args) {
		target(new int[]{4,2,7,1,3}, 5, 10);
	}
	static boolean target(int[] arr, int n, int target){
		boolean[][] dp = new boolean[n+1][target+1];
		for(int i=0;i<n+1;i++){
			for(int j=0;j<target+1;j++){
				if(j==0){
					dp[i][j] = true;
				}
				else if(i==0){
					dp[i][j] = false;
				}
				else{
					if(j-arr[i-1]>=0){
						dp[i][j] = dp[i-1][j]||dp[i-1][j-arr[i-1]];
					}else{
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}
		for(int i=0;i<n+1;i++){
			for(Boolean j:dp[i]){
				System.out.print(j+" ");
			}
			System.out.println();
		}
		return dp[n][target];
	}
}