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

class SumCalculatorAsIntOutput(private val area: AreaSumCalculatorResolve) : SumCalculatorOutput(area) {
    override fun getSum() {
        println("Lord this is the new ${area.sum()}")
    }
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

    interface ShapeMathInterface {
        fun area();
        fun volume();
    }

    /**
     * Any class that extends this function must implement both
     * area and volume
     *but a 2D shape does not have a volume while a 3D shape has a volume .
     * and the both re extending the shapeMathInterface, this will make the
     * 2D shape implement a a function volume()  which it does not need .
     *
     * so the best is to separate the two expression
     */

    interface  ShapeAreaInterface{
        fun area()
    }

    interface ShapeVolumeInterface{
        fun volume()
    }

    /**
     * Dependency Inversion Principle
     * Entities should depend on abstraction and not concretion ,
     * High level module should not depend on low level module but
     * should depend on abstraction
     *
     * GOAL
     * Decoupling classes and using interface to smoothly switch class in constructors
     *
     * High Level Module : this is a class that execute a task
     * Low Level Module : this is a tool  that is needed to execute the task
     * Abstraction : Represent and interface that connects two classes
     * concretion : how the Low Level Module work
     *
     * lets use a repository
     *
     */
    class  LocalDataSource{
        fun getAllFiles() : List<String>{
           TODO()
        }
    }

   class MainRepository(
       private val localDb : LocalDataSource
   ){
      fun  getAllFileNumber() : List<Int>{
          return localDb.getAllFiles().map {
               it.toInt()
          }
      }
   }

/**
 * The above implementation violate the Dependency Inversion
 * its will be very hard to change the datasource since we have already declare
 * the LocalDb in the repository , so lets change the implementation for the mainRepository
 */

interface DataSource{
    fun getAllFiles() : List<String>
}

class LocalDataBase(): DataSource{
    override fun getAllFiles(): List<String> {
        TODO("Not yet implemented")
    }
}

class RemoteDataSource(): DataSource{
    override fun getAllFiles(): List<String> {
        TODO("Not yet implemented")
    }

}

class MainDataRepository(val dataSource: DataSource){

}

/**
 * so with this we can create instance of the repository with
 * either of the two data source
 */

val getRemoteRepository = MainDataRepository(RemoteDataSource())
val getLocalRepository = MainDataRepository(LocalDataBase())


/**
 * This is Dependency inversion and we re good now
 */
