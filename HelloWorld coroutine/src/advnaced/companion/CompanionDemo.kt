package advnaced.companion

//public static final String BASE_URL= "HTTP://CAKES";

class CompanionDemo{
    companion object {
        var employeeID: Int= 10044

        @JvmStatic fun callEmplyee2() {
            println(employeeID)
        }
        fun callEmplyee(){
            println(employeeID)
        }

    }
}
fun main(args: Array<String>){
    println(CompanionDemo.employeeID)
    println(CompanionDemo.callEmplyee())
    println(CompanionDemo.callEmplyee2())

}