import edu.princeton.cs.algs4.StdIn;

public class LinkedStackOfStrings{
	private MyNode data ;
	public LinkedStackOfStrings( ){
		
	}
	public void push(String arg){
		MyNode node = new MyNode( );
		node.setData(arg) ;
		node.setNext(data);
		data = node ;
		
	}
	public String pop( ){
		if( data != null ){
			String val = data.getData( ) ;
			data = data.getNext( );
			return val ;
		}else{
			System.out.println("Pop unsuccessful");
			return null ;
		}
	}
	public static void main(String[] args ){
		LinkedStackOfStrings strings = new LinkedStackOfStrings( ) ;
		while( !StdIn.isEmpty( )){
			String string = StdIn.readString();
			
			if( string.equals("-")){
				System.out.println(strings.pop( ));
			}else{
				strings.push(string);
			}
		}
	}
}