class methods{

    static void main(String[] args){
        println "0! = ${fact(0)}"
        println "1! = ${fact(1)}"
        println "5! = ${fact(5)}"
        
        println "sum of [1,2,3] = ${listSum([1,2,3])}"
        println "sum of [3,6,1,7,9] = ${listSum([3,6,1,7,9])}"
    }
    
    // Methods in Groovy can be defined using optional typing
    
    // Here a return type is defined as are types for parameters
    static int fact(int i){
        if (i == 0 || i == 1){
            return 1
        }else{
            return i * fact(i - 1)
        }
    }
    
    // Methods also can be dynamically typed
    // Here we define the function using the def keyword and no
    // type signature is given for return types or parameter types
    static def listSum(x){
        def sum = 0;
        for (int i = 0; i < x.size(); i++){
            sum += x[i]
        }
        return sum;
    }
}