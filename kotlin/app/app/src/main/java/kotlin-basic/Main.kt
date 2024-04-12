
fun main() {
    // val name : String = null 불가능.
    // 코틀린에서는 null을 담을수 있는 변수를 선언하기 위해서는 타입 뒤에 ? 붙여줘야 함.
    var name : String? = null
    name = "준석"

    var name2 : String = ""
    name2 = name
    println(name2)

    // null을 못담는 변수에 강제적으로 null 값이 될수 있는 값을 담을수 있음
    // !! 를 뒤에 붙여주면 됨.
    // 하지만 이런 방식은 개발자가 직접 null 이 아님을 보증하는 것이지, 실제로 null을 강제로 담는 것이 아니기에
    // npe 가 터질수 있음
//    name = null
//    name2 = name
//    name2 = name!!
//    println(name2)

    // null 체크 함수
    // name 값이 null이 아닐때 실행
    name?.let{
        name2 = name
    }
}