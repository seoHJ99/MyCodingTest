/* eslint-disable */

import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  let post = "강남 강남";
  let [글제목, 글제목변경] = useState([
    "남자 코트 추천",
    "글제목 2",
    "글제목 3",
  ]);
  let [좋아요, 좋아요변경] = useState(0);

  // state 상태의 array 를 변경할때는 복사본을 만들어서 복사본을 수정하기.
  // state 변경 함수는 기존 state와 변경하려는 데이터가 같으면 변경x
  // 따라서 array 의 copy본은 메모리 주소가 같기에 바뀌지 않음
  // 만약 array의 내부 데이터를 복사하고 싶으면 [...배열 이름] 과 같은 식으로 사용해야함
  // [...]은 아예 새로운 메모리 주소에 데이터를 할당하는 방식
  // 안그러면 원본 데이터마저 손상됨

  return (
    <div className="App">
      <div className="black-nav">
        <h4>블로그</h4>
      </div>

      <div className="list">
        <button
          onClick={() => {
            let copy = [...글제목.sort()];
            글제목변경(copy);
          }}
        >
          가나다순정렬
        </button>
        <h4>
          {글제목[0]}
          <span
            onClick={() => {
              좋아요변경(++좋아요);
            }}
          >
            😊
          </span>{" "}
          {좋아요}
        </h4>
        <p>발행 날짜</p>
        <button
          onClick={() => {
            let copy = [...글제목];
            copy[0] = "여자 코트 추천";
            글제목변경(copy);
          }}
        >
          이름 변경
        </button>
      </div>
      <div className="list">
        <h4>{글제목[1]}</h4>
        <p>발행 날짜</p>
      </div>
      <div className="list">
        <h4>{글제목[2]}</h4>
        <p>발행 날짜</p>
      </div>
    </div>
  );
}

export default App;
