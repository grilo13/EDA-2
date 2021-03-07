public class Main {
	
	// Simple implementation of a Linear Search
	// Searchs in a list if a number is in there, if it is, returns the index of the number,
	// if not, returns -1s
	
	public static int LinearSearch(int[] list, int value) {
		
		for(int i = 0; i < list.length; i++) {
			if(list[i] == value) {
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		
		int[] list = {1,5,6,2,4,7};
		
		System.out.println("Index: " + LinearSearch(list,6));

	}

}
