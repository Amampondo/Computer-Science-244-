import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
	private int[][] sites;
	private int openSites ;
	private WeightedQuickUnionUF uf ;
	private int length ;
	private int vId ;

	public Percolation( int n){
		validate( n);
		sites = new int[n][n];
		uf = new WeightedQuickUnionUF( n*n + 2);
		length = n ;
		vId = length*length ;
	}
	public void open( int row , int col){
		if( !isOpen( row,col)){
			sites[row-1][col-1] = 1	;
			flow( row,col);
			openSites ++ ;
		}
	}
	public boolean isOpen( int row , int col){
		validate( row);
		validate( col);
		return sites[row - 1][col - 1] == 1;
	}
	public boolean isFull(int row , int col){
		return uf.find( id(row,col )) == uf.find( vId);
	}
	public int numberOfOpenSites( ){
		return openSites ;
	}
	public boolean percolates( ){
		return uf.find( vId) == uf.find( vId + 1);
	}
	private void validate( int args){
		if( args < 0){
			throw new IllegalArgumentException( ) ;
		}
	}
	private int id( int row , int col){
		return length*( row - 1) + col - 1 ;
	}
	private void flow( int row , int col){
		// first or last row -> connect to virtual sites
		int oId = id( row,col);

		// connect to v sites
		if( row == 1){
			uf.union( oId , vId);
			if( isOpen( row + 1 , col)){
				uf.union(oId ,id( row + 1 , col) );
			}
		}else if( row == length){
			uf.union( oId , vId + 1);
			if( isOpen( row - 1 , col)){
				uf.union(oId ,id( row - 1 , col) );
			}
		}else{
			// non v sites
			if( isOpen( row-1,col)){
				uf.union( oId, id( row-1,col));
			}
			if( isOpen( row+1,col)){
				uf.union( oId , id( row+1,col));
			}
		}

		//first or last column -> ..
		if( col == 1){
			if( isOpen( row , col + 1)){
				uf.union(oId,id( row , col + 1) );
			}
		}else if ( col == length ){
			if( isOpen( row , col - 1)){
				uf.union(oId,id( row , col - 1) );
			}
		}else{
			if( isOpen( row , col + 1)){
				uf.union(oId,id( row , col + 1) );
			}
			if( isOpen( row , col - 1)){
				uf.union(oId,id( row , col - 1) );
			}
		}
	}
	private static float average(float[] args){
		float sum = 0 ;
		for( float num : args){
			sum += num ;
		}
		return sum/args.length ;
	}
	public static void main( String[] args){
		int trials = Integer.parseInt( args[0]) ;
		int n = Integer.parseInt(args[1] ) ;
		float[] results = new float[trials] ;

		for( int t = 0 ; t < trials ; t ++){
			Percolation sys = new Percolation(n);
			while(!sys.percolates( ) ){
				int randRow = StdRandom.uniformInt(1 , sys.length + 1);
				int randCol = StdRandom.uniformInt(1 , sys.length + 1);
				sys.open( randRow,randCol);
			}
			results[t] = (1.0f * sys.numberOfOpenSites())/( n*n) ;
		}
		System.out.println( "*p is " + average( results));
	}
}