package assign7;

import java.util.Random;

public class Timing {

	public static void main(String[] args) {

		// Do 10000 lookups and use the average running time.
		int timesToLoop = 1000;

		// For each problem size n . . .
		for (int n = 10000; n <= 200000; n += 10000) {
			// Setup of n size for testing
			long startTime, midpointTime, stopTime;

			/*
			 * Testing of MyStack Methods for O(1) behavior
			 * Uncomment for testing
			 */
			
			//MyStack testStack = new MyStack();
			
			/*
			 * MyStack peek setup
			 * Randomly generate numbers 1 to N, push onto stack. 
			
			Random rng = new Random(n);
			
			for(int i = 0; i < n; i++)
			{
				testStack.push(rng.nextInt(n));
			}
			
			*/
			
			/*
			 * MyStack pop setup
			 * Randomly generate numbers 1 to N, push onto stack. 
			
			Random rng = new Random(n);
			
			for(int i = 0; i < n; i++)
			{
				testStack.push(rng.nextInt(n));
			}
			*/
			
			/*
			 * MyStack push setup
			 
			Random rng = new Random(n);
			*/
			
			/*
			 * Testing of MyPriorityQueue for O(1) behavior
			 */
			
			//MyPriorityQueue testPQ = new MyPriorityQueue();
			
			/*
			 *MyPriorityQueue insert setup 
			 
			Random rng = new Random(n);
			*/
			
			/*
			 * MyPriorityQueue FindMin setup
			 
			Random rng = new Random(n);
			for(int i = 0; i < n; i++)
			{
				testPQ.insert(rng.nextInt(n));
			}
			*/
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Now, run the test.
			startTime = System.nanoTime();

			// Run the methods for testing
			
			for (int i = 0; i < timesToLoop; i++) {
				
				/*
				 *MyStack Peek Testing 
				 
				testStack.peek();
				testStack.push(1);
				testStack.pop();
				*/
				
				/*
				 *MyStack Pop Testing 
				 
				testStack.pop();
				testStack.push(1);
				testStack.pop();
				*/
				
				/*
				 * MyStack Push Testing
				 
				testStack.push(rng.nextInt(n));
				testStack.push(1);
				testStack.pop();
				*/
				
				/*
				 * MyPriorityQueue Insert Testing
				 
				
				testPQ.insert(rng.nextInt(n));
				*/
				
				/*
				 * MyPriorityQueue findMin testing
				 
				testPQ.findMin();
				*/
	
			}

			midpointTime = System.nanoTime();

			// Time it takes to run loop
			
			for (int i = 0; i < timesToLoop; i++) {
				/*
				 *MyStack Peek Testing 
				 
				testStack.push(1);
				testStack.pop();
				*/
				
				/*
				 * MyStack Pop Testing
				 
				testStack.push(1);
				testStack.pop();
				*/
				
				/*
				 *MyStack Push Testing
				 
				testStack.push(1);
				testStack.pop();
				*/
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;

			System.out.println(averageTime);

		}

	}

}
