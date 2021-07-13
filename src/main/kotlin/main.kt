fun main() {

    var firstTree = Node(10)
    firstTree.insert(5)
    firstTree.insert(3)
    firstTree.insert(2)
    firstTree.insert(9)

    firstTree.printInorderLRRi()
   println(firstTree.contains(3))


    var newlink = LinkedList()
    newlink.append(2)
    newlink.append(5)
    newlink.append(5)
    newlink.deleteWithValue(5)
    newlink.prepend(10)
    newlink.append(5)

    println(newlink.head.data)
    println(newlink.head.next?.data)
    // newlink.printAllNode()


    var newDoublyLinked = DoublyLinkedList()
    newDoublyLinked.prepend(45)
    newDoublyLinked.prepend(5)
    newDoublyLinked.prepend(4)
    newDoublyLinked.deleteTail()


    newDoublyLinked.printAllNode()
    println(newDoublyLinked.length())


    var firstQueue = Queue()
    firstQueue.add(34)
    println(firstQueue.getHead())
    println(firstQueue.getTail())
    println(firstQueue.remove())
    println(firstQueue.remove())



    var firstStack = Stack()
    firstStack.push(12)
    firstStack.push(21)
    firstStack.push(31)
    firstStack.push(41)
    firstStack.push(15)
    println( firstStack.pop())
    println( firstStack.pop())
    println( firstStack.pop())
    println( firstStack.top?.data)
}