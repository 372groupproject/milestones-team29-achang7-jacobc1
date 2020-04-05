// This program is example of how switch statements work in Groovy. 
class Switch { 

	// This is a switch statement that is similar to if statements. It would
   	// would take in a parameter and check which case the parameter fits. 
   	static void main(String[] args) { 
  	  	switch(a) {            
         	//There is case statement defined for 3 cases 
         	// Each case statement section has a break condition to exit the loop 
			
         	case 1: 
	            println("The value of a is One"); 
	            break; 
	        case 2: 
	            println("The value of a is Two"); 
	            break; 
	        case 3: 
	            println("The value of a is Three"); 
	            break; 
	        default: 
	            println("The value is unknown"); 
	            break; 
      	}
   	} 

}