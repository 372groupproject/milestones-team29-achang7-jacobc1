// This program is to show how while loops works in Groovy
class Loops { 

	// Below are all the different loops in Groovy
   	static void main(String[] args) { 

   		// While loops 
	    int count = 0;

	    // While condition is True, continue looping
	    // otherwise exit code
      	while(count < 5 ) {
         	println(count);
         	count++;
      	}

      	// For Loops
      	// int i declared in the for loop, and while 
      	// the statement is true continue looping, 
      	// after each iteration, increase i by 1
     	for(int i = 0;i < 5; i++) {
         	println(i);
      	}

      	// Declaring an array of integer
      	int[] array = [0,1,2,3,4]; 
		
		// For each loops
		// i would iterate through each element in the array list
      	for(int i in array) { 
        	println(i); 
     	} 

     	// Special feature in Groovy 
     	// For-in loops
     	// It is used to loop through ranges
     	for(int i in 1..5) {
         	println(i);
      	}



   	} 

}
