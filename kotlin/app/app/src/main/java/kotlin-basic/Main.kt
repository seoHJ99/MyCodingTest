fun main() {
    val items = listOf(1, 2, 3, 4, 5)

    // js 의 for 문처럼 사용
    for (item in items) {
        println(item)
    }
    items.forEach { item -> println(item) }

    // 기존 java의 for문은 시작 숫자 .. 끝나는 숫자로 지정해주는 방식
    for(i in 0 .. 3){
        println(i)
    }

    for(i in 0 .. items.size-1){
        println(items[i])
    }

    // while문은 자바와 완전히 동일
}