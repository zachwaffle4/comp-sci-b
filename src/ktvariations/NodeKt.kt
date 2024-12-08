package ktvariations

class NodeKt(var value: Any, var next: NodeKt?) {
    override fun toString(): String {
        return value.toString()
    }

    override operator fun equals(other: Any?): Boolean {
        if (other is NodeKt) {
            if (this.next == null && other.next == null) {
                return true
            }
            if (this.next == null || other.next == null) {
                return false
            }
            return this.value == other.value && this.next == other.next
        } else {
            return false
        }
    }
}
