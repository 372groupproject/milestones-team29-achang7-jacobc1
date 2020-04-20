class Main{
    static void main(String[] args){
        play()
    }
    
    static def play(){
        def game = new TicTacToe()
        Scanner input = new Scanner(System.in)
        def player = Token.X
        println game.toString()
        while (!game.solved()){
            println "${player}'s turn"
            println "Enter an X coordinate:\b"
            def x = input.nextInt()
            println "Enter an X coordinate:\b"
            def y = input.nextInt()
            game.place_token(player,x,y)
            println game.toString()
            if (player == Token.X){
                player = Token.O
            }else{
                player = Token.X
            }
        }
        println "Game Over"
    }
}

enum Token{
    X, O, _
}

class TicTacToe{
    def board = []
    
    TicTacToe(){
       for (int i = 0; i < 3; i++){
           def row = []
           for (int j = 0; j < 3; j++){
               row << Token._
           }
           board << row
       }        
    }
    
    def place_token(token, x, y){
        board[x][y] = token
    }
    
    def solved(){
        boolean empty = false
        for (int i = 0; i < 3; i++){
            for (int j = 0; i < 3; i++){
                if(board[i][j] == Token._){
                    empty = true
                }
            }
        }
        if (!empty){
            return true
        }
        for (int i = 0; i < 3; i++){
            if (board[i][0] != Token._ && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
		return true
            }
            if (board[0][i] != Token._ && board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                return true
            }
        }
        if (board[0][0] != Token._ && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
		return true
        }
        if (board[2][0] != Token._ && board[2][0] == board[1][1] && board[1][1] == board[0][2]){
            	return true
        }
        return false
    }
    
    def String toString(){
        def l1 = "\t${board[0][0]} | ${board[0][1]} | ${board[0][2]}\n"
        
        def l2 = "\t${board[1][0]} | ${board[1][1]} | ${board[1][2]}\n"
        
        def l3 = "\t${board[2][0]} | ${board[2][1]} | ${board[2][2]}\n"
        
	return l1 + l2 + l3
    }
}
