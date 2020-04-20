class PlayGame{
	static void main(String[] args) {
		Player play = new Player();
		boolean game = true;

		while(game){
		   	print "Connect4\n\n"
		   	play.game_play();
		    print "If you want to start a new game please press 1\n"
		    print "Else press any other number to leave the game\n"
		    def x = System.in.newReader().readLine() as Integer
		    if(x != 1){
		    		game = false;
		    }

		}

	    print "Thank you for playing, hope you have a nice day!"

	}
}


class Player{
	static Board board;
	static boolean win;
	static String current_player;


	Player(){
	    board = new Board();
	    win = false;
	    current_player = "Player 1 "
	} 

	def game_play(){
		while(win == false){
			this.turns();
			if(current_player == "Player 1 "){
				current_player = "Player 2 ";
			}else{
				current_player = "Player 1 "
			}
		}
	}

	def turns(){
		board.print_board();
		print current_player + "please enter the column you would like to place your piece\n"
		def player_input = System.in.newReader().readLine() as Integer
		while(player_input > 8 || player_input < 1 ){
			player_input = System.in.newReader().readLine() as Integer
		}
		for(int i = 0; i < 7; i ++){
			if(board.position[i][player_input-1] == 0 && current_player == "Player 1 "){
				board.position[i][player_input-1] = 1;
				break;
			}else if(board.position[i][player_input-1] == 0 && current_player == "Player 2 "){
				board.position[i][player_input-1] = 2;
				break;
			}
		}


	}

}


class Board{
	Integer[][] position;

	Board(){
		position = new Integer[7][7];
		for(int i = 0; i < 7; i ++){
			for(int j = 0; j < 7; j++){
				position[i][j] = 0;
			}
		}
	}

	def get_position(int x, int y){
		return position[x][y];
	}

	/**
	* This function prints out the game board. 
	* The O represents the pieces the first player placed
	* and the X would be pieces that the second player placed. 
	**/
	def print_board(){
		print "_____________________________\n"
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