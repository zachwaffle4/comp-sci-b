package ktvariations

class SingleLinkedListKt(var head: NodeKt) {
    var tail: NodeKt? private set
    val size get() = numOfNodes()

    init {
        var node: NodeKt? = head
        if (node != null) {
            while (node!!.next != null) node = node.next
        }
        tail = node
    }

    fun addToFront(value: Any): NodeKt {
        head = NodeKt(value, head)
        return head
    }

    fun addToEnd(value: Any): NodeKt {
        val node = NodeKt(value, null)
        tail!!.next = node
        tail = node
        return tail!!
    }

    fun addToMiddle(value: Any, index: Int): NodeKt {
        var temp: NodeKt? = head
        for (i in 0 until index) {
            temp = temp!!.next
        }

        temp!!.next = NodeKt(value, temp)
        return temp
    }

    fun removeFirst() : NodeKt {
        val node = head
        head = head.next!!
        return node
    }

    fun removeLast() : NodeKt {
        var node: NodeKt? = head
        while (node!!.next!!.next != null) {
            node = node.next
        }
        node.next = null
        tail = node
        return tail as NodeKt
    }

    fun removeFromMiddle(index: Int) : NodeKt? {
        var node = head
        for (i in 0..index) {
            node = node.next!!
        }
        val toReturn = node.next
        node.next = node.next!!.next
        return toReturn
    }

    fun printForwards() {
        print("[")
        var node: NodeKt? = head
        while (node != null) {
            print("$node, ")
            node = node.next
        }
        print("]\n")
    }

    fun printBackwards(node: NodeKt?) {
        if (node == null) {
            return
        }
        printBackwards(node.next)
        print("$node ")
    }

    fun numOfNodes(): Int {
        var i = 0
        var node: NodeKt? = head
        while (node!!.next != null) {
            i += 1
            node = node.next
        }
        return i
    }


}
