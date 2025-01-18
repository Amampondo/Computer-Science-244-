import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.lang.Math;

public class PercolationStats{
	private Percolation sys ;
	private double[] results ;
	private int T ;
	public PercolationStats( int n , int trials){
		validate( n);
		validate( trials);
		results = new double[trials] ;
		T = trials ;
		for( int t = 0 ; t < trials ; t ++){
			Percolation sys = new Percolation(n);
			while(!sys.percolates( ) ){
				int randRow = StdRandom.uniformInt(1 , n + 1);
				int randCol = StdRandom.uniformInt(1 , n + 1);
				sys.open( randRow,randCol);
			}
			results[t] = (1.0 * sys.numberOfOpenSites())/( n*n) ;
		}
	}
	public double mean( ){
		return StdStats.mean( results);
	}
	public double stddev( ){
		return StdStats.stddev( results);
	}
	public double confidenceLo( ){
		return mean() - (1.96*stddev())/Math.sqrt( T) ;
	}
	public double confidenceHi( ){
		return mean() + (1.96*stddev())/Math.sqrt( T) ;
	}
	private void validate( int args){
		if( args < 0){
			throw new IllegalArgumentException( ) ;
		}
	}
	public static void main( String[] args){
		int n = Integer.parseInt( args[0]) ;
		int trials = Integer.parseInt( args[1]);
		PercolationStats stats = new PercolationStats( n , trials);
		double mean = stats.mean( );
		double stddev = stats.stddev( );
		double[] interval = {stats.confidenceLo() , stats.confidenceHi() } ;
		
		System.out.printf("mean" + "%21S" + "= " + mean + "\n" ,"");
		System.out.printf("stddev" + "%18S " + "= " + stddev + "\n" ,"" );
		System.out.println( "95% confidence interval" + "\t " + "= " + "[" + interval[0] + "," +interval[1] + "]"  );
	}
}