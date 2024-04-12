fun main() {
//    val box = Box<Int>(10)
    val box = Box(10)
    val box2 = Box("dasfd")

    println(box.value)
}

class Box<T>(var value: T){

}

