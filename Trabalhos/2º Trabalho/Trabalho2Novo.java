import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Hard_Weeks {
	
    private final List<List<Integer>> graph;
    private final int T; //number of tasks
    private final int[] number_of_precedences;
    private final int L; //limit used in the definition of hard week

    public Hard_Weeks(int T, int L) {
    	
        this.T = T; //save T
        this.L = L; //save L
        
        this.number_of_precedences = new int[T]; //T is maximum-precedences for each task
        
        this.graph = new ArrayList<>(T); //graph with size equal to number of tasks
        
        for (int i = 0; i < T; i++) {
            graph.add(new ArrayList<>()); //to save adjacent nodes for each task
        }
    
    }
    
    public void increase_number_of_precedences(int t) { //to increase number of precedences for this task
    	number_of_precedences[t]++;
    }
    
    public void decrease_number_of_precedences(int t) { //to decrease number of precedences for this task
    	number_of_precedences[t]--;
    }

    public void priority(int t1, int t2) {
        graph.get(t1).add(t2); //to add precedence of t1 over t2
        increase_number_of_precedences(t2); 
    }

    public int[] calculate() {
    	
        int[] score = new int[2]; //to final print
        
        Queue<Integer> queue = new LinkedList<>(); //new queue
        
        for (int t = 0; t < T; t++) { //for each task, if number_of_precedences is equal to zero (without precedence) add to queue of tasks to be performed
            if (number_of_precedences[t] == 0) {
            	queue.add(t);
            }
        }

        while (!queue.isEmpty()) {
        	
        	int aux = score[0];
        	
        	if(queue.size() > aux) { //max between score[0] (previous max tasks) and size of queue (tasks to be performed)
        		score[0] = queue.size();
        	}else {
        		score[0] = aux;
        	}
        	
            
            if(queue.size() > L) { //if number of tasks in a day > that L (Limit to be a hard week)
            	score[1] = score[1] + 1;
            }else { 
            	score[1] = score[1] + 0;
            }
        
            for (int sz = queue.size(); sz > 0; sz--) {
                int removed_task = queue.remove();
                
                List<Integer> Adjacent_Nodes = graph.get(removed_task);
                
                for (int x : Adjacent_Nodes) {
                	decrease_number_of_precedences(x); //decrease number_of_precedences
                    if (number_of_precedences[x] == 0) //if number_of_precedence is equal to zero (without precedence) add to queue of tasks to be performed
                    	queue.add(x);
                }
            }
        }
        return score;
    }
}

public class Trabalho2Novo {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");
        
        int T = Integer.parseInt(tokens[0]); // number of tasks
        int P = Integer.parseInt(tokens[1]); // number of (distinct) direct precedences 
        int L = Integer.parseInt(tokens[2]); // limit used in the definition of hard week
        
        if(T < 2 || T > 30000) { //All limits
			System.out.println("Error in number of tasks. -> ( 2 <= T <= 30 000 )");
			System.exit(0);	
        }else if(P < 1 || P > 300000) {
        	System.out.println("Error in number of direct precedences. -> ( 1 <= P <= 300 000 )");
			System.exit(0);	
        }else if(L < 1 || L >= T) {
        	System.out.println("Error in limit used in the definition of hard week. -> ( 1 <= L <= T )");
			System.exit(0);	
        }
			
        Hard_Weeks h_w = new Hard_Weeks(T, L); //initialization

        for (int i = 0; i < P; i++) { //direct precedences
            tokens = reader.readLine().split(" ");
            
            int t1 = Integer.parseInt(tokens[0]); //first integer
            int t2 = Integer.parseInt(tokens[1]); //second integer

            h_w.priority(t1, t2); //to save priorities among tasks (t1 over t2)
        }

        int[] score = h_w.calculate(); //to get the final output
        
        System.out.println(score[0] + " " + score[1]); //final print
    }
}


/*
Input example given

12 14 1
0 5
0 6
1 0
1 6
1 7
7 2
5 8
8 9
10 3
8 6
4 10
7 9
4 11
6 7

Output we should receive

3 4
*/