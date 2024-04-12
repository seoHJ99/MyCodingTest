fun main() {
    // 변경이 불가능한 리스트 listOf
    val items = listOf(1, 2, 3, 4, 5)

    // 변경이 가능한 리스트 mutableListOf
    // 제네릭이 생략되어 있음.
    val  items2 = mutableListOf(1, 2, 3, 4, 5)

    items2.add(6)
    items2.remove(3)

}