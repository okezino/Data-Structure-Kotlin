    /**
     * Builder pattern is actually the java way of creating a class simlessly now for kotlin we just use data class and pass the
     * parameter directly
     */

    class Country(
        var population : Int?,
        var flagColor: String?,
        var president: String?
    ) {

       inner class Builder{
            var population : Int? = null
            var flagColor: String? = null
            var president: String? = null
            fun population(value : Int) {
                population = value
            }
            fun flagColor(value : String){
                flagColor = value
            }
            fun president(value : String){
                president = value
            }

            fun build(): Country{
                return Country(population,flagColor,president)
            }


        }
    }

    /**
     * Kotlin way of generating a class simlessly
     */
    data class Countrya(var population : Int? = 1, var flagColor: String?= "Blue", var president: String?= "Jacob")



