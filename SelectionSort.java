public class SelectionSort{
	private static boolean less(Comparable a , Comparable b ){
		return a.CompareTo(b) < 0 ;
	}
	private static void exch(Comparable[] a ,int i , int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp ;
	}
	private static boolean isSorted(Comparable[] a){
		for( int i = 1, i < a.length , i ++){
			if( less(a[i],a[i-1])) return false;
		}
		return true ;
	}
	private static void show( Comparable[] a){
		for(Comperable item : a ){
			System.out.print( item + " ");
		}
		System.println( );
	}
	public static void main(String[] args){
		String[] a = In.readStrings( );
		sort(a);
		assert( isSorted(a));
		show(a);
	}
}