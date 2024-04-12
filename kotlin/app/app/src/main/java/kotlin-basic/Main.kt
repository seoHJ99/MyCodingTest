interface Drawable{
    fun draw()
}

abstract class Animal{
    open fun move(){
        println("이동")
    }
}

// 인터페이스는 상속받을때 () 필요 없음
// 콤마(,) 를 통해 다중 상속 가능

class Dog : Animal(), Drawable {
    override fun move() {
        println("껑충")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }
}

class Cat : Animal()

