package Graphs.Graph;


public class Word {
	public static void main(String[] args) {
		 
	}
	int[][] pos = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	String pattern = "FINDME";
	int[][] used;
	boolean isValid(int x, int y, int N, int M){
		if(x>=0 && y>=0 && x<N && y<M) return true;
		return false;
	}
	boolean DFS(String[] graph, int x, int y, int index, int N, int M){
		if(index==6) return true;
		used[x][y] = 1;
		int i,newX,newY;
		boolean found=false;
		for(i=0;i<8;i++){
			newX = x+pos[i][0];
			newY = y+pos[i][1];
			if(isValid(newX, newY, N, M) && graph[newX].charAt(newY)==pattern.charAt(index) && used[newX][newY]==0){
				found = found| DFS(graph,newX,newY,index+1,N,M);
			}
		}
		used[x][y]=0;
		return found;
	}
	boolean solve(String[] graph, int N, int M){
		int i,j;
		boolean found= false;
		for( i=0;i<N;i++){
			for(j=0,found=false;j<M;j++){
				if(graph[i].charAt(j)=='F'){
					found = DFS(graph,i,j,1,N,M);
					if(found) break;
				}
			}
			if(found) break;
	}
	return found;
}
}
