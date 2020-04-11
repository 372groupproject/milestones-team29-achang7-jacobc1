// Groovy does not have an explicit character literal. 
// You can however cast string literals to the primitive char type
class p3_char{
	static void main(String[] args){

	// unlike in Java, Groovy uses all quotes for string literals 
	String s = 'A'
	assert s instanceof String

	// you can cast a string literal to a character by statically typing 
	// the type
	char c1 = s
	assert c1 instanceof Character

	// the key word "as" can convert a string to character
	def c2 = s as char
	assert c2 instanceof Character

	// you can also typecast a string to a character
	def c3 = (char) s
	assert c3 instanceof Character
	}
}
