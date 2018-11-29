import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {

	public PercolationBFS(int n) {
		super(n);
	}
	
	@Override
	protected void dfs(int row, int col) {
		
		// out of bounds?
		if (! inBounds(row,col)) return;
		
		// full or open, don't process
		if (isFull(row, col) || !isOpen(row, col))
			return;
		
		myGrid[row][col] = FULL;
		Queue<Integer> qj = new LinkedList<Integer>();
		Integer num = (row * myGrid.length) + col;
		qj.add(num);
		while (qj.size() != 0){
            int value = qj.remove();
            int trow = value/(myGrid.length);
            int tcol = value%(myGrid.length);
            int[]a = {-1,0,0,1};
            int[]b = {0,-1,1,0};
            for (int x = 0; x < 4; x++) {
            	if (isOpen(trow+a[x], tcol+b[x]) && !isFull(trow+a[x], tcol+b[x])) {
                	myGrid[trow+a[x]][tcol+b[x]] = FULL;
                	num = ((trow+a[x]) * myGrid.length) + (tcol+b[x]);
            		qj.add(num);
            	}
            }
		}
	}
}
