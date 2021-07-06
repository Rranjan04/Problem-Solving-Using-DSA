package DP;

public class ClimbStairs {
	public static void main(String[] args) {
		countPathTab(3);
	}
	static int countPathTab(int n){
		int[] t = new int[n+1];
		t[0] = 1;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=3;j++){
				if(i-j>=0){
					t[i] += t[i-j];
				}
			}
		}
		for(int i:t){
			System.out.print(i+" ");
		}
		return t[n];
	}
	static int countPathMem(int n,int[] t){
		if(n<0) return 0;
		if(n==0) return 1;
		if(t[n]!=-1) return t[n];
		int nm1 = countPathMem(n-1,t);
		int nm2 = countPathMem(n-2,t);
		int nm3 = countPathMem(n-3,t);
		int cp = nm1+nm2+nm3;
		return t[n] = cp;
	}
	static int countPathRec(int n){
		if(n<0) return 0;
		if(n==0) return 1;
		int nm1 = countPathRec(n-1);
		int nm2 = countPathRec(n-2);
		int nm3 = countPathRec(n-3);
		int cp = nm1+nm2+nm3;
		return cp;
	}
}
