import MemoizationAndRecursion.canSum
import MemoizationAndRecursion.coinChange
import MemoizationAndRecursion.fib
import MemoizationAndRecursion.gridTravel
import MemoizationAndRecursion.magic
import ScopeFunctionKotlin.ep
import ScopeFunctionKotlin.okemena
import ScopeFunctionKotlin.okezi
import ScopeFunctionKotlin.okezino
import ScopeFunctionKotlin.squareE
import ScopeFunctionKotlin.squareEp
import java.util.*

fun main() {
    println(Microwave.name)
    println(Microwave.name)

   var san = ListNode(2)
             san.addNode(4)
             san.addNode(3)
 var pan = ListNode(5)
 pan.addNode(6)
 pan.addNode(4)
// pan.addNode(9)

    println(san.next?.`val`)
    println(pan.next?.next?.`val`)
    addTwoNumbers(san,pan)

    println("=================")

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
     newlink.printAllNode()


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
    println(firstStack.pop())
    println(firstStack.pop())
    println(firstStack.pop())
    println(firstStack.top?.data)


    val nute = arrayOf("give", "me", "one", "one", "grand", "today", "night")
    val nh = nute.groupingBy { it }
    val nop = nute.groupingBy { it }.eachCount()
    println(nh)
    println(nop)
    var newCountry = Country.Builder()
        .flagColor("Green white Green")
        .population(12344)
        .build()


    var e = arrayOf("abcdde", "baccd", "eeabg")
    println(fib(1500))
    println(gridTravel(18, 16))
    var a: Int? = null
    var b: Int? = null
    a = b ?: 9

    println(squareE())
    println(ep)
    println(squareEp())
    println(okezi.toString())
    println(okezino)
    println(okemena.toString())
    var lip = ListNode(5)
    var v = lip.`val`
    println(v)

    val arr = arrayOf(arrayOf(5, 3, 4), arrayOf(1, 5, 8), arrayOf(6, 4, 2))
    val ar = arrayOf(arrayOf(4,9,2), arrayOf(3,5,7), arrayOf(8,1,5))
    val list = arrayOf(4,5,8)
    println(magic(arr))
    println(canSum(3,list))
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null

}

fun ListNode.addNode(data: Int) {
 if (this.next == null) {
  this.next = ListNode(data)
 } else {
  var current = this.next
  while (current?.next != null) {
   current = current.next
  }
  current?.next = ListNode(data)
 }

}



    fun addTwoNumbers(l1: ListNode?, l2: ListNode?) {

        var first = ""
        var sec = ""
        var x = l1
        var y = l2

        while (x != null) {
            first += x?.`val`
            x = x?.next
        }
        while (y != null) {
            sec += y?.`val`
            y = y?.next
        }

        var overall = (first.reversed().toInt() + sec.reversed().toInt()).toString()
        var result = ListNode(overall.lastIndex.toInt() - 48)
        for (i in overall.lastIndex - 1 downTo  0){
         var res = overall[i].toInt() - 48
          result.addNode(res)
        }

     println(overall)

    }


