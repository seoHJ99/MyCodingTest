// 셋
// 데이터의 중복을 허용하지 않는 자료구조
// HashTable을 이용. HashTable의 Key 만 이용

// 추상자료형
// 1. add 데이터 삽입
// 2. isContain(data) 데이터 체크
// 3. remove(data) 데이터 제거
// 4. clear() 셋 비우기
// 5. isEmpty() 셋이 비었는지 체크
// 6. printAll() 모든 데이터 출력

import { HashTable } from "./HashTable.mjs";

class HashSet{
    constructor() {
        this.hashTable = new HashTable();
    }

    add(data){
        if(this.hashTable.get(data) == null){ // 여기선 key가 value
            this.hashTable.set(data, -1); // 기존 value는 의미없는 값이기에 -1
        }     
    }

    isContain(data){
        return this.hashTable.get(data) != null;
    }

    remove(data){
        this.hashTable.remove(data);
    }

    clear(){
        for(let i =0; i<this.hashTable.arr.length; i++){
            this.hashTable.arr[i].clear();
        }
    }

    isEmpty(){
        let empty = true;
        for(let i =0; i<this.hashTable.arr.length; i++){
            if(this.hashTable.arr[i].count>0){
                empty = false;
                break;
            }
        }
        return empty;
    }

    printAll(){
        for(let i =0; i< this.hashTable.arr.length; i++){
            let currentNode = this.hashTable.arr[i].head;
            while(currentNode != null){
                console.log(currentNode.data.key);
                currentNode = currentNode.next;
            }
        }
    }
}

export {HashSet};