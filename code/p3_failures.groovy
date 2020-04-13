class p3_failures{
	static void main(String[] args){
		int x = 9
		boolean y = true
		String z = 'abc'

		// Groovy does allow for int and string to be added together
		// converts to String and treats operation as concatination
		try{
			println "x + z = ${-> x + z}"
		}catch(Exception ex){
			println "cannot add int and String"
		}
		
		// String multiplied by int duplicates a string
		try{
                        println "x * z = ${-> z * x}"
                }catch(Exception ex){
                        println "cannot multiple string and int"
                }

		// However, Int multipled by String is an error
		try{
			println "x * z = ${-> x * z}"
		}catch(Exception ex){
			println "cannot multiple string and int"
		}

		// Operations with booleans result in errors except '+' with
		// Strings 
		try{
			println "x + y = ${->x+y}"
		} catch(Exception ex){
			println "cannot add boolean and int"
		}
	}
}
