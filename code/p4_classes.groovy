// Classes in Groovy are similar to Java
// Groovy's comiler will create a default constructor if no
// explixit consrtuctor is povided  
class Circle{
    
    // fields are defaulted to public unless otherwise stated 
    float radius
    
    def circleArea(){
        return Math.PI * (radius * radius)
    }
    
    def circumference(){
        return  2 * Math.PI * radius
    }

}


// Classes can also be made with specific constructors similar 
// to Java
class Cylinder{

    float radius
    float height
    Circle c
    
    Cylinder(float radius, float height){
        this.radius = radius
        this.height = height
        this.c = new Circle(radius : this.radius)
    }
    
    float surface_area(){
        return ((c.circumference() * height) + 2 * c.circleArea())
    }
    
    float volume(){
        return c.circleArea() * height
    }
}

// Objects are created using the "new" keyword 

// Since a default constructor is built, Groovy allows you to construct an
// object using "named parameters" (paramName : value)
Circle c1 = new Circle(radius : 5)
println "Area of Circle = ${c1.circleArea()}"
println "Circumference = ${c1.circumference()}"

println ""

// A object can also be made by calling the default constructor and manually
// setting field values.
def c2 = new Circle()
c2.radius = 3
println "Area of Circle = ${c2.circleArea()}"
println "Circumference = ${c2.circumference()}"

println ""

def cylinder1 = new Cylinder(4, 3)
println "Surface area = ${cylinder1.surface_area()}"
println "Volume = ${cylinder1.volume()}"
