class Stack{
        inner class Node(val data : Int){
            var prev : Node? = null
        }
        
        var top : Node? = null

        fun push(data : Int) {
            var newNode = Node(data)
            if(top != null ) newNode!!.prev = top
            top = newNode

        }

        fun pop() : Int?{
            var data = top?.data
            if(top != null) top = top!!.prev

            return data
        }


    }

