object ScopeFunctionKotlin {
        /**
         * scope function in kotlin
         * let
         * let is basically use to check for null pointers,
         * so let takes a value work on it and return the result
         * the last expression of a let statement is been returned
         * Elvis operator is use to set a value to a variable if its null
         */

        var d : Int? = null

        var c = d?.let {
            it + 1 }?: 6

        /***
         * Scope function in kotlin
         * also
         * Also is similar to let,
         * it takes a variable, work on and affect the global scope of the variable  but returns the original variable that was collected to work on
         * it those nto return the last line like rest, but it only return the original data that calls it
         */

        var ep = 4

        // returns 16
        fun squareE() : Int = (ep * ep).also {
            ep++ }

        // returns 5 .....also return the last statement
        fun squareEp() : Int = (ep * ep).let {
            ep++ }

        /**
         * run ----> this dataClass
         * run is mostly use for data class to modify an instance of a class but returns the last statement in the scope function
         *
         */

        class Person {
            var name = ""
            var age = 89
            override fun toString() : String{
                return "name: $name age:$age"
            }
        }

        // this returns a string a i am a football
        var okezino = Person().run {
            name = "Okezino"
            age = 89
            "i am a football"

        }
        // this returns an instance on Person
        var okeh = Person().run {
            name = "Okezh"
            age = 90
            this

        }

        /***
         * apply  ---> this dataClass
         * apply takes a data class, modify it and return the newly modified data class, if no modification, it returns
         * the original data class that is been worked on , it does not return the last statement like also, but instead of working
         * on global scope like also does, it focus on the class that was passed and work on it.
         */

// returns okezi instance with okezi as name and 89 as age
        var okezi = Person().apply {
            name = "Okezi"
            age = 89
        }

        /**
         * with and run has same functionality but different in structuring
         * they both takes a class, modify it and return the last statement in the block of code
         *
         */

        var okemena = with(Person()){
            name = "Okemena"
            age = 89
            this
        }
    }
