package collection.list


fun main() {


//    val myList = listOf(1, 2, 2, 3, 4)





//    for (i in myList) {
//        println(i)
//    }
//
//
//
//    myList.firstOrNull()
//
//
//    var myMap = mapOf<String, Int>("11" to 22, "23" to 433)
//    for (item in myMap) {
//
//        item.key
//        item.value
//
//    }
//
//
//    var mySet = setOf(1, 3, 3, 3)
//
//    mySet.forEach {
//        println(it)
//    }


//   val  item= myList.elementAtOrNull(23)
//   val  item= myList.elementAtOrElse(23){
//        2
//   }


//    val strList= listOf<String>("1","3")
//    val item = strList.firstOrNull{it.length>3}
//    val single = strList.single { it.length < 3 }
//    strList.getOrElse(1) { 2 }
//    strList.getOrNull(index = 1)
//    print(item)

    data class Person(
        var name: String = "",
        var age: Int = 0,
        var salary: Double = 0.0

    ) {
        override fun toString(): String {
            return "Person(name='$name', age=$age, salary=$salary)"
        }
    }

    val persons = mutableListOf(

        Person("n2", 24, 4000.0),
        Person("n1", 20, 2000.0),
        Person("n3", 28, 6000.0),
        Person("n4", 26, 8000.0),
        Person("n5", 34, 7000.0),
        Person("n6", 21, 5000.0)
    )

    val sortedBy = persons.toList().sortedBy {
        when (it.age) {
            20 -> -1
            21 -> 0
            else -> 1
        }

    }


    sortedBy.forEach(){
        println(it.toString())
    }
}
