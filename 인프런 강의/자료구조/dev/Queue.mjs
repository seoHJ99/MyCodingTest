// 큐
// FIFO(first in first out)
// 순서대로 실행하는 자료구조
// 기존의 단방향 연결 리스트로 구현한 큐는
// 중간값에 곧바로 접근이 불가능하기에
// 비효율적.
// 양방향 리스트를 만들어 구현

// 큐의 추상자료형(인터페이스)
// 1. enqueue 데이터 삽입
// 2. dequeue 데이터 제거
// 3. front 데이터 조회
// 4. isEmpty 비었는지 확인

import { DoublyLinkedList } from "./DoublyLinkedList.mjs";

class Queue{
    constructor(){
        this.list = new DoublyLinkedList();
    }

    enqueue(data){
        this.list.insertAt(0,data);
    }

    dequeue(){
        try{
            return this.list.deleteLast();
        }catch(e){
            return null;
        }
    }
    
    front(){
        return this.list.tail;
    }

    isEmpty(){
        return (this.list.count == 0);
    }
}

export {Queue};