// 스택
// FILO(first in last out)
// 먼저 들어온게 나중에 나가는 자료구조
// 이를 만족하기만 하면 어떤식으로 구현해도 됨

// 기존의 linkedList를 이용한 구현
// 구현기능
// 1. push 데이터 삽입
// 2. pop 데이터 제거
// 3. peek 데이터 참조
// 4. isEmpty 데이터가 존재하는지 확인

import { LinkedList } from "./linkedList.mjs";

class Stack{
    constructor(){
        this.list = new LinkedList();
    }

    push(data){
        this.list.insertAt(0, data);
    }

    pop(){
        try{
            return this.list.deleteAt(0);
        }catch(e){
            return null;
        }
    }

    peek(){
        return this.list.getNodeAt(0);
    }

    isEmpty(){
        return (this.list.count == 0);
    }
}

export {Stack};