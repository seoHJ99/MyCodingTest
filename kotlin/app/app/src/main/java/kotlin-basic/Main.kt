fun main() {
    // new 키워드를 안쓰고도 객체 생성 가능
    var john = Person("John", 20)
    println(john.name)
    print(john.age)

    // val는 변경 불가능
    // 이것을 이용해서 getter/setter 만들면 됨
//    john.name = "ss"
    john.age = 23
}

// 클래스의 내부 필드는 괄호 안에 적음
// 길어질수 있기에 줄바꿈도 지원.
class Person(
    val name: String,
    var age: Int
)