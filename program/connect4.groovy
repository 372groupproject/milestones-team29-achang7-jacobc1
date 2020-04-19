class Player{
   static void main(String[] args) {
      Board board = new Board();
      board.print_board();

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


	/**
	* This function prints out the game board. 
	* The O represents the pieces the first player placed
	* and the X would be pieces that the second player placed. 
	**/
	def print_board(){
		print "_____________________________\n"
		for(int i = 6; i >= 0; i--){
			print "|"
			for(int j = 6; j >= 0; j--){
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

