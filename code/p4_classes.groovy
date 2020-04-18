// Classes in Groovy are similar to Java, except that the Groovy compiler
// creates a default constructor. 
class Circle{
    
    // fields are defaulted to public unless otherwise stated 
    float radius
    
    def circleArea(){
        def area = Math.PI * (radius * radius)
        println "Area of Circle = $area"
    }
    
    def circumference(){
        def circum = 2 * Math.PI * radius
        println "Circumference = $circum"
    }

}

// Objects are created using the "new" keyword 

// Since a default constructor is built, Groovy allows you to construct an
// object using "named parameters" (paramName : value)
Circle c1 = new Circle(radius : 5)
c1.circleArea()
c1.circumference()

println ""

// A object can also be made by calling the default constructor and manually
// setting field values.
def c2 = new Circle()
c2.radius = 3
c2.circleArea()
c2.circumference()

