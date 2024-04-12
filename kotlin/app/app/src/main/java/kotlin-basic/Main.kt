fun main() {
    var john = Person("John", 20)
//    println(john.name)
    print(john.age)

}

class Person(
    // getter 도 제공하지 않기 위한 키워드 private
    // 클래스 외부에서 아예 접근 불가능.
    // 안적으면 기본적으로 public이 기본값
    private val name: String,
    var age: Int
)