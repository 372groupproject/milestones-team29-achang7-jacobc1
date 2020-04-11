// Shows the char type. Shows how chars can be concatinated onto Strings using
// the + operator, checks that this operation is successful using asserts. 
class p3_char{
	static void main(String[] args){
		String x = "Hello World"
		assert x.length() == 11
		x += '!'
		assert x.length() != 11 
	}
}
