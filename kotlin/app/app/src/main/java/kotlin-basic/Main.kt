fun main() {
    val dog : Animal = Dog()
    val cat = Cat()

//    dog.draw()
    if(dog is Dog){
        // is를 통과하며 형변환이 이뤄져서 draw 를 사용할수 있음.
        dog.draw()
        println("강아지")
    }
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

