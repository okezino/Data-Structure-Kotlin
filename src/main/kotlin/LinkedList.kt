class LinkedList {

        inner class Node(val data: Int) {
            var next: Node? = null
        }

        lateinit var head: Node


        fun append(data: Int) {
            var newNode = Node(data)
            if (!this::head.isInitialized) head = newNode else {
                var current = head
                while (current.next != null) current = current.next!!
                current.next = newNode
            }
        }

        fun prepend(data: Int) {
            var newNode = Node(data)
            if (!this::head.isInitialized) head = newNode else {
                newNode.next = head
                head = newNode
            }
        }

        fun deleteWithValue(data: Int) {
            var current = head
            if (!this::head.isInitialized) return else {
                while (current.next != null) {
                    if (current.next!!.data == data) {
                        current.next = current.next!!.next

                    }

                    current = current.next!!
                }
            }
        }

        fun printAllNode() {
            var current = head
            if(!this::head.isInitialized) print("Empty linkedList") else {
                while (current.next != null){
                    print(current.data)
                    print(" ")
                    current = current.next!!
                }
                print(current.data)
                print(" ")
            }
        }


    }




