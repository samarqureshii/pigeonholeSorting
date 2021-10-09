/*
* Name: Samar Qureshi
Program Description: This program utilizes the pigeonhole sorting algorithm to order an integer array
in increasing order 
Date: 
*/

package com.company.search_sort;
import java.util.Random;
import java.util.Scanner;

public class pigeonholeSort {
    public static void main(String[] args) {
        Random rand = new Random();
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n\nLet's sort an integer array, shall we? Hit enter to generate a random array of 10 integers.");
		input.nextLine();
        int []array = new int [10];

		System.out.print("\nGreat. Here's a look at our unsorted array: ");
        for(int i = 0; i<array.length; i++){ //fills array with random numbers between 1 and 99
            array[i] = 1+rand.nextInt(21);
        }

		displayArr(array); //prints out unsorted array
	    pigeonholeSort(array);  //sorts and prints out original array  
	      
	}
	
	public static int[] pigeonholeSort(int arr[]) {
		Scanner input = new Scanner(System.in);

		//sets the minimum and maximum values as the first element in the array
	      int min= arr[0];
	      int max = arr[0];

		  System.out.println("\n\nNow, hit enter to determine our maximum and minimum values from this array.");
		  input.nextLine();
	      
	      for(int h=0; h<arr.length; h++) { 
	    	 //finds the maximum and minimum values
	    	  
	         if(arr[h] > max) { //finds the maximum value
	            max = arr[h];
	         }
	         
	         else if(arr[h] < min) { //finds the minimum value
	            min = arr[h];
	         }
	      }

		System.out.println("Maximum value is: " + max);
		System.out.println("Minimum value is: " + min );

		System.out.println("\nAwesome. Now let's calculate our range using the formula 'max-min+1'. Hit enter to continue.");
		input.nextLine();
	    int range = max - min + 1; //calculates the range
		System.out.println("Calculation for range: " + max + " - " +  min + " + 1 = " +range);

		System.out.println("Now, let's create the empty pigeonhole array that is " + range + " indices big."
		+ " Hit enter to continue.");
		input.nextLine();
	    int[] pigeonholes = new int[range];  //creates the pigeonhole array using the range as the number of elements
	      
		System.out.println("Time to fill up our pigeonhole array. We'll iterate through each element at index 'i', " +
		"then we'll place each element in the original array in its appropriate pigeonhole at the index 'arr[i]-min'. " +
		"\n\nRepeated elements will be stored in the same hole, and the pigeonhole array will display the number of elements in each pigeonhole. " +
		"\n\nIf the pigeonhole is empty, it will store 0." +
		"\n\nHit enter to view the filled pigeonholes.");
		input.nextLine();
	      for(int i = 0; i<arr.length; i++) {
	        pigeonholes[arr[i] - min]++; //fills up the empty pigeonhole array 
			System.out.println("Element " + arr[i] + " will be placed in the pigeonhole index " + (arr[i]-min) + ".");
	      }

		  System.out.println("\nTo visually see which pigeonholes are filled and which are not, hit enter. " + 
		  "\nThe number at each index tells us how many elements are being stored in it, since some elements may repeat.");
		  input.nextLine();
		  displayArr(pigeonholes); //prints out piggeonhole array before transferring

	      System.out.println("\n\nFinally, let's transfer the elements from the non-empty pigeonholes to the original array, " +
		  "in correspondance to its location in the pigeonhole array. \nHit enter to continue.");
		  input.nextLine();
		  
	      int index = 0;
	      for(int j = 0; j<range; j++) {
	         while(pigeonholes[j] > 0) { 
				 //checks to see if the pigeonhole isn't empty before adding the element inside of it back 
				 //into the sorted elements 
	        	 arr[index]=j+min;
	        	 index++;
				 pigeonholes[j]--;

				 System.out.print("Pigeonhole transfer " + index + ": ");
				 displayArr(arr);
				 System.out.println();
	         }	
	      }

		  System.out.print("\nNow, we finally have our sorted array: ");
		  displayArr(arr);

		  return arr;
		  
	   }

	   public static int[] displayArr(int[]arr){
		//method that displays any integer array
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i] + "    ");
			}
			return arr;
	   }
}
