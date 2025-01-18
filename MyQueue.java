import edu.princeton.cs.algs4.StdIn;

public class MyQueue{
	private MyNode start ;
	private int count = 0;
	public void enqueue( String arg){
		MyNode node = new MyNode( );
		node.setData(arg);
		node.setNext(start);
		start = node ;
		count ++ ;
	}
	public String dequeue( ){
		
		MyNode node = start ;
		if(count ==  1){
			start = null ;
			return node.getData( );
		}
		for( int i = 0 ; i < count - 2 ; i ++){
			node = node.getNext( );
		}
		
		String val = node.getNext( ).getData( );
		node.setNext( null);
		count -- ;
		return val ;
	}
	public boolean isEmpty( ){
		return count == 0 ;
	}
	public static void main(String[] args ){
		MyQueue strings = new MyQueue( ) ;
		while( !StdIn.isEmpty( )){
			String string = StdIn.readString();
			
			if( string.equals("-")){
				System.out.println(strings.dequeue( ));
			}else{
				strings.enqueue(string);
			}
		}
	}
	
}