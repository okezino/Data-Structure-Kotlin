
class DoublyLinkedList {

    var head : Node? = null
    var tail : Node? = null

    inner class Node(val data : Int){
        var prev : Node? = null
        var next : Node? = null
    }

    fun prepend(data : Int){
        val newNode = Node(data)
        if(head == null) tail = newNode else {
            head?.prev = newNode
        }
        newNode.next = head
        head = newNode
    }

    fun printAllNode(){
        var current = head
        if(head == null) println("empty Doubly linked List") else {
            while (current?.next != null){
                print(current!!.data)
                print(" ")
                current = current!!.next
            }
            print(current!!.data)
            print(" ")
        }
    }

    fun length() : Int{
        var length = 0
        if(head == null) length = 0 else {
            var current = head
            while (current?.next != null) {
                length++
                current = current!!.next
            }
            length++
        }

        return length
    }

    fun deleteNode(){

        if(head == null) head == null else {
            var second = head?.next
            second?.prev = null
            head = second
        }
    }

    fun deleteTail(){

        if (head?.next == null) tail = null else {
            var current = tail?.prev
            current!!.next = null
            tail = current

        }
    }

}