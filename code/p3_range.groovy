// Ranges create a collection of data given a start and end point
// Ranges can be used on any type that implements Java's Comparable.
class p3_range{
	static void main(String[] args){
		// Ranges can be made inclusive (including the last value )
		def nums_in = 1..9
		println "inclusive range 1 to 9 = $nums_in"

		// or can be exclusive
		def nums_ex = 1..<9
		println "exclusive range 1 to 9 = $nums_ex"

		// ranges can be used for any comparable type
		def alphabet = 'a'..'z'
		println "alphabet = $alphabet"
	}
}
