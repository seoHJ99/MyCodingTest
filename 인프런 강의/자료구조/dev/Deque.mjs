// 덱
// 큐와 스택이 합쳐진 자료형
// 가장 앞이나 가장 뒤에 데이터를 저장하고 둘 중 어디에서나 데이터를
// 뽑을수 있음

// 덱의 추상자료형(인터페이스)
// printAll 모두 조회
// addFirst 헤드에 추가
// removeFirst 헤드에서 제거
// addLast 테일에 추가
// removeLast 테일에서 제거
// isEmpty 비었는지 확인

import { DoublyLinkedList } from "./DoublyLinkedList.mjs";

class Deque{
    constructor(){
        this.list = new DoublyLinkedList();
    }

    printAll(){
        this.list.printAll();
    }

    addFirst(data){
        this.list.insertAt(0,data);
    }

    removeFirst(){
        return this.list.deleteAt(0);
    }

    addLast(data){
        this.list.insertAt(this.list.count, data);
    }

    removeLast(data){
        return this.list.deleteLast();
    }

    isEmpty(){
        return (this.list.count ==0);
    }
}

export {Deque};