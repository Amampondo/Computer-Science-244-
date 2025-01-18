import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException ;

public class RandomizedQueue<Item> implements Iterable<Item>{
	private Item[] q = ( Item[] ) new Object[2];
	private int count = 0 ;
	public RandomizedQueue( ){

	}
	public boolean isEmpty( ){
		return count == 0 ;
	}
	public int size( ){
		return count ;
	}
	public void enqueue( Item item){
		if( item == null) throw new IllegalArgumentException( ) ;
		if( count >= ( q.length/2) ){
			Item[] newQ = ( Item[] ) new Object[q.length * 2];
			System.arraycopy(q,0,newQ,0,q.length );
			q = newQ ;
		}
		q[count] = item ;
		count ++ ;
	}
	public Item dequeue( ){
		if( count == 0) throw new NoSuchElementException( );
		if( count <= ( q.length/4)){
			Item[] newQ = ( Item[] ) new Object[q.length / 2];
			System.arraycopy(q,0,newQ,0,newQ.length );
			q = newQ ;
		}
		
		int r = StdRandom.uniformInt(0 , count );
		Item val = q[r] ;
		Item[] newQ =  ( Item[] ) new Object[q.length];
		System.arraycopy(q,0,newQ,0,r);
		System.arraycopy(q,r +  1,newQ,r,q.length - r - 1 );
		q = newQ;
		count -- ;
		return val ;
	}
	public Item sample( ){
		return q[StdRandom.uniformInt(0,count)] ;
	}
	public Iterator<Item> iterator( ) { return new RandomList( ) ;}
	private class RandomList implements Iterator<Item>{
		int length = 0 ;
		public boolean hasNext( ) { return length < count ;}
		public Item next( ){ 
			if( length >= count) throw new NoSuchElementException( );
			length ++ ;
			return sample( ) ;
		}
	}
	public static void main( String[] args){
		RandomizedQueue<Integer> q = new RandomizedQueue<Integer>( );
		int[] nums = {9,8,7,6,5} ;
		for( int num : nums){ q.enqueue(num) ;}
		for( int num : q){ System.out.println( num) ;}
	}
}