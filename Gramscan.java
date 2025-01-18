import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.StdRandom;
public class Gramscan{
	private Draw canvas ;
	private Point[] points ;
	private Node<Point> endPoint = null ;
	private Node<Double> endAngle = null ;
	private int j = 0 ;

	public Gramscan(int n){
		canvas = new Draw( );
		canvas.setScale(0.0,20.0);
		genPoints(n);
		findPolarAngles();
		Insertion.sort(this.points);
		plotPoints();
	}
	private static class Point implements Comparable{
		public double[] xy = new double[2] ;
		public double angle ;
		public Point(double x,double y){
			xy[0] = x ;
			xy[1] = y ;
		}
		public int compareTo(Point other){
			if( angle < other.angle) return 1;
			else if ( angle == other.angle ) return 0 ;
			else return - 1 ;
		}
	}
	private class Node<Item>{
		Item value ;
		Node<Item> next ;
	}
	private void genPoints(int n){
		this.points = new Point[n] ;
		for(int i = 0 ; i < n ; i ++ ){
			double x = StdRandom.uniformDouble(0.0 ,20.0);
			double y = StdRandom.uniformDouble(0.0,20.0) ;
			Point point = new Point(x,y);
			points[i] = point ;
		}
		findPolarAngles(this.points);
	}
	private static void findPolarAngles(){
		Point min = this.points[0] ;
		for( Point point : this.points){
			if(point.xy[1] < min.xy[1] ) min = point ;
		}
		for( Point point : points){
			point.angle = polarAngle(min , point) ;
		}
		min.angle = 0.0 ;
		
	}
	private static double polarAngle(Point pFirst , Point pSecond){
		double xFirst = pFirst.xy[0] ;
		double yFirst = pFirst.xy[1] ;
		double xSecond = pSecond.xy[0] ;
		double ySecond = pSecond.xy[1] ;
		double dx = xSecond - xFirst ;
		double dy = ySecond - yFirst ;

		if( dx > 0 & dy > 0) return Math.atan(dy/dx) ;
		else if ( dx < 0 & dy > 0) return Math.PI - Math.atan( -dy/dx) ;
		else if ( dx < 0 & dy < 0) return Math.PI + Math.atan( dy/dx) ;
		else if ( dx > 0 & dy < 0) return 2.0*Math.PI - Math.atan( -dy/dx) ;
	}
	private void plotPoint(Point point){
		canvas.filledCircle( point.xy[0],point.xy[1],0.2);
	}
	private void plotPoints(){
		for( Point point : this.points) plotPoint( point);
	}
	private void connect( Point first , Point second){
		this.canvas.setPenColor( Color BLUE);
		this.canvas.line( first.xy[0] , first.xy[1] , second.xy[0] , second.xy[1] );
		this.canvas.setPenColor( Color BLACK);
	}
	private void moveFoward( ){
		Node<Point> newPoint = new Node<Point>( ) ;
		newPoint.value = this.points[j]
		newPoint.next = endPoint ;
		endPoint = newPoint ;

		if( endPoint.next != null){
			Node<Double> angle = new Node<Double>( );
			angle.value = polarAngle( endPoint.next , endPoint.value);
			angle.next = endAngle ;
			endAngle = angle ;
		}
	}
	private boolean isNextAngleLess( ){
		if( this.endAngle = )
	}
	private void solve(){
		
		while( this.j < this.points.length) {
			moveFoward( );
			connect(endPoint.next.value , endPoint.value);
			his.j ++ ;
		}
	}
	public static void main(String[] args ){
		
	}
}