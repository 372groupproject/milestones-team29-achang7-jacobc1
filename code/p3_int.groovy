//Groovy supports int, byte, short, and long for non decimal numbers
// Byte - 8 bit
// short - 16 bit
// int - 32 bit
// long - 64 bit

class p3_int{
	static void main(String[] args){
		// all 4 integral number types can be written in base 10 format
		byte b = 1
		short s = 1
		int i = 1
		long l = 1
		assert b == s && s == i && i == l

		// they can also be written as a binary using the prefix 0b

		def x = 0b1

		assert x == b && b == s && s == i && i == l

		// or defined in octal by starting with the prefix 0

		def y = 01

		assert y == b && b == s && s == i && i == l

		// or defined in hexadecimal using prefix 0x

		def z = 0x1

		assert z == b && b == s && s == i && i == l

		// integeral number types suppport addition, substraction,
		// division, multiplication, and exponentiation
	}
}
