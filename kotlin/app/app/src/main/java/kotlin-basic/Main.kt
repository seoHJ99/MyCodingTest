fun main() {
    val i = 5

    // if 문

    if (i > 10) {
        println("10보다 크다.")
    } else if (i < 10) {
        println("10보다 작다")
    } else {
        println("10이다.")
    }

    // when 문
    when {
        i > 10 -> {
            println("10보다 크다.")
        }
        i < 10 -> {
            println("10보다 작다")
        }
        else -> {
            println("10이다.")
        }
    }

    // if문 식 자체를 변수로 받을수 있음.
    // when 도 가능
    var result = if (i > 10) {
        "10보다 크다."
    } else if (i < 10) {
        "10보다 작다"
    } else {
        "10이다."
    }
    println(result)


    // 코틀린 삼항연산자
    var k = 5
    var result2 = if (k>10) true else false
}