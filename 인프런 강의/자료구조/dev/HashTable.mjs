// 해시 테이블
// 인덱스를 key로 가지는 테이블이나 key값에 hash함수를 적용하여 총 인덱스의 크기를 줄이고
// 사전에 예상 불가능한 값으로 key를 변환, 인덱스의 크기를 줄인 자료구조
// 해쉬함수를 적용한 key값이 같다면 key값 내부에 연결리스트 형태로
// 데이터를 저장. O(n)의 조회 성능을 가짐
// 장점
// 빠른 데이터 읽기, 삽입, 삭제
// 단점
// 공간 낭비가 큼
// 해시함수의 성능에 따라 성능 차이가 남

// 해시테이블의 추상자료형(구현 기능)
// 1. set 데이터 삽입
// 2. get 데이터 조회
// 3. remove 데이터 삭제

import { DoublyLinkedList } from "./DoublyLinkedList.mjs";

class HashData{
    constructor(key, value){
        this.key = key;
        this.value = value;
    }
}

class HashTable{
    constructor(){
        this.arr = [];
        for(let i =0; i<10; i++){
            this.arr[i] = new DoublyLinkedList();
        }
    }

    hashFunction(number){
        return number%10; // 간단하게 예시로 만든 해시 함수
    }

    set(key, value){
        this.arr[this.hashFunction(key)].insertAt(0, new HashData(key, value));
    }
    
    get(key){
        let currentNode = this.arr[this.hashFunction(key)].head;
        while(currentNode !=null){
            if(currentNode.data.key == key){
                return currentNode.data.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    remove(key){
        let list = this.arr[this.hashFunction(key)];
        let currentNode = list.head;
        let deletedIndex = 0;
        while(currentNode != null){
            if(currentNode.data.key == key){
                return list.deleteAt(deletedIndex);
            }
            currentNode = currentNode.next;
            deletedIndex++;
        }
        return null;
    }
}

export {HashTable};