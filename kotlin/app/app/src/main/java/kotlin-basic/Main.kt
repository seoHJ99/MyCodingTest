fun main() {
    var john = Person("John", 20)

    println(john.hobby)

}

class Person(
    val name: String,
    var age: Int
){
    var hobby = "축구"
        private set // set 함수 접근 불가능하게 만듬.
        get() = "취미: $field"  // getter 함수의 재정의. return 값에 문자열 넣음.

    init{
        println("생성됨")
    }

}