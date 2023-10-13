// 연결리스트
// 연속된 공간에 저장함으로 인해 발생하는 쓰기/삭제의 어려움과 공간
// 낭비를 해결하기 위해 나온 새로운 배열 방식.
// 데이터 숫자만큼 노드를 만들어 노드에 데이터와 다음 노드의 위치를
// 가리키는 변수를 저장하는 방식.
// 이를 사용하면 중간에 데이터를 삽입하는데도 부담이 적고 빠르며
// 공간의 낭비가 발생하징 않는다.
// 단점. 중간 데이터 접근하기 위해서는 앞의 모든 데이터를 읽고 다음
// 노드를 찾아야하기에 느리다.
// 참조에 O(n)의 성능
// 삽입과 삭제에 O(n)의 성능
// 삽입과 삭제가 자주 일어날때 유리함

// 구현 기능
// 1. 전부 출력
// 2. 전부 삭제
// 3. 특정 인덱스에 삽입
// 4. 마지막에 추가
// 5. 특정 인덱스 삭제
// 6. 마지막 삭제
// 7. 특정 인덱스 읽기

class Node{
    constructor(data, next=null, prev = null){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList{
    constructor(){
        this.head = null; // 시작노드
        this.tail = null; // 끝 노드
        this.count = 0; // 총 노드 개수
    }

    printAll(){
        let currentNode = this.head;
        let text = "[";

        while(currentNode != null){
            text += currentNode.data;
            currentNode = currentNode.next;
            if(currentNode != null){
                text += ", ";
            }
        }

        text += "]";
        console.log(text);
    }

    clear(){
        this.head = null;
        this.count = 0;
    }
    
    insertAt(index, data){
        if(index > this.count || index < 0){
            // 0이하의 인덱스나 총 노드보다 큰 인덱스에 삽입하려고 할때 에러 발생
            throw new Error("범위를 넘어갔습니다.");
        }

        let newNode = new Node(data);

        if(index == 0){ // 앞쪽에 삽입하는 경우
            newNode.next = this.head;
            if(this.head != null){
                this.head.prev = newNode;
            }
            this.head = newNode;
        }else if(index == this.count){ // 뒤쪽에 삽입하는 경우 
            newNode.next = null;
            newNode.prev = this.tail;
            this.tail.next = newNode;
        }else{ // 그 외의 위치에 삽입하는 경우
            let currentNode = this.head;  
            for(let i =0; i<index - 1; i++){
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            newNode.prev = currentNode;
            currentNode.next = newNode;
            newNode.next.prev = newNode;
        }
        if(newNode.next == null){ //새로 삽입한 노드가 마지막일때
            this.tail = newNode;
        }
        this.count ++;
    }

    insertLast(data){
        this.insertAt(this.count, data);
    }

    deleteAt(index){
        if(index >= this.count || index<0){
            throw new Error("제거할 수 없습니다.");
        }
        let currentNode = this.head;

        if(index == 0){
            let deletedNode = this.head;
            if(this.head.next == null){ // 노드가 한개일때
                this.head = null;
                this.tail = null;
            }else{ // 데이터가 두개 이상일때
                this.head = this.head.next;
                this.head.prev = null;
            }
            this.count --;
            return deletedNode;
         }else if(index == this.count -1){ // 마지막 노드 삭제
            let deletedNode = this.tail;
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
            this.count--;
            return deletedNode;
         }else{ // 중간 노드를 삭제하는 경우
            for(let i=0; i<index-1; i++){
                currentNode = currentNode.next;
            }
            let deletedNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            currentNode.next.prev = currentNode;
            this.count--;
            return deletedNode;
        }
    }

    deleteLast(){
        return this.deleteAt(this.count -1);
    }

    getNodeAt(index){
        if(index >= this.count || index <0){
            throw new Error("범위를 넘어갔습니다.");
        }

        let currentNode = this.head;
        for(let i =0; i<index; i++){
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}

export{Node, DoublyLinkedList};