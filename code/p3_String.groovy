// Groovy supports many different ways to define string literals. It is not 
// confined to just double quotes like Java.

class p3_String{
	static void main(String[] args){

		// A string literal can be defined with single quotes		
		println 'Single quoted String'
		
		// or can be defined with double quotes
		println "Double quoted String"

		// or with 3 single quotes.
		println '''Triple quoted String'''

		// or slashes
		def slashes =  /Slash String/
		println slashes

		// or $/ for multiline strings
		
		println ''

		// triple quotes can be used to define strings that take 
		// multiple lines without using multiple prints or \n.
		def multiline = '''This string
is printed on
multiple lines'''

		println multiline
		
		println ""

		// Double quoted strings and slash strings allow for String
 		// interpolation using ${} or by using just $
		// closure statements can also be used in string interpolation

		def x = 3
		def y = 5

		println "${x} + $y = ${-> x + y}"

	}
}
