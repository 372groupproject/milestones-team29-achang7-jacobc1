// This program is a guessing number game, in which it would generate a number
// between 0 to 100. The user will guess the number that is generated by entering
// inputs to the console. 
class NumberGame { 

   	static void main(String[] args) { 

   		println("Welcome to number guessing game");

   		// Generating a number that is between 0 to 100
   		Random rand = new Random();
   		int num = rand.nextInt(100);

   		int upperLimit = 100;
   		int lowerLimit = 0;

   		boolean check = True;

   		// While loop that keeps that game going
   		while(check){
   			// Getting a integer input from the user
   			def x = System.in.newReader().readLine() as Integer;

   			// Checking if the number is the mystery number
   			if(x == num){
   				println("You got it! ")
   				break;
   			// calling the verify function to check if the number guessed
   			// is in the limit
   			}else if(verify(upperLimit,lowerLimit,x)){
   				// Resting the limit
   				if( x > lowerLimit){
   					lowerLimit = x;
   				}else{
   					upperLimit = x;
   				}
   				// Casting integer to String
   				String temp = Integer.toString(upperLimit);
   				String temp1 = Integer.toString(lowerLimit);
   				println("The new limit is: " temp1 + "to" + temp);
   			}else{
   				println("The number entered in not in the limit");
   			}
   		}
   	} 

   	// This function uses if statements to check if the a number is 
   	// in the range of the other two numbers
   	public static boolean verify(int num1, int num2, int num3){
   		if(num1 > num3 && num2 < num3){
   			return True;
   		}else{
   			return False;
   		}
   	}


}