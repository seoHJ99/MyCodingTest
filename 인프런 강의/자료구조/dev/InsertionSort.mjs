function insertionSort(arr) {
  for (let i = 1; i < arr.length; i++) {
    // 첫번째 원소는 이미 정렬되어 있다고 가정
    let insertData = arr[i];
    let j;
    for (j = i - 1; j >= 0; j--) {
      if (arr[j] > insertData) {
        arr[j + 1] = arr[j];
      } else {
        break;
      }
    }
    arr[j + 1] = insertData;
  }
}

let arr = [4, 2, 3, 7, 5, 6, 1];
console.log(arr);

insertionSort(arr);

console.log("정렬");
console.log(arr);

// O(n2)의 성능
