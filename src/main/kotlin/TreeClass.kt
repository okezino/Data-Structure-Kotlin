class Node(val data: Int) {
    var left: Node? = null
    var right: Node? = null


    fun insert(value: Int) {

        if (value <= data) {
            if (left == null) {
                left = Node(value)
            } else {
                left!!.insert(value)
            }
        } else {
            if (right == null) {
                right = Node(value)
            } else {
                right!!.insert(value)
            }
        }

    }

    fun contains(value: Int): Boolean {
        if (value == data) {
            return true
        } else if (value < data) {
            return if (left == null) false else left!!.contains(value)
        } else {
            return if (right == null) false else right!!.contains(value)
        }
    }

    fun printInorderLRRi() {
        if (left != null) left!!.printInorderLRRi()
        println(data)
        if (right != null) right!!.printInorderLRRi()
    }
}