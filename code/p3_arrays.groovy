// Although Groovy uses lists as its main list literal, you can also use Java's
// array syntax to define arrays of an explicit type
class p3_arrays{
	static void main(String[] args){
		// Just like Java, arrays are given a fixed size
		String[] colors = new String[5]
		println "colors = $colors"

		// Elements are added in the same way as Java
		colors[0] = "Blue"
		colors[1] = 'Green'
		colors[2] = '''Red'''
		println "colors = $colors"

		// An array can also be initialized with stating values
		int[] nums = [1, 2, 3, 4, 5]
		println "nums = $nums"

		// or 
		def bools = new boolean[] {true, false, false}
		println "booleans = $bools"
	}
}
