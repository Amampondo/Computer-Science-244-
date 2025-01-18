import edu.princeton.cs.algs4.StdIn;
public class StackOfStrings{
	
	private String[] strings = new String[0];
	public StackOfStrings( ){

	}
	public void push( String s){
		String[] newStrings = new String[strings.length + 1] ;
		System.out.println( strings.length);
		if(strings.length == 0 ){
			newStrings[0] = s ;
			strings = newStrings ;
		}else{
			for(int i = 0 ; i < strings.length ; i++ ){
			newStrings[i] = strings[i] ;
			}
			newStrings[strings.length] = s ;
			strings = newStrings ;
		}
			
	}
	public String pop( ){
		String[] newStrings = new String[strings.length - 1] ;
		if( newStrings.length != 0){	
			for(int i = 0 ; i < newStrings.length ; i++ ){
				newStrings[i] = strings[i] ;
			}
		}
		String str = strings[strings.length - 1] ;
		strings = newStrings ;
		return str ;
	}
	public String[] getStrings( ){
		return strings ;
	}
	public static void main(String[] args ){
		StackOfStrings strings = new StackOfStrings( ) ;
		while( !StdIn.isEmpty( )){
			String string = StdIn.readString();
			
			if( string.equals("-")){
				if( strings.getStrings( ).length == 0){
					throw new IllegalArgumentException("no vals to pop");
				}else{
					System.out.println(strings.pop( ));
				}
			}else{
				strings.push(string);
			}
		}

	}
}