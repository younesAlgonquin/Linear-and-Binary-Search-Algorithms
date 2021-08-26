import java.security.SecureRandom;
import java.util.Arrays;

/**
 * CET - CS Academic Level 3
 * This class implements a method that generates an array of random integers and sorts it.
 * then it declares methods for iterative & recursive binary & linear search of an integer within this array. 
 * Section #: 303
 * Course: CST8130 - Data Structures
 * @version 1.0
 * 
 */
public class BinaryLinearSearch {
	
	/**This is the array that will be used to perform the search*/
	private int[] randomArr;
	/**this the index of the user's integer if it exists within the array*/
	private int location;
	
	/**
	 * This is a parameterized constructor that initializes the randomArr array
	 * @param size this is the size of the randomArr array
	 */
	public BinaryLinearSearch(int size){
		
		randomArr= new int[size];
	}//end the parameterized constructor 
	
	/**
	 * This method generates an array of random integers sort it then prints it
	 * @return Returns a sorted array
	 */
	public int[] generateRandomInts() {
		
		//SecureRandom object which generates random integers 
		SecureRandom random = new SecureRandom();
		//this the generated integer
		int number;
		//generates random integers and stores them in randomArr
		for(int i=0; i<randomArr.length; i++) {
			number= random.nextInt(89) + 11;
			randomArr[i]=number;
		}//end for
		//sorts the elements of randomArr
		Arrays.sort(randomArr);
		//prints the elements of randomArr
		System.out.print(Arrays.toString(randomArr));
		
		return randomArr;
	}//end generateRandomInts
	
	/**
	 * This method performs iterative binary search for a given integer within a given array
	 * @param randomArr is the sorted array where we want to search for user's integer
	 * @param key user's integer
	 * @return this method returns the index of key integer if it exists within the array otherwise returns -`1
	 */
	public int iterativeBinarySearch(int[] randomArr, int key) {
		
		location=-1;
		//The array's boundaries
		int maxIndex=randomArr.length -1;
		int minIndex=0;
		//Loops until it finds the key or when no remaining values to check
		while(maxIndex>=minIndex && location==-1) {
		
			//Displays the remaining possibles matches to the key integer after each iteration
			remainingElements(minIndex, maxIndex);
			//this is the index of the middle element of the remaining elements
			int index = (maxIndex + minIndex + 1)/2;
			//Compares the key integer to the middle element. if it matches it assigns index to location
			if(key==randomArr[index]) {
				location=index;
				System.out.printf("\nnumber %d found at index %d: Iterative Binary Search", key, location);
			//if not it identifies the remaining possible matches
			}else if(key>randomArr[index]) {
				minIndex=index+1;
			}else {
				maxIndex=index-1;
			}
			}//end while
		
		//if not match found then the method returns -1
		if(location==-1) {
			System.out.printf("\nnumber %d was not found: Iterative Binary Search", key);
		}		
		return location;
	}//end iterativeBinarySearch
	
	/**
	 * This method calculates and displays the processing time of the iterative Binary Search
	 * @param randomArr is the sorted array where we want to search for user's integer
	 * @param key user's integer
	 */
	public void iterativeBinarySearchTiming (int[] randomArr, int key) {
		
		//this is the time in the beginning of the iterative Binary Search in Nanosecond
		long timeNano= System.nanoTime();
		//this is the time in the beginning of the iterative Binary Search in millisecond
		long timeMillli= System.currentTimeMillis();
		//Performs the iterative Binary Search
		iterativeBinarySearch(randomArr, key);
		//this is the duration of the iterative Binary Search in Nanosecond
		timeNano= System.nanoTime()-timeNano;
		//this is the duration of the iterative Binary Search in millisecond
		timeMillli= System.currentTimeMillis()- timeMillli;
		
		System.out.printf("\nTime taken in nanoseconds: %d", timeNano);
		System.out.printf("\nTime taken in milliseconds: %d", timeMillli);
	}//end iterativeBinarySearchTiming 
	
	/**
	 * This method performs recursive binary search for a given integer within a given array
	 * @param randomArr is the sorted array where we want to search for user's integer
	 * @param minIndex this is the lowest index of the remaining elements
	 * @param maxIndex this is the highest index of the remaining elements
	 * @param key user's integer
	 * @return this method returns the index of key integer if it exists within the array otherwise returns -`1
	 */
	public int recursiveBinarySearch (int[] randomArr,int minIndex, int maxIndex, int key) {
		
		location=-1;
		//Displays the remaining possibles matches to the key integer after each method call
		remainingElements(minIndex, maxIndex);
		//returns -1 when no match is found
		if((maxIndex<minIndex) && (location==-1)) {
			System.out.printf("\nnumber %d was not found: Recursive Binary Search", key);
		//Compares the key integer to the middle element. if it matches it assigns index to location
		}else {
			int index = (maxIndex + minIndex + 1)/2;	
			if(key==randomArr[index]) {
				location=index;
				System.out.printf("\nnumber %d found at index %d: Recursive Binary Search", key, location);
			//if not it identifies the remaining possible matches then recalls the recursiveBinarySearch method
			}else { 
					if(key>randomArr[index]) {
					minIndex=index+1;	
					}else {
					maxIndex=index-1;
					}//end else
				recursiveBinarySearch (randomArr,minIndex, maxIndex, key);
					}//end else
				}//end else
		
		return location;
	}//end recursiveBinarySearch
	
	/**
	 * This method calculates and displays the processing time of the recursive Binary Search
	 * @param randomArr is the sorted array where we want to search for user's integer
	 * @param minIndex this is the lowest index of the remaining elements
	 * @param maxIndex this is the highest index of the remaining elements
	 * @param key user's integer
	 */
	public void recursiveBinarySearchTiming (int[] randomArr,int minIndex, int maxIndex, int key) {
		
		//this is the time in the beginning of the iterative Binary Search in Nanosecond
		long timeNano= System.nanoTime();
		//this is the time in the beginning of the iterative Binary Search in millisecond
		long timeMillli= System.currentTimeMillis();
		//Performs the recursive Binary Search
		recursiveBinarySearch (randomArr, minIndex, maxIndex, key);
		
		//this is the duration of the iterative Binary Search in Nanosecond
		timeNano= System.nanoTime()-timeNano;
		//this is the duration of the iterative Binary Search in millisecond
		timeMillli= System.currentTimeMillis()- timeMillli;
		System.out.printf("\nTime taken in nanoseconds: %d", timeNano);
		System.out.printf("\nTime taken in milliseconds: %d", timeMillli);
	}//end recursiveBinarySearchTiming 
	
	/**
	 * This method performs iterative Linear search for a given integer within a given array
	 * @param randomArr is the sorted array where we want to search for user's integer
	 * @param key user's integer
	 * @return this method returns the index of key integer if it exists within the array otherwise returns -`1
	 */
	public int iterativeLinearSearch(int[] randomArr, int key) {
			
		location=-1;
		//iterates within the array and looks for the key integer. if it finds a match it breaks out of the foor loop
		for(int i=0; i<randomArr.length; i++) {
			if(key==randomArr[i]) {
				location=i;
				System.out.printf("\nnumber %d found at index %d: Iterative Linear Search", key, location);
				break;
			}//end if
		}//end for
		
		//if no match it returns -1
		if(location==-1) {
			System.out.printf("\nnumber %d was not found: Iterative Linear Search", key);
		}
		return location;
	}//end iterativeLinearSearch
	
	/**
	 * This method calculates and displays the processing time of the iterative Linear Search
	 * @param randomArr is the sorted array where we want to search for user's integer
	 * @param key user's integer
     */
	public void iterativeLinearSearchTiming (int[] randomArr, int key) {
		
		//this is the time in the beginning of the iterative Binary Search in Nanosecond
		long timeNano= System.nanoTime();
		//this is the time in the beginning of the iterative Binary Search in millisecond
		long timeMillli= System.currentTimeMillis();
		//Performs the iterative Linear Search
		iterativeLinearSearch(randomArr, key);
		//this is the duration of the iterative Binary Search in Nanosecond
		timeNano= System.nanoTime()-timeNano;
		//this is the duration of the iterative Binary Search in millisecond
		timeMillli= System.currentTimeMillis()- timeMillli;
		System.out.printf("\nTime taken in nanoseconds: %d", timeNano);
		System.out.printf("\nTime taken in milliseconds: %d", timeMillli);

	}//end iterativeLinearSearchTiming 
	
	/**
	 * This method performs recursive Linear Search for a given integer within a given array
	 * @param randomArr is the sorted array where we want to search for user's integer
	 * @param size is randomArr size
	 * @param key user's integer
	 * @return this method returns the index of key integer if it exists within the array otherwise returns -`1
	 */
	public int recursiveLinearSearch (int[] randomArr, int size,int key) {
				
		location=-1;
		//if no match in the entire array it returns -1
		if(size==0 && location==-1) {
			System.out.printf("\nnumber %d was not found: Recursive Linear Search", key);
		/*The method compares an array element to the key integer if they match it returns the element index
		if not it recalls itself on the following element */
		}else {
			if(key == randomArr[randomArr.length-size]) {
				location=randomArr.length-size;
				System.out.printf("\nnumber %d found at index %d: Recursive Linear Search", key, location);
			}else
				recursiveLinearSearch (randomArr, size-1,key);
		}//end else
				
		return location;
	}//end recursiveLinearSearch
	
	/**
	 * This method calculates and displays the processing time of the recursive Linear Search
	 * @param randomArr is the sorted array where we want to search for user's integer
	 * @param size is randomArr size
	 * @param key user's integer
	 */
	public void recursiveLinearSearchTiming (int[] randomArr, int size,int key) {
		
		//this is the time in the beginning of the iterative Binary Search in Nanosecond
		long timeNano= System.nanoTime();
		//this is the time in the beginning of the iterative Binary Search in millisecond
		long timeMillli= System.currentTimeMillis();
		//Performs the iterative Linear Search
		recursiveLinearSearch (randomArr, size,key);
		//this is the duration of the iterative Binary Search in Nanosecond
		timeNano= System.nanoTime()-timeNano;
		//this is the duration of the iterative Binary Search in millisecond
		timeMillli= System.currentTimeMillis()- timeMillli;
		System.out.printf("\nTime taken in nanoseconds: %d", timeNano);
		System.out.printf("\nTime taken in milliseconds: %d", timeMillli);
		
	}//end recursiveLinearSearchTiming
		
	/**
	 * 
	 * @param minIndex the lowest index of the range of randomArr elements to be printed
	 * @param maxIndex the highest index of the range of randomArr elements to be printed
	 */
	public void remainingElements(int minIndex, int maxIndex) {
		//prints specified range of elements
		System.out.println();
		for(int i=minIndex; i<=maxIndex; i++) {
			System.out.print(randomArr[i] + " ");
		}//end for
	}//end remainingElements
	
}//end class
