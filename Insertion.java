public class Insertion{

	public static void sort(Comparable[] a){
		for( int i = 0 ; i < a.length ; i ++ ){
			int j = i ;
			while( j >= 1 ){
				if( less(a[j],a[j - 1]) ) exch(a,j,j-1) ;
				else break
				j -- ;
			}
		}
	}
	private static boolean less(i,j){
		if( i.compareTo(j) == -1 ) return true ;
		return false ;
	}
	private static void exch(Comparable[] a ,int i ,int j ){
		
		Comparable temp = a[i] ;
		a[i] = a[j] ;
		a[j] = temp ;
	}
	private static boolean isSorted( Comparable[] a){
		int N = a.length ;
		for( int i = 1 ; i < N ; i ++){
			if(a[i].compareTo(a[i - 1]) == -1 ) return false ;
		}
		return true ;
	}
	public static void main(String[] args ){
		Integer[] a = {9,8,7,6,5} ;
		sort(a);
		for( int i : a){
			System.out.println( i);
		}
	}
}