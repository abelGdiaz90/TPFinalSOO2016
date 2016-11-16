
public class Aritmetica {

	public static void main(String[] args) {
		int list1[] = {1,2,3,4,5,6} ;
		int list2[] = {10,9,8,7,6,5,4,3,2,1};
		System.arraycopy(list1, 0, list2, 0, list1.length);
		for (int i = 0; i < list2.length; i++) {
			System.out.println(list2[i]);
		}
	}

}
