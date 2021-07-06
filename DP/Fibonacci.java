package DP;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int ans = fibRec(n);
		System.out.println(ans);
		scn.close();
	}
	public static int fibMem(int n,int[] t){
		if(n==1||n==0) return n;
		if(t[n]!=-1) return t[n];
		int fib1 = fibMem(n-1,t);
		int fib2 = fibMem(n-2,t);
		return t[n] = fib1+fib2;
	}
	public static int fibRec(int n){
		if(n==1||n==0) return n;
		int fib1 = fibRec(n-1);
		int fib2 = fibRec(n-2);
		return fib1+fib2;
	}
}
