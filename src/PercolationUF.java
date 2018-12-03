
public class PercolationUF implements IPercolate {

	boolean[][]myGrid;
	Integer myOpenCount;
	IUnionFind myFinder;
	private final int VTOP;
	private final int VBOTTOM;
	
	
	public PercolationUF(int size, IUnionFind finder) {
		myGrid = new boolean[size][size];
		myOpenCount = 0;
		myFinder = finder;
		finder.initialize((size*size)+2);
		VTOP = (size*size);
		VBOTTOM = (size*size)+1;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				myGrid[r][c] = false;
			}
		}
	}
	
	@Override
	public void open(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col)); 
		}
		if (myGrid[row][col] != false) return;
		myOpenCount += 1;
		myGrid[row][col] = true;
	    if (row == 0) myFinder.union(((row * myGrid.length) + col), VTOP);
    	if (row == myGrid.length-1) myFinder.union(((row * myGrid.length) + col), VBOTTOM);
    	int[]a = {-1,0,0,1};
	    int[]b = {0,-1,1,0};
	    for (int x = 0; x < 4; x++) {
	    	if (inBounds(row+a[x], col+b[x])) {
	    		if (isOpen(row+a[x], col+b[x])){
	    			myFinder.union(((row * myGrid.length) + col),(((row+a[x]) * myGrid.length) + (col+b[x])));
	    		}
	        }
		}
	}

	@Override
	public boolean isOpen(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myGrid[row][col];
	}

	@Override
	public boolean isFull(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myFinder.connected(((row * myGrid.length) + col), VTOP);
	}

	@Override
	public boolean percolates() {
		return myFinder.connected(VTOP, VBOTTOM);
	}

	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}
	
	protected boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}
	
}
