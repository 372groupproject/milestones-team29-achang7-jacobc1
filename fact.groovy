class Factor{
	static void main(String[] args){
		Scanner scan = new Scanner(System.in)
		println "Enter an Integer"
		def num = scan.nextInt()
		def factors = []
		def factor = {
			x, y->
			return x % y == 0
		}
		for (i in 1..num){
			if (factor(num,i)){
				factors.add(i)
			}
		}
		println factors
	}
}
