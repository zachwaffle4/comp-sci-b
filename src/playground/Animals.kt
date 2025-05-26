package playground

abstract class AnimalKt() {
    open var name: String = "animal"

    abstract fun speak()
}

class DogKt(override var name: String) : AnimalKt() {
    override fun speak() {
        println("Woof")
    }
}

class CatKt(override var name: String) : AnimalKt() {
    override fun speak() {
        println("Meow")
    }
}