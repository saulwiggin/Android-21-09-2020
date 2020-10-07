import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    var number = 99
    println(number);

    val range: Byte = 112
    println("$range")

    val score: Int =  100000
    println("$score")

    val distance = 999.5
    println("$distance")

    val numbers = intArrayOf(1, 4, 42, -3)

    if (4 in numbers) {
        println("numbers array contains 4.")
    }

    val a  = intArrayOf(1, 2, 3, 4, - 1)
    println(a[1])
    a[1]= 12
    println(a[1])

    val number1: Int = 545344
    val number2: Byte = number1.toByte()
    println("number1 = $number1")
    println("number2 = $number2")

    val reader = Scanner(System.`in`)
    print("Enter a number: ")

    var integer:Int = reader.nextInt()

    println("You entered: $integer")

    val n1 = 3
    val n2 = 5
    val n3 = -2

    val max = if (n1 > n2) {
        if (n1 > n3)
            n1
        else
            n3
    } else {
        if (n2 > n3)
            n2
        else
            n3
    }

    println("max = $max")

    val a1 = 12
    val b1 = 5

    println("Enter operator either +, -, * or /")
    val operator = readLine()

    val result = when (operator) {
        "+" -> a1 + b1
        "-" -> a1 - b1
        "*" -> a1 * b1
        "/" -> a1 / b1
        else -> "$operator operator is invalid operator."
    }

    println("result = $result")


    // Iterating through an array
    var language = arrayOf("Ruby", "Koltin", "Python", "Java")

    for (item in language)
        println(item)

}

fun sayHello(){
    println("Hello");
}

/** Add two numbers
        **/
fun addNumbers(number: Double, number2: Int){

}

var language = "French"
val score = 95


