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

  return (
    <div className="App">
      <div className="black-nav">
        <h4>블로그</h4>
      </div>

      <div className="list">
        <button
          onClick={() => {
            let copy = [...글제목];
            copy.sort();
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
      <Modal></Modal>
    </div>
    // 병렬적으로 태그를 쓰고 싶으면
    // <></> 로 감싸면 됨
  );
}

// 컴포넌트
// html 을 조각화 시킴
// 1. 반복적으로 자주 등장하거나
// 2. 큰 하나의 페이지
// 3. 자주 변경되는 것들
// 컴포넌트를 남발하면 안됨

const Modal2 = () => {};
// 이런 방식으로 함수를 만들면 함수를 수정할수 없어서
// 실수로 수정했을시 오류가 터진다는 이점

function Modal() {
  return (
    <div className="modal">
      <h4>제목</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
  );
}

export default App;
