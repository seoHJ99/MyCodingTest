function mergeSort(arr, leftIndex, rightIndex) {
  // leftIndex 는 시작 인덱스, rightIndex는 끝 인덱스
  // 둘이 같아질때까지, 즉 요소가 1개가 될때까지 배열을 쪼갬
  if (leftIndex < rightIndex) {
    let midIndex = parseInt((leftIndex + rightIndex) / 2);
    mergeSort(arr, leftIndex, midIndex);
    mergeSort(arr, midIndex + 1, rightIndex);
    // 중간으로 나눠서 각각 정렬.
    merge(arr, leftIndex, midIndex, rightIndex);
    // 둘을 다시 합침
  }
}

function merge(arr, leftIndex, midIndex, rightIndex) {
  // 각 left/rightIndex는 현재 배열의 어디인지, tempArrIndex는
  //전체 배열중 몇번째 인덱스까지 정렬완료 했는지 기록
  let leftAreaIndex = leftIndex;
  let rightAreaIndex = midIndex + 1;

  let tempArr = [];
  tempArr.length = rightIndex + 1;
  tempArr.fill(0, 0, rightAreaIndex + 1);

  let tempArrIndex = leftIndex;

  while (leftAreaIndex <= midIndex && rightAreaIndex <= rightIndex) {
    if (arr[leftAreaIndex] <= arr[rightAreaIndex]) {
      tempArr[tempArrIndex] = arr[leftAreaIndex++];
    } else {
      tempArr[tempArrIndex] = arr[rightAreaIndex++];
    }
    tempArrIndex++;
  }
  if (leftAreaIndex > midIndex) {
    for (let i = rightAreaIndex; i <= rightIndex; i++) {
      tempArr[tempArrIndex++] = arr[i];
    }
  } else {
    for (let i = leftAreaIndex; i <= midIndex; i++) {
      tempArr[tempArrIndex++] = arr[i];
    }
  }

  for (let i = leftIndex; i <= rightIndex; i++) {
    arr[i] = tempArr[i];
  }
}

let arr = [3, 5, 2, 4, 1, 7, 8, 6];

console.log("=== 정렬 전 ====");
console.log(arr);

console.log("=== 정렬 후 ====");
mergeSort(arr, 0, arr.length - 1);
console.log(arr);

// 병합정렬
// 데이터를 계속 쪼갤때마다 영역이 반으로 줌으로 logN
// 마지막 병합할때는 n개의 데이터를 n번 비교함으로 n의 성능
// 따라서 nlogn 의 성능
// 구현이 어렵지만 성능이 좋음
