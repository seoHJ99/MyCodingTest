import java.lang.Exception

fun main() {
    val items = arrayOf(1,2,3)
    // 0번째에 10 추가
    items.set(0, 10)
    items[0] = 10

    try {
        val item = items[3]
    }catch (e:Exception){
        println(e.message)
    }
}