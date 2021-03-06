import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = br.readLine();
        
        Integer size = Integer.parseInt(x);
       
        int max = Integer.MIN_VALUE;    
       
        while(size > 0) {
        	String line = br.readLine();
        	String[] arrOfStr = line.split(" "); 
        	for (int j = 1; j < arrOfStr.length; j++) {
        		if(Integer.parseInt(arrOfStr[j]) > max) {
                	max = Integer.parseInt(arrOfStr[j]);
                }
        	}
        	size--;
        }
        System.out.println(max);
	}
}