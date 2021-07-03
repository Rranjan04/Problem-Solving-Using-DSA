package Graphs.Graph;

public class KnightsTour {
	public static void main(String[] args) {
		
	}
	static void print(int[][] chess){
		for(int i=0;i<chess.length;i++){
			for(int j =0;j<chess[0].length;j++){
				System.out.print(chess[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void knightsTour(int[][] chess,int r,int c, int move){
		if(r<0||c<0||r>=chess.length||c>=chess[0].length||chess[r][c]!=0) return;
		if(move==chess.length*chess.length){
			chess[r][c] = move;
			print(chess);
			chess[r][c] = 0;//backtracking
			return;
		}
		chess[r][c] = move;
		knightsTour(chess, r-2,c+1, move+1);
		knightsTour(chess, r-2,c-1, move+1);
		knightsTour(chess, r-1,c+2, move+1);
		knightsTour(chess, r-1,c-2, move+1);
		knightsTour(chess, r+2,c+1, move+1);
		knightsTour(chess, r+2,c-1, move+1);
		knightsTour(chess, r+1,c-2, move+1);
		knightsTour(chess, r+1,c+2, move+1);
		chess[r][c]=0;
	}
}
