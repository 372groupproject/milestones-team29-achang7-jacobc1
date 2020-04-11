// Groovy does not define its own lists type, instead using Java's List object.
// Defining a list literal in Groovy uses Java's ArrayList by default

class p3_lists{
	static void main(String[] args){
		// We can initialize a list using square brackets
		def nums = [0, 1, 2, 3, 4, 5]
		println "nums = ${nums}"
		
		// list elements are accessed using []
		println "nums[0] = ${nums[0]}"
		
		// Groovy also supports negative indexing 
		println "nums[-2] = ${nums[-2]}"

		// Make assignments using:
		nums[2] = 6
 		println "nums = ${nums}"

		// append using <<
		nums << 7
		println "nums = ${nums}"

		// Groovy allows for accessing multiple items from the list
		println "nums[1,2,4] = ${nums[1,2,4]}"

		// Groovy also allows you to grab portions of a list using 
		// Groovy's Range tupe
		def subset = nums[2..4]
		println "subset = ${subset}"

		// Since Groovy does not require static typing, lists can 
		// contain mulitple types

		def multi = ['a',false,3.14,9]
		println "multi-typed list = $multi"
	}
}
