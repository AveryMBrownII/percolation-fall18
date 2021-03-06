
public class PercolationDFSFast extends PercolationDFS {

	public PercolationDFSFast(int n) {
		super(n);
	}

	@Override
	protected void updateOnOpen(int row, int col) {
		if (row == 0) dfs(0,col);
		
		else {
			boolean check = false;
			int[]a = {-1,0,0,1};
		    int[]b = {0,-1,1,0};
		    for (int x = 0; x < 4; x++) {
		    	if (inBounds(row+a[x], col+b[x])) {
		    		if (isFull(row+a[x], col+b[x])) check = true;
		        }
			}
		    if (check == true) dfs(row,col);
		}
	} 
}
