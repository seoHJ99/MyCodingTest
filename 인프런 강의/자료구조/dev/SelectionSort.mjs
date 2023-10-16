function selectionSort(arr) {
  for (let i = 0; i < arr.length - 1; i++) {
    let minIndex = i;
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[i] > arr[j]) {
        minIndex = j;
      }
    }
    let temp = arr[i];
    arr[i] = arr[minIndex];
    arr[minIndex] = temp;
  }
}

selectionSort([5, 3, 4, 1]);
// 선택정렬
// O(n2)의 성능
// 구현과 이해가 쉬운 장점
// 대신 성능이 나쁨
