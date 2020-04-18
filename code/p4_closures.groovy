class closures{

	static void main(String[] args){
			
		// closures use similar syntax to methods. Parameters are listed
		// using commas. They are separated from code using an arrow ->
		// which is then followed by the body of the closure. 
		def add = { x, y -> x + y}
		println add(3, 7)

		def copy = {int x, String s -> s * x}
		println copy(4, "Hello")

		// Closures support currying. By using .curry, the closure is
		// curried from the left
		def triple = copy.curry(3)
		println triple("Hello")

		def lastNDigits = {int x, int n -> x % (10 ** n)}
		println lastNDigits(456287356, 4)

		// Closures can also be curried from the right using .rcurry
		def last2 = lastNDigits.rcurry(2)
		println last2(3984627)
	}
}
