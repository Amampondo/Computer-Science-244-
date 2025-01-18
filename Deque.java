import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException ;

public class Deque<Item> implements Iterable<Item>{
	private Node first ;
	private Node last ;
	private int length = 0 ;
	private class Node{
		Item value ;
		Node previous ;
		Node next ;
	}

	public Deque( ){

	}
	public void addFirst(Item item ){
		if( item == null) throw new IllegalArgumentException( ) ;
		Node node = new Node( ) ;
		node.value = item ;
		node.next = first ;
		if( length == 0) last = node ;
		else first.previous = node ;
		first = node ; 
		length ++ ;
	}
	public void addLast(Item item ){
		if( item == null) throw new IllegalArgumentException( ) ;
		Node node = new Node( );
		node.previous = last ;
		node.value = item ;
		if( length == 0) first = node ;
		else last.next = node ;
		last = node;
		length ++ ;
	}
	public Item removeFirst( ){
		if( length == 0) throw new NoSuchElementException( );
		Item value = first.value ;
		first = first.next ;
		if( length ==  1) last = last.next ;
		else first.previous = null ;
		length -- ;
		return value ;
	}
	public Item removeLast( ){
		if( length == 0) throw new NoSuchElementException( );
		Item value = last.value ;
		last = last.previous;
		if( length ==  1) first = first.next ;
		else last.next = null ;
		length -- ;
		return value ;
	}
	public int size( ){ return length ; }
	public boolean isEmpty( ){ return length == 0 ; }
	public Iterator<Item> iterator( ){ return new ListOfItems( );}
	private class ListOfItems implements Iterator<Item>{
		Node node = first ;
		int count = 0 ;
		public boolean hasNext( ){ return node != null ;}
		public Item next( ){
			if( count >= length) throw new NoSuchElementException( );
			Item value = node.value ;
			node = node.next ;
			count ++ ;
			return value ;
		}
		public void remove( ){ throw new UnsupportedOperationException( ); }
	}
	public static void main(String[] args ){
		int[] front = {2,3,5,6} ;
		String[] back = {"a" , "b" ,"c" ,"d" } ;
		Deque<Integer> deckF = new Deque<Integer>( );
		Deque<String> deckB = new Deque<String>( );
		Deque<Integer> deck = new Deque<Integer>( );

		for( int i = 0 ; i < front.length ; i ++ ){
			deckF.addFirst(front[i] );
			deckB.addLast(back[i] );
		}
		for( int i = 0 ; i < front.length ; i ++){
			System.out.println( deckF.removeFirst( ));
			System.out.println( deckB.removeLast( ));
		}
		System.out.println( deck.isEmpty( ));
		System.out.println( deck.size( ));
	
		for( int i = 0 ; i < front.length ; i ++ ){
			deck.addFirst(front[i] );
		}
		for( int i : deck){
			System.out.println( i);
		}
	}	
}