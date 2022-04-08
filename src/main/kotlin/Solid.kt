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

open class Shapes(open val length: Int, open val type : String ){

}

data class Square(override val length: Int, override val type : String ="square") : Shapes(length, type){

}

class Circle(private val radius : Int, override val type : String = "circle", length: Int = 0) : Shapes(length,type){

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

/**
 * Resolving the single responsibility principle we need to seperate the functions
 */

class AreaSumCalculatorResolve(private val shapes: List<Shapes>){
    fun sum () : Int{
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
}

open class  SumCalculatorOutput(private val area : AreaSumCalculatorResolve){
   open  fun getSum(){
        println("Sum of shapes ${area.sum()}")
    }
}

/**
 * 2.Open and Close Principle
 * A class should be open for extension but close for modification
 * modifying the function in a class will affect all the instance the class
 * is been use. so if we want to add additional behaviour , that class should be extendable and
 * new features can be added in the new class.
 *
 * GOAL
 * the goal is to extend the a class behaviour without altering the existing behaviour of the class
 * lets imagine we want to print a different value in the print line
 * what we need to do is ensure that the class is open for extension and we dont want
 * to manually modify the class
 */

class SumCalculatorAsIntOutput(private val area: AreaSumCalculatorResolve) : SumCalculatorOutput(area){
    override fun getSum() {
       println("Lord this is the new ${area.sum()}")
    }

    /**
     * with this, the behaviour of the class has been modify through extension
     * and not modification
     */

    /**
     * 3.LISKOV SUBSTITUTION PRINCIPLE
     * This states that the child class can and must always be replaceable by the
     * parent class .
     *
     * remember our SumCalculatorOutput  and SumCalculatorAsIntOutput class
      */

//    class SumCalculatorStringOutput(private val area: AreaSumCalculatorResolve) : SumCalculatorOutput(area){
//       fun customSum() {
//            println("Lord this is the new ${area.sum()}")
//        }
//    }

    /**
     * Now if getSum on SumCalculatorStringOutput, it will still print
     * getsum() from SumCalculatorOutput which will lead to bug because it
     * does not meet the need of our extending the SumCalculatorOutput
     *
     * the best thing to do is override the function from the parent class
     * and give the child class a different behaviour
     */

    class SumCalculatorStringOutput(private val area: AreaSumCalculatorResolve) : SumCalculatorOutput(area){
        override fun getSum() {
            println("Lord this is the new String ${area.sum()}")
        }
    }

    /**
     * Interface Segregation Principle
     *
     * A class should not be force to implement an interface its not using
     * Therefore its better to have many interface than have one interface with
     * bunch of codes
     */


}