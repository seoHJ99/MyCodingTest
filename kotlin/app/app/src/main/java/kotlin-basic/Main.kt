fun main() {
//    myFunc({
//        println("함수 호출")
//    })
    // 매개변수 함수를 밖으로 꺼낼수 있음.
    // 매개변수가 함수 하나뿐일때 괄호도 생략 가능
    // 매개변수가 여러개이고 함수는 하나뿐이면, 함수는 밖으로 빼고 매개변수는 괄호 안에 적어줘야 함
    myFunc {
        println("함수 호출")
    }
}

// 매개변수 함수의 기본값이 지정되어 있으면 안써줘도 됨
fun myFunc(callback: () -> Unit = {}) {
    println("함수 시작")
    callback()
    println("함수 끝")
}


