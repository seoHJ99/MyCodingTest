fun main() {
    var john = Person("John", 20)
    var john2 = Person("John", 20)

    println(john)
    println(john2)
    print(john == john2) // true

    // 외부에서도 클래스 내부 필드 접근 가능
    john.hobby = "야구"

}

// equal 과 hashcod 함수를 재정의하지 않고도 같음을 비교하기 위한 키워드 data
data class Person(
    val name: String,
    var age: Int
){
    var hobby = "축구"

    init{
        println("생성됨")
    }
    
    // 아래 코드를 사용하지 않고도 구현 가능
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Person
//
//        if (name != other.name) return false
//        if (age != other.age) return false
//
//        return true
//    }
//
//    override fun hashCode(): Int {
//        var result = name.hashCode()
//        result = 31 * result + age
//        return result
//    }
}