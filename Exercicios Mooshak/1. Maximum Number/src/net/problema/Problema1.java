package net.problema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Scanner;

public class Problema1 {
	
	public static void main(String[] args) throws IOException {
		
		//Scanner scanner = new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = br.readLine();
		
        ArrayList<String> arrayLines = new ArrayList<>();
        arrayLines.add(x);
        
        int size = Integer.parseInt(x);
        int auxiliar = size;
        
        
        System.out.println("Size: " + size);
        
        String[] array = new String[20];
     
        
        String str = "2 3 4"; 
        String[] arrOfStr = new String[20]; 
        int max = 0;
        
        //for (String a : arrOfStr) 
        //    System.out.println(a);  
        
        //System.out.print(arrOfStr[0]);
       
        while(size > 0) {
        	String line = br.readLine();
        	arrOfStr = line.split(" "); 
        	for (String a : arrOfStr) 
                if(Integer.parseInt(a) > max) {
                	max = Integer.parseInt(a);
                }
        	//i++;
        	size--;
        }
        
        System.out.print("Max: " + max);
        
        
        
        //ArrayList[][] array = new ArrayList[20][20];
        //array[0][0] = new ArrayList();
        
        /*int i = 0;
        
        int line2 = Integer.parseInt(br.readLine());
        System.out.print(line2);
        
        while(size > 0) {
        	String line = br.readLine();
        	System.out.println(size);
        	System.out.println(line);
        	//System.out.println("Line: " + line);
        	arrayLines.add(line);
        	//i++;
        	size--;
        }
        
        System.out.println("-----------------------");
        
        //System.out.print(arrayLines.get(1));
        for(int j = 1; j <= auxiliar; j++) {
        	System.out.println(j);
        	System.out.println(arrayLines.get(j));
        }*/
        
      
        
        
        //System.out.println(array[0][0].get(0));
        //String line_size = scanner.nextLine();
        //int size = Integer.parseInt(line_size);
        //String line;
        
        /*while(size > 0){
            line = scanner.nextLine();
        
              int size2 =  Integer.parseInt(line);
              
              while(size2 > 0) {
            	  String line2 = scanner.nextLine();
                  arrayLines.add(line2);
                  size2--;
              }
                  
            size--;
        }
        
        int max = 0;
        
        for(int i = 0; i < arrayLines.size(); i++) {
        	if(Integer.parseInt(arrayLines.get(i)) > max) {
        		max = Integer.parseInt(arrayLines.get(i));
        		
        	}
        }*/
        //System.out.print(max);		
	}

}

//ler linha a linha
// Example of input given: 4 3 5 12 2 0 3 25 5 17 5 2 4 2 10 21
//ayj2Q9
