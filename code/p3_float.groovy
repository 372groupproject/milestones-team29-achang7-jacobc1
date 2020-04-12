// Groovy uses both float and double for decimal values

class p3_float{
	static void main(String[] args){
		float f = Math.PI
		println "Pi in single precision = $f"
		double d = Math.PI
		println "Pi in double precision = $d"

		// floats and doubles can also be written in scientific
		// notation (exponent form)

		def G = 6.67e-11
		println "Universal Gravitation = $G"
	}
}
