package advnaced.nullsafety

fun main(args : Array<String>) {
   var employAddr: String ?= "London"

   // println(employAddr?.length?:"Value is null")

    employAddr?.let{ println("The value is: $it")}

    employAddr= null
    employAddr?.let{ println("The value is: $it")} //never gets executed since the value is null

//   var value= if(employAddr==null){
//       employAddr="-1"
//   }
//    else{
//       employAddr.length
//   }
}