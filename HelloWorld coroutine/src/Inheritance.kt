// In Kotlin, everything is final by default
// final says class cannot be inherited, methods cannot be overidden
// open keyword
// What is an open keyword
//
 open class baseClass{
    val name= "SpiderMan"
    open fun Sample(){
        println("This is base class")
    }
}
class derivedClass: baseClass(){
    override fun Sample(){
        println("This is base class from derived")
    }
    fun Sample2(){
        println("This is derived class")
    }
}

fun main(args : Array<String>) {
   val derivedClass = derivedClass()
    derivedClass.Sample()
    derivedClass.Sample2()
}