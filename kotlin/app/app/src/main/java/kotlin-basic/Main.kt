fun main() {
    println(sum(10, 20))
    println(sum( b=10, a=30))
    // 함수 사용시 매개변수를 명시적으로 지정 가능. 순서 상관 x
}

// 코틀린의 함수
// fun으로 선언
// 매개변수는 반드시 타입 지정, 기본값을 지정해주고 사용시 값을 안넣을수도 있음. js방식
// 매개변수 선언부 다음에 : 타입  을 통해 리턴 타입을 지정해줄수 있음
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 간략화
fun sum2(a: Int, b: Int, c: Int =0) = a + b
