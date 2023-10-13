// 현재 숫자(문자)와 뒤의 숫자(문자)를 비교해서 더 크거나 작으면 
// 자리를 바꾸는 방식.
// 한 숫자가 제자리를 찾아가면 끝에서부터 하나씩 비교하지 않아도 괜찬
// (n-1) + (n-2) + ... + 2 +1 의 횟수를 반복.
// O(n2)의 성능. 성능은 좋지 않음.
// 대신 구현이 쉬움

function bubbleSort(arr){
    for(let i =0; i<arr.length-1; i++){
        for(let j =0; j<(arr.length -i -1); j++){
            if(arr[j] > arr[j+1]){
                let temp = arr[j];
                arr[j] = arr[j+1];
                arr[j +1] = temp;
            }
        }
    }
}

let arr = [3,1,4,5,2];
bubbleSort(arr);
console.log("정렬완료:" + arr);