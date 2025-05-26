package playground

fun gcf(a: Int, b: Int): Int {
    return if (b == 0) a else gcf(b, a % b)
}

class Fraction(val numerator: Int, val denominator: Int) {
    override fun equals(other: Any?): Boolean {
        return other is Fraction && this.simplified().hashCode() == other.simplified().hashCode()
    }

    fun simplified(): Fraction {
        val gcd = gcf(numerator, denominator)
        return Fraction(numerator / gcd, denominator / gcd)
    }

    override fun hashCode(): Int {
        var result = numerator
        result = 31 * result + denominator
        return result
    }

    operator fun plus(other: Fraction): Fraction {
        val numerator = this.numerator * other.denominator + this.denominator * other.numerator
        val denominator = this.denominator * other.denominator
        return Fraction(numerator, denominator).simplified()
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }
}

fun main() {
    val f1 = Fraction(1, 2)
    val f2 = Fraction(1, 3)
    println(f1 + f2)
}