import java.util.Scanner

fun main() {
    // 자바 Scanner 대신 코틀린 Scanner 사용
    // in 은 코틀린에서 사용 불가능한 키워드여서 ``로 감싸줘야함.
    val reader = Scanner(System.`in`)
    reader.nextInt()
    reader.next()
}