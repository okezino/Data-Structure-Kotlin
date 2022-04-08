import sun.security.util.Length

class Solid {

    /**
     * The 5 solid principles
     * importance for this principle are
     * 1.avoid code smell
     *   - incorrect file,class,function,entities naming convention
     * 2.refactoring code
     * 3.Adaptive software development
     */

    /**
     * Single Responsibility Principle
     *    A class must have only one responsibility and as such have one reason to
     *    change
      */
}

open class Shapes{

}

data class Square(private val length: Int, val type : String ="square") : Shapes(){

}

class Circle(private val radius : Int, val type : String = "circle") : Shapes(){

}

/**
 * In this situation this class is against the single responsibility
 * the class have more than one reason to change
 * 1. if i want to add more shapes to the sum, i will need to edit this class
 * 2. if i want to change the way i want to return the getsum(), i will need to change this class
 */
class AreaSumCalculator(private val shapes: List<Shapes>){
    private fun sum () : Int{
        var sum = 0
        shapes.forEach {
            if(it is Circle){
                sum += 90
            }else if(it is Square){
                sum += 10
            }
        }
        return sum
    }

    fun getSum(){
        println("Sum of shapes ${sum()}")
    }
}