
public class PercolationDFSFast extends PercolationDFS {

	public PercolationDFSFast(int n) {
		super(n);
	}

	@Override
	protected void updateOnOpen(int row, int col) {
		if (row == 0) dfs(0,col);
		
		int[]a = {-1,0,0,1};
        int[]b = {0,-1,1,0};
        for (int x = 0; x < 4; x++) {
        	if (inBounds(row+a[x], col+b[x])) {
        		if (isFull(row+a[x], col+b[x])) dfs(row,col);
	        }
		}
			
		/*if (inBounds(row-1,col)) {
			if (isFull(row-1, col)) dfs(row,col);
		}
		if (inBounds(row,col-1)) {
			if (isFull(row, col-1)) dfs(row,col);
		}
		if (inBounds(row,col+1)) {
			if (isFull(row, col+1)) dfs(row,col);
		}
		if (inBounds(row+1,col)) {
			if (isFull(row+1, col)) dfs(row,col);
		}*/
	} 
}
