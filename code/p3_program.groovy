// Implements an Affine cipher. Prompts the user with a message to encrypt. 
// Prompts the user with values that make up the cipher key, using the 
// Euclidean algorithm to determine if the key value will create a bijective
// mapping. 
class Encrypt{
	static void main(String[] args){
		Scanner input = new Scanner(System.in)
		println "Affine Cipher ax + b = X"
		println "Enter a message to encrypt"
		String mssg = input.nextLine()
		println "Enter an integer value for a, coprime to 26"
		int a = input.nextInt()
		while (euclid(a,26) != 1){
			println "$a not coprime with 26, Enter new value"
			a = input.nextInt()
		}
		println "Enter an integer value for b"
                int b = input.nextInt()
		def map = build_cipher(a,b)
		encrypt(map, mssg)
	}

	/* Implements the Euclidean Algorithm to find the Greatest Common
           Denominator.
	   Computes: a = x1*b + r1
		     b = x2*r1 + r2
	   until a remainder of 0 is reached.
	*/
	static int euclid(a,b){
		if (b == 0){
			return a
		}else{
			return euclid(b, a % b)
		}
	}
	
	/* Creates a mapping of letters of the alphabet to their encryption
	   by use of an affine cipher.
	*/
	static build_cipher(a,b){
		def alphabet = 'A'..'Z'
		def cipher = [:]
		def affine = 0;
		for (int i in 'A'..'Z'){
			affine = (a * (i - ('A' as char)) + b) % 26
			cipher[i as char] = (affine + ('A' as char)) as char
		}
		return cipher
	}

	/* Removes spaces and punctuation from the message to be encrypted
	   and encrypts each letter using the encryption mapping. Prints out
	   the final encrypted message.
	*/
	static encrypt(map, mssg){
		def encryption = []
		mssg = mssg.toUpperCase();
		def letters = mssg.split("")
		for (char i in letters){
			if (i >= ('A' as char) && i <= ('Z' as char)){
				encryption << map[i as char]
			}
		}
		def merged = encryption.join("")
		println "encryption = $merged"
	}
}
