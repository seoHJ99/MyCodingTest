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
  let [modal, setModal] = useState(false);

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
        <h4
          onClick={() => {
            setModal(!modal);
          }}
        >
          {글제목[2]}
        </h4>
        <p>발행 날짜</p>
      </div>
      {modal ? <Modal></Modal> : null}
    </div>
  );
}

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
