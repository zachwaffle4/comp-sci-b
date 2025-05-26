package binarytrees

class BinaryTreeKt<E : Any>(
    var value: E,
    var left: BinaryTreeKt<E>? = null,
    var right: BinaryTreeKt<E>? = null
) {

    fun size(): Int {
        return 1 + (left?.size() ?: 0) + (right?.size() ?: 0)
    }

    fun root(): E {
        return value
    }

    fun isLeaf(): Boolean {
        return left == null && right == null
    }

    fun height(): Int {
        return 1 + maxOf(left?.height() ?: 0, right?.height() ?: 0)
    }

    fun fold(init: E, f: (E, E) -> E): E {
        return f(value, (left?.fold(init, f) ?: init))
    }

    fun map(f: (E) -> E): BinaryTreeKt<E> {
        return BinaryTreeKt(f(value), left?.map(f), right?.map(f))
    }
}
