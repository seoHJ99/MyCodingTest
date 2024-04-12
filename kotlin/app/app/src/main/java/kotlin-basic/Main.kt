abstract class Animal{  // abstract로 추상클래스로 만드는 대신 open 도 사용 가능.
    // 자바는 기본적으로 상속받은 함수를 오버라이딩 하는 둥의 모든 행동이 허용되지만,
    // 코틀린은 반대로 모두 막혀있기에 따로 이를 허용해 줘야만 한다.
    // open : 자식에서 접근 가능하게 하는 키워드
    open fun move(){
        println("이동")
    }
}

class Dog : Animal(){
    override fun move() {
        println("껑충")
    }
}

class Cat : Animal()

