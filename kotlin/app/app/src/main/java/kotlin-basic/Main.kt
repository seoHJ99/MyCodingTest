fun main() {
    val dog : Animal = Dog()
    val cat = Cat()


    // 강제 타입 변환 as
    // 오류가 발생할수 있음
    cat as Dog

}

interface Drawable{
    fun draw()
}

abstract class Animal{
    open fun move(){
        println("이동")
    }
}

class Dog : Animal(), Drawable {
    override fun move() {
        println("껑충")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }
}

class Cat : Animal()

