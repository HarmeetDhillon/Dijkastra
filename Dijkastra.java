package discreteLab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

	public class Dijkastra {
		
		private static Scanner node;
		private static final int MAX_VALUE = 999;
		
	public static void main(String[] args) {
		   
		    node = new Scanner(System.in);
			System.out.println("Please Enter The Number Of Nodes Of The Adjacency Matrix: ");
			
			ArrayList<Integer> a1 = new ArrayList<Integer>();
			int N = node.nextInt();
			int[][] Adjmatrix = new int [N][N];// variable to define the matrix 
			int[] TempDist = new int[N];// variable to keep track of temporary distance for swapping purposes
			int[] visited = new int[N];// variable to keep track of the visited nodes
	        System.out.println("Press '1' If You Want To Generate Matrix Randomly");
	        System.out.println("OR"); 
	        System.out.println("Press '2' If You Want To Create Matrix Manually "); 
	        int input = node.nextInt();
	        
	        if (input == 1)
	        {
	        	Random rand = new Random(); // To generate the matrix with random numbers.
	        	rand.setSeed(System.currentTimeMillis()); 
	        
	        	for(int i = 0; i < N; i++)
	        	{
	        		System.out.print("\t" +(int)(i) + ")");
				
	        	}

	        	for (int i = 0; i < N; i++)
	        	{   
	        		TempDist[i] = 0 ;
	        		visited[i] = 0;
	        	
	        		System.out.println("\n");
	        		System.out.print((int)(i) + ")\t");
	        		for (int j = 0; j < N; j++)
	        		{
	                    Integer r = rand.nextInt()% 4; //to select number range till 4 
	        	        Adjmatrix[j][i] = Adjmatrix[i][j] = Math.abs(r);
	        			System.out.print(Adjmatrix[i][j] + "\t");
	                
	        			if(Adjmatrix[i][j]==0)
	        			{
	        				Adjmatrix[i][j] = MAX_VALUE; // make the zeros as 999 so that zero is considered as no edge between vertices
	        			}  
	        		}
	        	}
	        }
	        	
	        else if (input == 2)
	    	   {
	    		   System.out.println("Please Enter The Matrix !!!  ");
	    		   for(int i = 0; i < N; i++)
	    		   {
	    			   visited[i] = 0; //to keep track of the visited nodes
	    			   TempDist[i] = 0; // to keep track of the initial distance
	    			   for(int j = 0; j <N; j++)
	    			   {
	    				   System.out.println("("+i+","+j+")-> "+ (Adjmatrix[i][j] = Adjmatrix[j][i]= node.nextInt())); //to print the matrix
	    				   if(Adjmatrix[i][j]==0)
	    				   { 
	   						Adjmatrix[i][j] = MAX_VALUE; // make the zeros as 999 so that zero is considered as no edge between vertices
	   			    	   }
	    			    }
	    		    }
	    		
	    	   }
	        else 
	        {
	        	System.out.println("Invalid Input !!!");
	        	System.exit(0);
	        }

	    	//Select the Source node 
	    	System.out.println("\n");
	    	System.out.println("Please Select a SOURCE node from 0 to " + (N-1));
	    	int M = node.nextInt();// variable to store the source node
	        
	    	//Select the Destination node
	    	System.out.println("Please Select a DESTINATION node from 0 to " + (N-1));
	        int M1 = node.nextInt(); //Variable to store the Destination node
	        
	        
	    	int MinDist = MAX_VALUE,//  holds the minimum value
	    	nextNode = 0; //variable to store the value for next node.
	    	int[] ActualDist = new int[N]; // Variable to store distance of the vertices
	  
	    	ActualDist = Adjmatrix[M]; //initialize the distance array with the source node
	    	visited[M] = 1; //set the source node as visited to keep its track
	    	ActualDist[M] = 0; //set the distance from source to zero which is the starting point
	    	
	    	
	    	
	    	if (M == M1)
	    	{
	    		System.out.println("Source and Destination can not be same!!!");
	    		System.out.println("Re-enter the Destination node from 0 to " + (N-1));
	    		M1 = node.nextInt();
	    	}
	    	
	    	//START OF THE ACTUAL ALGORITHM
	    	
	    	
	    	for(int counter = M; counter <= M1; counter++) //To loop over all nodes from the source and destination 
	    	{ 
	    		for(int i = M; i <= M1; i++)
	    		{
	    			if(MinDist > ActualDist[i] && visited[i]!=1)// check the minimum distance of the node visited
	    			{
	    				MinDist = ActualDist[i];
	    				nextNode = i;
	    			}
	    		}
	    		
	    		visited[nextNode] = 1;//to check if we have already visited the node 
	    		
	    		for(int i = M; i <= M1; i++)
	    		{
	    			
	    			if(visited[i]!=1){ //if we have not visited the node before then go to this condition loop
	    				
	    				if(MinDist+Adjmatrix[nextNode][i] < ActualDist[i]) {//compare if distance calculated before is less than the min distance
	    					
	    					ActualDist[i] = MinDist + Adjmatrix[nextNode][i];
	    					TempDist[i] = nextNode;
	    					}
	    				}
	    			}
	    	}
	    	/*
	    	 * Below loop will print the result for the shortest path
	    	 */
	    			System.out.println("\n");
	    			System.out.print("Shotest Path from Node " + M + " to " + M1 + " is : " );
	    			int j = M1;
	    			while(j!=0) 
	    			{
	    				a1.add(j);
	    				j=TempDist[j];
	    			}
	    			a1.add(M);
	    			Collections.reverse(a1);
	    			System.out.println(a1);
	    		
	    		System.out.println();
	    		System.out.println("Total Distance of the traversed vertices is : " +  ActualDist[M1]);
	    		System.out.println();
	    		System.out.println("The Program will check all the possible path between the nodes and will  ");
	            System.out.println("calculate the shortest path between the edge!!");

	    }
	}
	    
		









