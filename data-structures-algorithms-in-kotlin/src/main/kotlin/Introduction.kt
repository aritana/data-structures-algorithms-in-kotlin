fun main(){
    println("oi mundo")

    //generics()
    // packageKotlin()
   // maps()
    mutableVsReadOnly()
}

fun noSideEffectList(names: List<String>) {
    println(names)
}

fun sideEffectList(names: MutableList<String>) {
    names.add("Joker")
}

fun mutableVsReadOnly() {
    val people = mutableListOf("Brian", "Stanley", "Ringo")
    noSideEffectList(people) // [Brian, Stanley, Ringo]
    sideEffectList(people)   // Adds a Joker to the list
    noSideEffectList(people) // [Brian, Stanley, Ringo, Joker]
}


fun maps() {
    val scores = mutableMapOf("Eric" to 9, "Mark" to 12, "Wayne" to 1)

    //new entry

    scores["Aritana"] = 3
    println(scores)
}

fun packageKotlin() {

    //LET helps you with null-checks and creates new local scope to safely perform operations

    class Car{
        var doors = 2
    }

    fun printCar(car : Car?){
        val isCoupe = car?.let{
            it.doors<=2
        }
        if (isCoupe == true) {
            println("Coupes are awesome")
        }
    }

    //Run provides the target object as this and isolates the block form the outer scope
    fun printCar2(car: Car?) {
        val isCoupe = car?.run {
            (this.doors <= 2)
        }
        if (isCoupe == true) {
            println("Coupes are awesome")
        }
    }

    val car = Car()
    printCar(car)
    printCar2(car)
    //These two functions are “transformational” functions

    //Also: returns the original object

    fun printCar3(car:Car?){
        car?.also{
            it.doors = 4
        }.let{
            if(it?.doors != null && it.doors <= 2){
                println("Coupes are awesome")
            }
        }
    }


    printCar3(car)

    //Apply:  It is an also that is isolated like a run. It returns the same object as the
    //target, and it uses this inside the block.

    fun printCar4(car:Car?){
        car?.apply {
            doors = 4  //this.doors
        }.let{
            if(it?.doors != null && it.doors <= 2){
                println("Coupes are awesome")
            }
        }
    }

    printCar4(car)

    //throws an error when the code reaches one of these TODOs.
    //TODO()

    //List
    val places = listOf("Paris", "London", "Bucharest")
    val mutablePlaces = mutableListOf("Paris","New York")
    

}

fun generics() {

    /*
    class Box {
        var content: Any?= null

        fun put (content: Any?){
            this.content = content
        }
        fun retrieve():Any?{
            return  content
        }

        fun isEmpty():Boolean{
            return  content == null
        }
    }
    */

    class Box<T>{
        var content: T? = null

        fun put(content:T?){
            this.content = content
        }

        fun retrieve():T?{
            return content
        }

        fun isEmpty():Boolean{
            return content == null
        }
    }

    val box = Box<Int>()
    box.put(4)

    val boolBox = Box<Boolean>()
    boolBox.put(true)
    boolBox.isEmpty()


}
