

fun main() {
    var i = 10
    var l = 20L

//    l = i 불가능.
    l = i.toLong()
    i = l.toInt()

    var name = "10"
    i = name.toInt()
    
}