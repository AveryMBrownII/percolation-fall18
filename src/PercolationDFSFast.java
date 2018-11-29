
public class PercolationDFSFast extends PercolationDFS {

	public PercolationDFSFast(int n) {
		super(n);
	}

	@Override
	protected void updateOnOpen(int row, int col) {
		if (row == 0) dfs(0,col);
		else if (isFull(row-1, col) == true) dfs(row,col);
		else if (isFull(row, col-1) == true) dfs(row,col);
		else if (isFull(row, col+1) == true) dfs(row,col);
		else if (isFull(row+1, col) == true) dfs(row,col);
	} 
}
