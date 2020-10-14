package advnaced.coroutines


import kotlinx.coroutines.*
//https://kotlinlang.org/docs/reference/coroutines/basics.html
fun main() = runBlocking {
    launch {
        delay(1000L)
        println("Later")
    }
    println("Now")
}
