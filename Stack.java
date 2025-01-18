import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

public class Stack <Item> implements Iterable<Item>{

	private class Node{
		Item value ;
		Node next ;
	}
	
	Node top ;

	public Iterator<Item> iterator( ){ return new ListOfItems( ) ; }
	
	private class ListOfItems implements Iterator<Item>{
		Node node = top ;
		public boolean hasNext( ){ return node != null ; }
		public Item next( ){
			Item prev = node.value;
			node = node.next ;
			return prev ;
		}
	}	

	public void push(Item item ){
		Node node = new Node( );
		node.value = item ;
		node.next = top;
		top = node ;
	}
	public Item pop( ){
		Item val = top.value ;
		top = top.next ;
		return val ;
	}
	public static void main( String[] args){
		Stack<String> s = new Stack<String>( ) ;
		while( !StdIn.isEmpty( )){
			String value = StdIn.readString( );
			//if( value.equals("-")) System.out.println(s.pop( ) );
			//else s.push( value);
			s.push( value);
		}
		for( String word : s) System.out.println( word);
	}
}