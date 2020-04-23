class PlayGame{
	static boolean game = true;
	static PlayGame playGame;

	/*
	This method would ask the user for an integer input. This function would 
	ask until the user enters an integer. 
	*/
	def user_input(){
		try{
			def player_input = System.in.newReader().readLine() as Integer
			return player_input
		// Catching error if the user didn't enter a number
		}catch(NumberFormatException e){
			print "Please enter an integer\n"
			this.user_input();
		}
	}

	/**
	This class creates the board and manages each individual game played.
	*/
	static void main(String[] args) {
		playGame = new PlayGame();

		// Check if the user wants to reset a game
		while(game){
			
			playGame.play();
		    print "If you want to start a new game please press 1\n"
		    print "Else press any other number to leave the game\n"

		    // asking if the user wants to continue a new game
		    int num = playGame.user_input()
		    if(num != 1){
		    	game = false;
		    }
		    print "\n\n\n\n\n"

		}

	    print "Thank you for playing, hope you have a nice day!\n"
	}

	def play(){

		print "Welcome to Connect four\n"
		print "Enter 1 if you would want to play against the computer\n"
		print "Enter another number if you have two players\n"

		int user = playGame.user_input();
		Controller play = new Controller(user);

		// The controller of the game
		play.game_play();

	}


}


class Controller{
	static Board board;
	static boolean win;
	static String current_player;
	static boolean computer_player;


	// Constructor that creates a new board object
	Controller(num){
	    board = new Board();
	    board.print_board();
	    win = false;
	    current_player = "Player 1 "
	    if(num == 1){
	    	computer_player = true;
	    }else{
	    	computer_player = false;
	    }
	} 

	/*
	This method is switching the turns of the two players. 
	It would exit if one of the player wins the game. 
	*/
	def game_play(){
		while(win == false){
			// Calls the turns function for the user to place pieces into the board
			if(current_player == "Player 1 "){
				this.human_turn();
				win = this.check_win(1,board.position);
				if(win == true){
					break;
				}
				current_player = "Player 2 ";
			}else if(current_player == "Player 2 " && computer_player == false){
				this.human_turn();
				win = this.check_win(2,board.position);
				if(win == true){
					break;
				}
				current_player = "Player 1 "
			}else{
				this.computer_turn();
				win = this.check_win(2,board.position);
				if(win == true){
					break;
				}
				current_player = "Player 1 "
			}
		}

		print current_player + " wins the game\n"
	}

	/*
	This function will simulate a computer player placing the piece to the board.
	It would check if there are places that the player would put the next turn and win, 
	if the player would win in the next turn, by placing a piece at particular position, 
	the computer would block that position. Otherwise, it would place a piece randomly 
	*/
	def computer_turn(){
		for(int i = 0; i < 7; i++){
			Integer[][] temp = this.copy_array();
			if(validate_input(i,temp)){
				this.place_piece(i,temp,"Player 1 ");
				if(this.check_win(1,temp)){
					this.place_piece(i,board.position,"Player 2 ")
					print "Computer places the pieces at " + i + "\n"
					board.print_board();
					return
				}
			}
		}

		// Generating a random position between 1 - 7 (inclusive)
		Integer rd = new Random().nextInt(7) + 1;
		while(validate_input(rd,board.position) == false){
			rd = new Random().nextInt(7) + 1;
		}
		place_piece(rd - 1,board.position,"Player 2 ")

		print "Computer places the pieces at " + rd + "\n"

		board.print_board();

	}

	/*
	This function is just making a copy of the array.
	*/
	def copy_array(){
		Integer[][] new_array = new Integer[7][7];
		for(int i = 0; i < 7; i ++){
			for(int j = 0; j < 7; j++){
				new_array[i][j] = board.position[i][j];
			}
		}
		return new_array;
	}

	/*
	This function would ask where the user would like to place their piece in the board.
	It would then update the Board object and prints of the board to the console.
	*/
	def human_turn(){
		// Getting the input from the user
		print current_player + "please enter the column you would like to place your piece\n"
		int player_input = this.get_input();

		// Checking if the input that the user put in is valid 
		while(this.validate_input(player_input,board.position) == false){
			print "Coulmn is full, please place your piece in another position"
			player_input = this.get_input();
		}

		place_piece(player_input - 1,board.position,current_player);


		// prints out the board 
		board.print_board();

	}

	/*
	This function will update the board position array list
	*/
	def place_piece(int row,Integer[][] list,String cp){
		// Updating the Board object
		for(int i = 0; i < 7; i ++){
			if(list[i][row] == 0 && cp == "Player 1 "){
				list[i][row] = 1;
				break;
			}else if(list[i][row] == 0 && cp == "Player 2 "){
				list[i][row] = 2;
				break;
			}
		}
	}

	/*
	This method is checking if the column that the user selected is 
	full. Returns true if there is still space in the column, false otherwise
	*/
	def validate_input(int num,Integer[][] list){
		for(int i = 0; i < 7; i ++){
			if(list[i][num-1] == 0){
				return true;
			}
		}
		return false;
	}

	/*
	This function is checking if the user input is a number and also if it is 
	in between 1 to 7 inclusive. If any condition above is not met above, it would
	ask the user to enter another integer
	*/
	def get_input(){
		try{
			// reading in the input
			def player_input = System.in.newReader().readLine() as Integer
			while(player_input > 7 || player_input < 1 ){
				print current_player + "please enter a number from 1 - 7 (inclusive)\n"
				player_input = System.in.newReader().readLine() as Integer
			}
			return player_input

		// Catching the error if the user didn't enter an integer
		}catch(NumberFormatException e){
			print current_player + "Please enter an integer\n"
			this.get_input();
		}

	}

	/*
	Checking if any of the player wins the game. Winning a game is having four pieces in a row,
	either horizontally, vertically, or diagonally. 
	*/
	def check_win(int num,Integer[][] list){
		if(this.check_horizontal(num,list) || this.check_vertical(num,list) || this.check_diagonal(num,list)){
			return true;
		}
		return false;
	}

	/*
	This method is checking if a particular player have their four pieces in a row horizontally.
	Returns turn if the statement above is true, false otherwise
	*/
	def check_horizontal(int num,Integer[][] list){
		int count = 0;
		for(int row = 0; row < 7; row ++){
			for(int col = 0; col < 7; col ++){
				if(list[row][col] == num){
					count ++;
				}else{
					count = 0;
				}
				if(count == 4){
					return true;
				}
			}
		}
		return false;
	}

	/*
	This method is checking if a particular player have their four pieces in a row vertically.
	Returns turn if the statement above is true, false otherwise
	*/
	def check_vertical(int num,Integer[][] list){
		int count = 0;
		for(int col = 0; col < 7; col ++){
			for(int row = 0; row < 7; row ++){
				if(list[row][col] == num){
					count ++;
				}else{
					count = 0;
				}
				if(count == 4){
					return true;
				}
			}
		}
	}

	/*
	This method is checking if a particular player have their four pieces in a row diagonally.
	Returns turn if the statement above is true, false otherwise
	*/
	def check_diagonal(int num,Integer[][] list){
		for(int row = 0; row < 4; row ++){
			for(int col = 0; col < 4; col ++){
				int count = 0;
				int r = row;
				int c = col;
				boolean check = true;
				while(count < 5 && check){
					if(list[r][c] == num){
						count ++;
					}else{
						check = false;
					}
					if(count == 4){
						return true;
					}
					r ++;
					c ++;
				}
			}
		}

		for(int row = 0; row < 4; row ++){
			for(int col = 6; col >= 4; col --){
				int count = 0;
				int r = row;
				int c = col;
				boolean check = true;
				while(count < 5 && check){
					if(list[r][c] == num){
						count ++;
					}else{
						check = false;
					}
					if(count == 4){
						return true;
					}
					r ++;
					c --;
				}
			}
		}

		return false;
	}
}


class Board{
	Integer[][] position;

	/*
	The constructor for Board, and setting each position to 0
	*/
	Board(){
		position = new Integer[7][7];
		for(int i = 0; i < 7; i ++){
			for(int j = 0; j < 7; j++){
				position[i][j] = 0;
			}
		}
	}



	/**
	* This function prints out the game board. 
	* The O represents the pieces the first player placed
	* and the X would be pieces that the second player placed. 
	**/
	def print_board(){
		print "__1___2___3___4___5___6___7__\n"
		for(int i = 6; i >= 0; i--){
			print "|"
			for(int j = 0; j < 7; j++){
				if(position[i][j] == 0){
					print "   |"
				}else if(position[i][j] == 1){
					print " O |"
				}else{
					print " X |"
				}
			}
			print "\n"
		}

		print "-----------------------------\n"
	}
}