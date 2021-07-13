
    class Queue {

        /**
         * The queue class is like a house that holds node, each nodes is in the this house and have reference to each other, but the queue class keeps
         * Track of the the head and Tail,to create and add a node , everything is done in the queue class
         */


        /**
         * This is the class generated and it has a constructor that takes the value for each node
         */
        inner class Node( val data: Int) {
            var next: Node? = null
        }


        /**
         * Head and Tail are attributes of the queue , a queue must have a head and a tail
         */
        var head: Node? = null
        var tail: Node? = null

        /**
         * Once a queue has value, the tail and the head is sure, so a queue is empty once the head is null
         */
        fun isEmpty(): Boolean {
            return head == null
        }

        /**
         * this just returns null or the value of the Head
         */
        fun peak(): Int? {
            return if (head != null) head!!.data else null
        }

        /**
         * Rep = Head
         * Assist = Tail
         * Look at head and a Tail as a title, title like class rep and assistant class rep and dey can be change anytime
         * when a new student comes into a class,
         * The first student admitted becomes the rep and assist
         * the second student holds the back of the first student shirt and  becomes the assist
         * the third student holds the back of the second student shirt and becomes the assist
         * this goes on and on and on
         */

        fun add(value: Int) {

            /**
             * NewNode = new student
             */
            var newNode: Node = Node(value)
            /**
             * check is dey are students in the class and there is an assist class rep
             * if yes ...hold is back with tail!!.next = newNode
             */
            if (tail != null) tail!!.next = newNode
            /**
             * give the assist title to the new student
             *
             */
            tail = newNode

            /**
             * if dey is no student at all in the class, give the new student the attribute as class rep also
             */

            if (head == null) head = newNode

        }

        /**
         * we want to expel the Class rep  from the class
         *
         */

        fun remove(): Int? {
            /**
             * we get the class rep number if dey is dey re student in the class
             */
            var data = head?.data
            /**
             * check is there is really a class rep,
             */
            if (head != null) {
                /**
                 * set the number declared to be the number of the class rep
                 */
                data = head!!.data
                /**
                 * set the second student that is holding his shirt as the head
                 */
                head = head!!.next
            }

            return data
        }

        fun getHead() : Int?{
            return head?.data
        }

        fun getTail() : Int?{
            return tail?.data
        }
    }




